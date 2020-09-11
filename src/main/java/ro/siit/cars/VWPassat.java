package ro.siit.cars;
/**
 * The class VWPassat inherits Volkswagen.
 * Constructs the car by hardcoded parameters.
 * Throwing IllegalArgumentException if input parameters are not correct
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-09-11
 */
public class VWPassat extends Volkswagen {

    VWPassat(Double availableFuel, String chassisNumber) {
        super(65, Fuel.DISEL, 6, 5.5, availableFuel, 17, chassisNumber,5);
        if (availableFuel <= 0.0 || availableFuel >65) {
            throw new IllegalArgumentException("Available fuel level is not valid! Input lower than 65L.");
        }
        if (chassisNumber.length() < 17) {
            throw new IllegalArgumentException("Chassis number is not valid! Input is "+chassisNumber.length()+" characters long. Input min. 17 characters.");
        }
    }
}
