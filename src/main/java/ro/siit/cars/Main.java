package ro.siit.cars;

public class Main
{
    public static void main( String[] args )
    {
        //1st instance
        Car car = new SKlasse(40.0, "WVWZZZ3CZFE052230");
        car.start();
        car.shiftGear(1);
        car.drive(0.01);// drives 0.01 KMs
        car.shiftGear(2);
        car.drive(0.02);
        car.shiftGear(3);
        car.drive(0.5);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(5);
        car.drive(100.0);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(6);
        car.drive(100.0);
        car.stop();
        Double availableFuel = car.getAvailableFuel();
        Double fuleConsumedPer100Km = car.getAverageFuelConsumption();
        System.out.println(availableFuel);
        System.out.println(fuleConsumedPer100Km);
        //2nd instance
        Vehicle vehicle = new VWGolf(30.0, "1987ddkshik2898jh"); //available fuel and chassis number
        vehicle.start();
        vehicle.drive(10.0);
        vehicle.stop();
        Car car2 = (Car) vehicle;
        double availableFuel2 = car2.getAvailableFuel();
        double fuleConsumedPer100Km2 = car2.getAverageFuelConsumption();
        System.out.println("");
        System.out.println(availableFuel2);
        System.out.println(fuleConsumedPer100Km2);

    }
}
