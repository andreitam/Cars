package ro.siit.cars;
/**
 * The class VWGolf inherits Volkswagen.
 * Constructs the car by hardcoded parameters.
 * Throwing IllegalArgumentException if input parameters are not correct
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-09-11
 */
public class VWGolf extends Volkswagen {

    VWGolf(Double availableFuel, String chassisNumber) {
        super(50, Fuel.PETROL, 5, 7.0, availableFuel, 15, chassisNumber,10);
        if (availableFuel <= 0.0 || availableFuel >50) {
            throw new IllegalArgumentException("Available fuel level is not valid! Input lower than 50L.");
        }
        if (chassisNumber.length() < 17) {
            throw new IllegalArgumentException("Chassis number is not valid! Input is "+chassisNumber.length()+" characters long. Input min. 17 characters.");
        }
    }
}
