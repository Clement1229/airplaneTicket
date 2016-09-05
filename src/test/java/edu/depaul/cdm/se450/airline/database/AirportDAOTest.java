package edu.depaul.cdm.se450.airline.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test methods to test query for available flight service
 */
public class AirportDAOTest {

    private static Connection conn;

    @BeforeClass
    public static void setUpClass() throws ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("driver.properties");
        try {
            properties.load(stream);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        String driverClassName = properties.getProperty("driver.class");
        String dsn = properties.getProperty("driver.dsn");
        String userId = properties.getProperty("driver.uid");
        String password = properties.getProperty("driver.password");
        Class.forName(driverClassName);

        conn = DriverManager.getConnection(dsn, userId, password);
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE FLIGHT_INFO(FLIGHTID INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,AIRLINE VARCHAR(6), FLIGHT_NUM VARCHAR(6),ORIGIN_AIRPORT VARCHAR(5),DEST_AIRPORT VARCHAR(6),FLIGHT_TIME VARCHAR(10))");

        PreparedStatement insertStmt = conn.prepareStatement("insert into FLIGHT_INFO (AIRLINE, FLIGHT_NUM, ORIGIN_AIRPORT,DEST_AIRPORT, FLIGHT_TIME) values('UA', ?, ?, ?, ?)");

        insertStmt.setString(1, "UA11");
        insertStmt.setString(2, "ORD");
        insertStmt.setString(3, "MIA");
        insertStmt.setString(4, "1:00pm");
        insertStmt.execute();

        insertStmt.setString(1, "UA12");
        insertStmt.setString(2, "ORD");
        insertStmt.setString(3, "MIA");
        insertStmt.setString(4, "3:00pm");
        insertStmt.execute();

        insertStmt.setString(1, "UA13");
        insertStmt.setString(2, "ORD");
        insertStmt.setString(3, "MIA");
        insertStmt.setString(4, "5:00pm");
        insertStmt.execute();

        insertStmt = conn.prepareStatement("insert into FLIGHT_INFO (AIRLINE, FLIGHT_NUM, ORIGIN_AIRPORT,DEST_AIRPORT, FLIGHT_TIME) values('AA', ?, ?, ?, ?)");
        insertStmt.setString(1, "AA11");
        insertStmt.setString(2, "ORD");
        insertStmt.setString(3, "MIA");
        insertStmt.setString(4, "9:00am");
        insertStmt.execute();

        insertStmt.setString(1, "UA12");
        insertStmt.setString(2, "ORD");
        insertStmt.setString(3, "MIA");
        insertStmt.setString(4, "11:00pm");
        insertStmt.execute();

        insertStmt.setString(1, "UA13");
        insertStmt.setString(2, "ORD");
        insertStmt.setString(3, "MIA");
        insertStmt.setString(4, "2:00pm");
        insertStmt.execute();

        stmt.execute("CREATE TABLE AIRPORT_AIRLINE(AA_ID INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL,AIRPORT VARCHAR(6), AIRLINE VARCHAR(6))");

        stmt.execute("insert into AIRPORT_AIRLINE (AIRPORT, AIRLINE) values('ORD', 'UA')");
        stmt.execute("insert into AIRPORT_AIRLINE (AIRPORT, AIRLINE) values('ORD', 'AA')");
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private AirportDAO instance;

    @Before
    public void setUp() {
        instance = new AirportDAO(conn);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAirportsServiced() {
        boolean expResult = true;
        boolean result = instance.isAirportServicedBy("UA", "ORD");
        assertEquals(expResult, result);
    }

    /**
     * Test situation where the airline is NOT supposed to be serviced at an
     * airport
     */
    @Test
    public void testGetAirportsNotServiced() {
        boolean expResult = false;
        boolean result = instance.isAirportServicedBy("UA", "SAN");
        assertEquals(expResult, result);
    }

    @Test
    public void testGetFlightsForAirline() {
        int expResult = 3;
        int numOfRows = instance.getFlightsFor("UA").size();
        assertEquals(expResult, numOfRows);
    }

    /**
     * Test situation where the airline is NOT supposed to be serviced at an
     * airport
     */
    @Test
    public void testGetAirportsNotServicedInList() {
        int expResult = 0;
        int numOfRows = instance.getFlightsFor("UA", "SAN", "ORD").size();
        assertEquals(expResult, numOfRows);
    }

    /**
     * Test situation where the airline is NOT supposed to be serviced at an
     * airport
     */
    @Test
    public void testGetAirportsServicedInList() {
        int expResult = 3;
        int numOfRows = instance.getFlightsFor("UA", "ORD", "MIA").size();
        assertEquals(expResult, numOfRows);
    }
}