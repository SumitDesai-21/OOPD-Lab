package Vehicles;

public class Main {
    public static void main(String[] args) {
        
        Vehicle v1 = new Bike("Yamaha", "Petrol", 120, 40);
        Vehicle v2 = new Car("Mercedes Benz", "Diesel", 200, 100);

        v1.displayInfo();
        v2.displayInfo();
    }
}
