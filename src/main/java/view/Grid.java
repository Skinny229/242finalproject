package view;

public class Grid
{
   /*
private Location[][] grid;

// Number of rows and columns

public static final int NUM_ROWS = 8;
public static final int NUM_COLS = 8;

// Creates a new Grid
// Initializes each location in the grid

public Grid() {
    grid = new Location[NUM_COLS][NUM_ROWS];
    for (int y = 0; y < NUM_ROWS; y++) {
        for (int x = 0; x < NUM_COLS; x++) {
            grid[x][y] = new Location();
        }
    }
}

// Marks a hit in a location by calling the markHit method

public void markHit(int row, int col) {
    grid[col][row].markHit();
}

// Marks a miss in a location. 

public void markMiss(int row, int col) {
    grid[col][row].markMiss();
}

// Sets the status of the location object.

public void setStatus(int row, int col, int status) {
    grid[col][row].setStatus(status);
}

// Gets the status of the location in the grid 

public int getStatus(int row, int col) {
    return grid[col][row].getStatus();
}

// Return whether or not a location has already been guessed.

public boolean alreadyGuessed(int row, int col){
    return !grid[col][row].isUnguessed();
}  

// Set whether or not there is a ship at a location 

public void setShip(int row, int col, boolean val) {
    grid[col][row].setShip(val);
}

// Returns whether or not there is a ship here   

public boolean hasShip(int row, int col){
    return grid[col][row].hasShip();
}


// Gets the Location object at row and column position

public Location get(int row, int col){
    return grid[col][row];
}

// Return the number of rows in the grid

public int numRows() {
    return NUM_ROWS;
}

// Return the number of columns in the grid

public int numCols(){
    return NUM_COLS;
}

// Print the grid status 
// If there is no guess prints A 
// If it was a miss prints a O
// If it was a hit, prints an X

public void printStatus() {
    String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"};
    System.out.print("");
    for (int i = 0; i < NUM_COLS; i++) {
        if (i != 9) {
        System.out.print((i + 1) + " ");
        }
        else System.out.print(i+1);
    }
    System.out.println("");
    
    for (int y = 0; y < NUM_ROWS; y++) {
        System.out.print(alpha[y] + " ");
        for (int x = 0; x < NUM_COLS; x++) {
            if (grid[x][y].checkHit()) {
                System.out.print("X ");
            }
            else if (grid[x][y].checkMiss()) {
                System.out.print("O ");
            }
            else System.out.print("- ");
        }
        System.out.println("");
    }
}

// Print the grid and whether there is a ship at each location.
// If there is no ship, it will print an A 
// if there is a ship it will print an X 

public void printShips() {
    String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"};
    System.out.print("");
    for (int i = 0; i < NUM_COLS; i++) {
        if (i != 9) {
        System.out.print((i + 1) + " ");
        }
        else System.out.print(i+1);
    }
    System.out.println("");
    
    for (int y = 0; y < NUM_ROWS; y++) {
        System.out.print(alpha[y] + " ");
        for (int x = 0; x < NUM_COLS; x++) {
            if (grid[x][y].hasShip()) {
                System.out.print("X ");
            }
            else System.out.print("- ");
        }
        System.out.println("");
    }
}

    public void addShip(Ship s) {
        int length = s.getLength();
        int dir = s.getDirection();
        int row = s.getRow();
        int col = s.getCol();
        
        if (dir == 1) {
            for (int y = row; y < (s.getLength() + row); y++) {
                setShip(y, col, true);
            }
        }
        else {
            for (int x = col; x < (s.getLength() + col); x++) {
                setShip(row, x, true);
            }
        }
    }

    */
}
