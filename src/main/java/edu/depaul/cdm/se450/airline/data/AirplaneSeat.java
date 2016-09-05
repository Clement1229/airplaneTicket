package edu.depaul.cdm.se450.airline.data;

import java.util.Objects;

public class AirplaneSeat {
    private final String seatNum;
    private boolean available;

    public AirplaneSeat(String seatNum, boolean available) {
        this.seatNum = seatNum;
        this.available = available;
    }

    /**
     * @return the seatNum
     */
    public String getSeatNum() {
        return seatNum;
    }

    /**
     * @return the isAvailable
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param isAvailable the isAvailable to set
     */
    public void setAvailable(boolean isAvailable) {
        this.available = isAvailable;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.seatNum);
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
        final AirplaneSeat other = (AirplaneSeat) obj;
        if (!Objects.equals(this.seatNum, other.seatNum)) {
            return false;
        }
        if (this.available != other.available) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AirplaneSeat{" + "seatNum=" + seatNum + ", available=" + available + '}';
    }
    
    
}
