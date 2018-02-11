package com.kodilla.jdbc;

import org.junit.Test;
import java.sql.*;

import static org.junit.Assert.*;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        // Given
        DbManager dbm = DbManager.getInstance();

        // When
        Connection conn = dbm.getConnection();

        // Then
        assertNotNull(conn);
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();

        assertEquals(5, counter);
    }

    // Essential data and some metadata obtained from query result
    //@Test
    public void testSelectUsersAndPostsAsStatement() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT U.FIRSTNAME AS FIRST_NAME, U.LASTNAME AS LAST_NAME, COUNT(U.ID) AS USER_POSTS " +
                          "FROM USERS U JOIN POSTS P ON U.ID = P.USER_ID " +
                          "GROUP BY U.ID " +
                          "HAVING USER_POSTS >= 2 " +
                          "ORDER BY LAST_NAME, FIRST_NAME, USER_POSTS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        ResultSetMetaData rsmd = rs.getMetaData();

        //Then
        assertEquals(3, rsmd.getColumnCount());
        assertEquals("FIRSTNAME", rsmd.getColumnName(1));
        assertEquals("LASTNAME", rsmd.getColumnName(2));
        assertEquals("USER_POSTS", rsmd.getColumnName(3));
        assertEquals("FIRST_NAME", rsmd.getColumnLabel(1));
        assertEquals("LAST_NAME", rsmd.getColumnLabel(2));
        assertEquals("USER_POSTS", rsmd.getColumnLabel(3));

        assertTrue(rs.next());
        assertEquals("Zachary", rs.getString(1));
        assertEquals("Lee", rs.getString(2));
        assertEquals(2, rs.getInt(3));
        assertTrue(rs.next());
        assertEquals("John", rs.getString(1));
        assertEquals("Smith", rs.getString(2));
        assertEquals(2, rs.getInt(3));
        assertFalse(rs.next());

        rs.close();
        statement.close();
    }
}
