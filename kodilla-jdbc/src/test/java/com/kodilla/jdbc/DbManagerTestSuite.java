package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        // Given
        DbManager dbm = DbManager.getInstance();

        // When
        Connection conn = dbm.getConnection();

        // Then
        Assert.assertNotNull(conn);
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
        Assert.assertEquals(5, counter);
    }
}
