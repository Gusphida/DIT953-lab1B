import java.awt.*;

/**
 * The Scania class introduces a truck with specific values
 */

public class Scania extends ACar {
    public double platformAngle;

    /**
     * Default values for the Scania
     */
    public Scania() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Scania";
        platformAngle = 0;
        transportable = false;
        stopEngine();
    }

    /**
     * Gives the angle of the platform
     * @return the value of platformAngle
     */
    public double getPlatformAngle() {
        return platformAngle;
    }

    /**
     * Increases the platformAngle by a set amount
     */
    public void raiseAngle(double increase){
        if (currentSpeed == 0 && platformAngle <= (70 - increase) && increase > 0) {
            platformAngle += increase;
        }
    }

    /**
     * Decreases the platformAngle by a set amount
     */
    public void lowerAngle(double decrease){
        if (currentSpeed == 0 && platformAngle >= decrease && decrease > 0) {
            platformAngle -= decrease;
        }
    }

    /**
     * Sets the currentSpeed to 0.1 if platformAngle is 0
     */
    @Override
    public void startEngine() {
        if (platformAngle == 0) {
            super.startEngine();
        }
    }

    /**
     * Increases the cars current speed based on an interval of 0 to 1 if the angle is 0
     */
    @Override
    public void gas(double amount){
        //Calls on incrementSpeed within an interval of 0 to 1
        if (platformAngle == 0) {
            super.gas(amount);
        }
    }
}

