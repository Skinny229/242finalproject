public class Location
{
    public static final int NOTGUESSED = 0;
    public static final int HIT = 1;
    public static final int MISSED = 2;
    private boolean hasShip;
    private int status;
    
    // Location constructor
    
    public Location()
    {
        status = 0;
    }

    // Checks if the location a hit
    
    public boolean checkHit() 
    {
        if (status == 1) 
        {
            return true;
        }
        return false;
    }

    // Checks if the location is a miss
    
    public boolean checkMiss() 
    {
        if (status == 2 ) 
        {
            return true;
        }
        return false;
    }

    // Checks if the location was not guessed
    
    public boolean isNotguessed()
    {
        if (status == 0)
        {
            return true;
        }
        else return false;
    }

    // Marks a location as a hit
    
    public void markHit() 
    {
        status = 1;
    }

    // Marks a location as a miss
    
    public void markMiss() 
    {
        status = 2;
    }

    // Returns whether or not a location has a ship
    
    public boolean hasShip()
    {
        if (hasShip == true) 
        {
            return true;
        }
        return false;
    }

    // Sets the value of whether a location has a ship
    
    public void setShip(boolean val) {
        hasShip = true;
    }

    // Sets the status of a location
    
    public void setStatus(int status) 
    {
        this.status = status;
    }

    // Gets the status of a location
    
    public int getStatus()
    {
        return status;
    }

    }