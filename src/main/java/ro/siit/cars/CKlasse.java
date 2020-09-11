package ro.siit.cars;
/**
 * The class CKlasse inherits Mercedes.
 * Constructs the car by hardcoded parameters.
 * Throwing IllegalArgumentException if input parameters are not correct
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-09-11
 */
public class CKlasse extends Mercedes {

    CKlasse(Double availableFuel, String chassisNumber) {
        super(60, Fuel.PETROL, 6, 15.0, availableFuel, 18, chassisNumber,12);
        if (availableFuel <= 0.0 || availableFuel >60) {
            throw new IllegalArgumentException("Available fuel level is not valid! Input lower than 60L.");
        }
        if (chassisNumber.length() < 17) {
            throw new IllegalArgumentException("Chassis number is not valid! Input is "+chassisNumber.length()+" characters long. Input min. 17 characters.");
        }
    }
}
