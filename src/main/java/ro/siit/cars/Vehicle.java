package ro.siit.cars;
/**
 * The interface Vehicle : All Vehicles (e.g car, bike, horse, boat, plane) have the following behavior:
 *they can be started, stopped and driven for a number of kms.
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-09-11
 */
public interface Vehicle {
    void start();
    void stop();
    void drive(Double km);
}
