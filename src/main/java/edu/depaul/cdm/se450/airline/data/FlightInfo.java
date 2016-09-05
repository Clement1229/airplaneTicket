package edu.depaul.cdm.se450.airline.data;

import java.util.List;
import java.util.Objects;

public class FlightInfo {
    private final String flightNum;

    public String getFlightNum() {
        return flightNum;
    }
    private final Airport origination;
    private final Airport destination;
    private final String flightTime;
    private List<AirplaneSeat> seats;

    public FlightInfo(String flightNum, Airport origination, Airport destination, String flightTime) {
        this.flightNum = flightNum;
        this.origination = origination;
        this.destination = destination;
        this.flightTime = flightTime;
    }
    
    public Airport getOrigination() {
        return origination;
    }

    public Airport getDestination() {
        return destination;
    }

    public String getFlightTime() {
        return flightTime;
    }


    public List<AirplaneSeat> getSeats() {
        return seats;
    }

    public void setSeats(List<AirplaneSeat> seats) {
        this.seats = seats;
    }    

    @Override
    public String toString() {
        return "FlightInfo{" + "origination=" + origination + ", destination=" + destination + ", flightTime=" + flightTime + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.flightNum);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FlightInfo other = (FlightInfo) obj;
        return Objects.equals(this.flightNum, other.flightNum);
    }
    
    
}
