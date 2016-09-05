package edu.depaul.cdm.se450.airline.data;

/*
Airport information
*/
public class Airport {
    private String airportCode;
    private String airportName;
    private String city;
    private String state;

    public Airport(String airportCode, String airportName, String city, String state) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.state = state;
    }

    /**
     * @return the airportCode
     */
    public String getAirportCode() {
        return airportCode;
    }

    /**
     * @param airportCode the airportCode to set
     */
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    /**
     * @return the airportName
     */
    public String getAirportName() {
        return airportName;
    }

    /**
     * @param airportName the airportName to set
     */
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
}
