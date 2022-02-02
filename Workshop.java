import java.util.ArrayList;

/**
 * The Workshop class introduces a workshop for cars.
 */

public class Workshop<T extends ACar> {
    private int maxCars;
    private ArrayList<T> cars = new ArrayList<>();

    /**
     * Default values for a workshop
     */
    public Workshop(){
        maxCars = 10;
    }

    /**
     * Adds a car if theres room in the workshop
     */
    public void loadCar(T car){
        if (maxCars >= cars.size()) {
            cars.add(car);
        }
    }

    /**
     * Removes a car from the workshop and returns the model
     * @return the name of the cars model
     */
    public T unloadCar(int index){
        if (cars.size() == 0 && cars.size() > index){
            return null;
        }
        T car = cars.remove(index);
        return car;
    }
}
