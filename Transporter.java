import java.awt.*;
import java.util.ArrayList;

/**
 * The Transporter class introduces a Transporter car with default values
 */

public class Transporter extends ACar implements ITransporter{
    enum Direction {
        UP, DOWN
    }
    public Direction rampMode;
    public ArrayList<ACar> cars = new ArrayList<>();
    private final int maxCars;

    /**
     * Default values for the transporter car
     */
    public Transporter() {
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        modelName = "Transporter";
        rampMode = Direction.UP;
        maxCars = 6;
        stopEngine();
    }

    /**
     * Toggles the ramp between up and down if the car is standing still
     */
    public void toggleRamp(){
        if (rampMode == Direction.UP && currentSpeed == 0){
            rampMode = Direction.DOWN;
        } else {
            rampMode = Direction.UP;
        }
    }

    /**
     * Puts a car in the list of cars loaded on the transporter
     */
    public void loadCar(ACar car){ //TODO add size restriction
        if (rampMode == Direction.DOWN && (car.position.x-position.x) <= 10 && (car.position.y-position.y) <= 10) {
            if (!(car instanceof ITransporter) && cars.size() < maxCars ) {
                cars.add(car);
            }
        }
    }

    /**
     * Take the last car out of the transporter
     */
    public void unloadCar(){
        if (rampMode == Direction.DOWN && cars.size() > 0) {
            ACar car = cars.remove(cars.size()-1);
            car.position.x = position.x;
            car.position.y = position.y - 5;
        }
    }

    /**
     * Moves the transporter and cars in the direction it has
     */
    @Override
    public void move() {
        //Moves the car based on current direction
        if (rampMode == Direction.UP) {
            startEngine();
            switch (direction) {
                case UP -> position.y += currentSpeed;
                case DOWN -> position.y -= currentSpeed;
                case LEFT -> position.x -= currentSpeed;
                case RIGHT -> position.x += currentSpeed;
            }
            updateCarPositions();
        }
    }

    /**
     * updates all the positions of the cars on the transporter
     */
    public void updateCarPositions(){
        for (int i = 0; i < cars.size(); i++){
            cars.get(i).position = position;
        }
    }
}
