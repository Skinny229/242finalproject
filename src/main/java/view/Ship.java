  
public class Ship
{
       private int row;
       private int col;
       private int length;
       private String direction;
      
       public static final int NOTSET = -1;
       public static final int HORIZONTAL = 0;
       public static final int VERTICAL = 1;
      
       public Ship(int l)
       {
           length = l;
           row = NOTSET;
           col = NOTSET;
       }
       
       // Sets the location of the ship on the grid 
  
       public void setLocation(int r, int c)
       {
           row = r;
           col = c;
       }
      
       // Sets the direction of the ship 
  
       public void setDirection(int d)
       {
          if(d == HORIZONTAL)
          {
              direction = "horizontal";
          }
           if(d == VERTICAL)
           {
              direction = "vertical";
          } if (d == NOTSET)
          {
              direction = "unset";
          }
          
       }
       public int getRow()
       {
           return row;
       }
       public int getCol()
       {
           return col;
       }
       public int getLength()
       {
           return length;
       }
       
       // Determines the direction of the ship 
  
       public int getDirection()
       {
           if (direction == "horizontal")
           {
               return HORIZONTAL;
           }
           if(direction == "vertical")
           {
               return VERTICAL;
           }
           return NOTSET;
       }
      
    private String directionToString()
    {
         if(direction == null)
         {
             return "unset direction";
         }
         return direction;
    }
      
       private String locationToString()
       {
           if(this.isLocationSet() == false)
           {
           return "unset location";
           }
           return  row + ", " + col;
       }
       
       public String toString()
       {
           return directionToString() + " ship of length " + length + " at " + "(" + locationToString() + ")";
       }
      
       // Checks if the location and direction are set
  
       public boolean isLocationSet()
       {
           if (row == -1 || col == -1)
           {
               return false;
           }
           return true;
       }
       
       public boolean isDirectionSet()
       {
           if (direction == null)
           {
               return false;
           }
           return true;
       }
}
