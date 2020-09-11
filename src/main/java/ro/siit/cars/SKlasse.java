package ro.siit.cars;
/**
 * The class SKlasse inherits Mercedes.
 * Constructs the car by hardcoded parameters.
 * Throwing IllegalArgumentException if input parameters are not correct
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-09-11
 */
public class SKlasse extends Mercedes {

    SKlasse(Double availableFuel, String chassisNumber) {
        super(90, Fuel.DISEL, 6, 10.0, availableFuel, 19, chassisNumber,8);
        if (availableFuel <= 0.0 || availableFuel >90) {
            throw new IllegalArgumentException("Available fuel level is not valid! Input lower than 90L.");
        }
        if (chassisNumber.length() < 17) {
            throw new IllegalArgumentException("Chassis number is not valid! Input is "+chassisNumber.length()+" characters long. Input min. 17 characters.");
        }
    }
}
