package edu.depaul.cdm.se450.airline.database.command;

public interface Command {
    public void execute();
    
    public Object getResult();
}
