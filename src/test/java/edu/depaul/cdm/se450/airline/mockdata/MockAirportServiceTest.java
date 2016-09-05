package edu.depaul.cdm.se450.airline.mockdata;

import edu.depaul.cdm.se450.airline.mockdata.MockAirportService;
import org.junit.Test;
import static org.junit.Assert.*;

public class MockAirportServiceTest {
    private MockAirportService instance = new MockAirportService();

    /**
     * Test situation where the airline is supposed to be serviced at an airport
     */
    @Test
    public void testGetAirportsServiced() {
        boolean expResult = true;
        boolean result = instance.isAirportServicedBy("UA", "ORD");
        assertEquals(expResult, result);
    }

    /**
     * Test situation where the airline is NOT supposed to be serviced at an airport
     */
    @Test
    public void testGetAirportsNotServiced() {
        boolean expResult = false;
        boolean result = instance.isAirportServicedBy("UA", "SAN");
        assertEquals(expResult, result);
    }

    /**
     * Test situation where the airline is NOT supposed to be serviced at an airport
     */
    @Test
    public void testGetAirportsNotServicedInList() {
        int expResult = 0;
        int numOfRows = instance.getFlightsFor("UA", "SAN", "ORD").size();
        assertEquals(expResult, numOfRows);
    }

    /**
     * Test situation where the airline is NOT supposed to be serviced at an airport
     */
    @Test
    public void testGetAirportsServicedInList() {
        int expResult = 3;
        int numOfRows = instance.getFlightsFor("UA", "ORD", "MIA").size();
        assertEquals(expResult, numOfRows);
    }
    
}
