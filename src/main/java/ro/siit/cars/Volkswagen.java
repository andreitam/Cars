package ro.siit.cars;
/**
 * The class Volkswagen is abstract class and inherits Car.
 * Only used to pass arguments to super class.
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-09-11
 */
abstract class Volkswagen extends Car {

    Volkswagen(Integer fuelTankSize, Fuel fuelType, Integer gears, Double consumptionPer100Km, Double availableFuel, Integer tireSize, String chassisNumber, Integer gearFuelFactor) {
        super(fuelTankSize, fuelType, gears, consumptionPer100Km, availableFuel, tireSize, chassisNumber, gearFuelFactor);
    }

}
