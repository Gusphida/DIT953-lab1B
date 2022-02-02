import java.awt.*;
/**
 * The ACar program implements the groundwork for creating car classes
 *
 * @Author Grupp 5: Philip Dahlgren, Ahmad Rasoli, Mona Chabokdavan
 * @since 24-01-2022
 *
 **/

public abstract class ACar implements Movable {

    enum Direction {
        RIGHT, LEFT, UP, DOWN
    }

    protected Direction direction = Direction.UP;
    protected Point.Double position = new Point.Double(); //default point for the car, x=0,y=0


    public int nrDoors; // Number of doors on the car
    public double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    public Color color; // Color of the car
    public String modelName; // The car model name
    public boolean transportable; //Able to be transported or not

    //---------Getters-----------

    /**
     * Returns the number of doors on the car
     * @return the number of doors the car has
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Returns the car's engine power
     * @return the car's engine power
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Returns the current speed of the car
     * @return the car's current speed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Returns the color of the car
     * @return the cars color
     */
    public Color getColor() {
        return color;
    }

    //----------Setters-----------

    /**
     * Changes the color of the car
     */
    public void setColor(Color clr) {
        color = clr;
    }

    //---------Functions----------

    /**
     * Sets the currentSpeed to 0.1, default
     */
    public void startEngine() {
        //Sets currentSpeed to default
        currentSpeed = 0.1;
    }

    /**
     * Sets currentSpeed to 0
     */
    public void stopEngine() {
        //Sets currentSpeed to 0
        currentSpeed = 0;
    }

    /**
     * Gives the speed factor for this car
     * @return the speed factor of this car
     */
    public double speedFactor() {
        //Returns a double
        return enginePower * 0.01;
    }

    /**
     * Increases current speed of the car
     */
    public void incrementSpeed ( double amount){
        //Increases currentSpeed as long as it's less than enginePower
        double increase = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        if (currentSpeed <= increase && increase >= 0) {
            currentSpeed = increase;
        }
    }

    /**
     * Decreases the current speed of the car
     */
    public void decrementSpeed ( double amount){
        //Decreases currentSpeed as long as it's over or equal to 0
        double decrease = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
        if (currentSpeed >= decrease && decrease <= enginePower) {
            currentSpeed = decrease;
        }
    }

    /**
     * Increases the cars current speed based on an interval of 0 to 1
     */
    public void gas ( double amount){
        //Calls on incrementSpeed within an interval of 0 to 1
        if (amount <= 1 && amount >= 0) {
            incrementSpeed(amount);
        }
    }

    /**
     * Decreases the cars current speed based on an interval of 0 to 1
     * */
    public void brake ( double amount){
        //Calls on decrementSpeed within an interval of 0 to 1
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount);
        }
    }

    /**
     * Changes the car's direction to the left based on what direction it's going in
     */
    @Override
    public void turnLeft() {
        //Changes direction to the left based on current direction
        switch (direction) {
            case UP -> direction = Direction.LEFT;
            case LEFT -> direction = Direction.DOWN;
            case DOWN -> direction = Direction.RIGHT;
            case RIGHT -> direction = Direction.UP;
        }
    }

    /**
     * Changes the car's direction to the right based on what direction it's going in
     */
    @Override
    public void turnRight() {
        //Changes direction to the right based on current direction
        switch (direction) {
            case UP -> direction = Direction.RIGHT;
            case LEFT -> direction = Direction.UP;
            case DOWN -> direction = Direction.LEFT;
            case RIGHT -> direction = Direction.DOWN;
        }
    }

    /**
     * Moves the car in the direction it has
     */
    @Override
    public void move() {
        //Moves the car based on current direction
        startEngine();
        switch (direction) {
            case UP -> position.y += currentSpeed;
            case DOWN -> position.y -= currentSpeed;
            case LEFT -> position.x -= currentSpeed;
            case RIGHT -> position.x += currentSpeed;
        }
    }
}


