package edu.depaul.cdm.se450.airline.mockdata;

import edu.depaul.cdm.se450.airline.data.SeatData;
import org.junit.Test;
import static org.junit.Assert.*;

public class Mock737SeatDataTest {
    
    private final SeatData instance = new Mock737SeatData();

    @Test
    public void testAvailableSeat() {
        boolean expResult = true;
        boolean result = instance.isSeatAvailable("UA123", 2, "A");
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUnavailableSeat() {
        boolean expResult = false;
        boolean result = instance.isSeatAvailable("UA123", 3, "A");
        assertEquals(expResult, result);
    }
}
