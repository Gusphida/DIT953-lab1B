import java.awt.*;
/**
 * The Saab95 class introduces a car with specific values
 **/

public class Saab95 extends ACar {
    private boolean turboOn;

    /**
     * Default values for a Saab95 car
     */
    public Saab95() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        transportable = true;
        stopEngine();
    }

    /**
     * Sets the turbo on
     */
    public void setTurboOn() {
        //Sets turboOn to true
        turboOn = true;
    }

    /**
     * Turns the turbo off
     */
    public void setTurboOff() {
        //Sets turboOn to false
        turboOn = false;
    }

    /**
     * Calculates the cars speed factor
     * @return the cars speed factor
     */
    public double speedFactor() {
        //Calculates the speedFactor
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}
