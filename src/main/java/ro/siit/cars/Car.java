package ro.siit.cars;
/**
 * The class Car is the base abstract class of the Car hierarchy
 * Car is a type of vehicle:
 * properties of a car model which can not change: fuelTankSize, fuelType (PETROL, DIESEL, etc), gears (max 6), consumptionPer100Km (i.e 4.7)
 * properties that are configurable: availableFuel, tireSize(15, 17, etc)
 * properties that are instance specific: chassisNumber
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-09-11
 */
public abstract class Car implements Vehicle {
    private final Integer fuelTankSize;
    public enum Fuel {PETROL, DISEL}
    private final Fuel fuelType;
    private final Integer gears;
    private final Double consumptionPer100Km; //is the consumption of the car in cruising mode (last gear)
    public Double availableFuel;
    public Integer tireSize;
    public final String chassisNumber;

    private Integer gearFuelFactor;
    private Double contorKm;
    private Double contorFuel;
    private Integer actualGear;
    private Double actualConsumptionPer100Km;
    private Double avergaFuelConsumptionPer100Km;

    Car(Integer fuelTankSize, Fuel fuelType, Integer gears, Double consumptionPer100Km, Double availableFuel, Integer tireSize, String chassisNumber, Integer gearFuelFactor) {
        this.fuelTankSize = fuelTankSize;
        this.fuelType = fuelType;
        this.gears = gears;
        this.consumptionPer100Km = consumptionPer100Km;
        this.availableFuel = availableFuel;
        this.tireSize = tireSize;
        this.chassisNumber = chassisNumber;
        this.gearFuelFactor = gearFuelFactor;
    }
    /**
     * After car start fields are reset: Kilometers, Fuel, average consumption
     *
     */
    @Override
    public void start() {
        // reset kilometers
        contorKm = 0.0;
        //reset fuel consumed
        contorFuel = 0.0;
        //reset fuel consumption
        avergaFuelConsumptionPer100Km = 0.0;
    }
    /**
     * After car stop average consumption is calculated
     *
     */
    @Override
    public void stop() {
        //calculate avarage fuel consumption at the end of trip
        avergaFuelConsumptionPer100Km = (100 * contorFuel) / contorKm;
    }
    /**
     * Method for car drive behaviour.
     * Kilometers, fuels and available fuel are updated after each drive.
     *
     * @param km - number of kilometers to be driven
     */
    @Override
    public void drive(Double km) {
        //put in 1st gear if not selected so we can drive the car without invokung method car.shiftGear();
        if (actualGear == null) {
            actualConsumptionPer100Km = calculateConsumption(this.consumptionPer100Km, 1, this.gearFuelFactor, this.tireSize);
        }
        //check if we have enough fuel to make the trip and give warnning
        if ( (availableFuel - ((km * actualConsumptionPer100Km) / 100))< 0) {
            System.out.println("Not enough fuel to make the trip!");
        }
        else {
            //add kilometers to contor
            contorKm = contorKm + km;
            //add fuel consumed
            contorFuel = contorFuel + ((km * actualConsumptionPer100Km) / 100);
            //substract from tank
            availableFuel = availableFuel - ((km * actualConsumptionPer100Km) / 100);
        }
    }
    /**
     * Method for car switching gear. Actual consumption is updated.
     *
     * @param gear - the gear in which the car is driven
     */
    public void shiftGear(Integer gear) {
        //set the current gear
        actualGear = gear;
        //set actual consuption
        actualConsumptionPer100Km = calculateConsumption(this.consumptionPer100Km, this.actualGear, this.gearFuelFactor, this.tireSize);
    }
    /**
     * Method for returning available fuel
     *
     * @return availableFuel
     */
    public Double getAvailableFuel() {
        return availableFuel;
    }
    /**
     * Method for returning average fuel consumption after a drive sequence.
     *
     * @return avergaFuelConsumptionPer100Km
     */
    public Double getAverageFuelConsumption() {
        return avergaFuelConsumptionPer100Km;
    }
    /**
     * Method for calculating consumption considering based on formula.
     *
     */
    private static Double calculateConsumption(Double consumptionPer100Km, Integer actualGear, Integer gearFuelFactor, Integer tireSize) {
        return consumptionPer100Km *
                (1.0 + (((7.0 - actualGear) * gearFuelFactor) / 100.0)) *
                (1.0 + ((tireSize-13.0) / 100.0));
    }

}
