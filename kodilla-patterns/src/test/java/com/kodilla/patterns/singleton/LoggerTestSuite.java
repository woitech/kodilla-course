package com.kodilla.patterns.singleton;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class LoggerTestSuite {
    private static Logger logger;

    @BeforeClass
    public static void initCommonLoggerReferenceVariable() {
        logger = Logger.getInstance();
    }

    @Test
    public void testSingleInstance() {
        // Given
        // When
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Then
        assertSame(logger1, logger2);
    }

    @Test
    public void testGetLastLog() {
        // Given
        String logContent = "yet annother code line";
        logger.log(logContent);

        // When
        String lastLog = logger.getLastLog();

        // Then
        assertEquals(logContent, lastLog);
    }
}
