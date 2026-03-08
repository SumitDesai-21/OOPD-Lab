package Vehicles;

public class Main {
    public static void main(String[] args) {

        // Parent reference & child object
        Vehicle[] vehicles = new Vehicle[4];
        vehicles[0] = new Bike("Yamaha", "Petrol", 120, 40);
        vehicles[1] = new Car("Mercedes Benz", "Diesel", 200, 15);
        vehicles[2] = new Bike("Honda", "Petrol", 100, 50);
        vehicles[3] = new Car("Toyota", "Petrol", 180, 18);

        // Demonstrating same method call but different behavior
        System.out.println("All vehicles\n");
        for (Vehicle v : vehicles) {
            v.displayInfo(); 
            v.start();
            v.stop();
            System.out.println();
        }

        // Demonstrating specific methods using downcasting
        for (Vehicle v : vehicles) {
            if (v instanceof Bike) {
                Bike bike = (Bike) v;  // Downcasting
                bike.ride();
            } else if (v instanceof Car) {
                Car car = (Car) v;  // Downcasting
                car.honk();
            }
        }
    }
}
