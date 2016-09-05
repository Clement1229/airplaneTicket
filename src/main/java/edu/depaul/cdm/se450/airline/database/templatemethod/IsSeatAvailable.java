package edu.depaul.cdm.se450.airline.database.templatemethod;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IsSeatAvailable extends AbstractTemplate {
    private final String fligthNum;
    private final int row;
    private final String aisle;
    private boolean result;
    
    public IsSeatAvailable(Connection con, String fligthNum, int row, String aisle) {
        super(con);
        this.fligthNum = fligthNum;
        this.row = row;
        this.aisle = aisle;
    }
    
    @Override
    protected String getSQL() {
                    StringBuilder sqlToExecute = new StringBuilder("select is_available from AIRPLANE_SEAT where FLIGHT_NUM='" + fligthNum + "' ");
            sqlToExecute.append(" and SEATNUMBER='");
            sqlToExecute.append(row);
            sqlToExecute.append(aisle);
            sqlToExecute.append("'");

            return sqlToExecute.toString();
    }

    @Override
    protected void processResultSet(ResultSet rs) throws SQLException {
        result = rs.getBoolean("is_available");
    }
    
    public boolean getResult() {
        runQuery();
        return result;
    }
    
}
