package model;

public enum Direction 
{
    // Different types of directions to place the ships
    
    UP("UP"),DOWN("DOWN"),LEFT("LEFT"),RIGHT("RIGHT");

    private String direction;
    private Direction(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString(){
        return direction;
    }

    }
