package Vehicles;

class Vehicle {
    String brand;
    String fuelType;
    int maxSpeed;
    int wheels;

    void displayInfo(){
        System.out.println("Vehicle information: ");
        System.out.println("Brand: "+ brand+"\nFuelType: "+ fuelType+"\nMaximum Speed: "+maxSpeed+"\nWheels: "+ wheels  );
    }
    void start(){
        System.out.println("Vehicle started.");
    }
    void stop(){
        System.out.println("Vehicle stopped.");
    }
}
class ManualVehicle extends Vehicle {
    ManualVehicle(String brand, int maxSpeed, int wheels) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
        this.wheels = wheels;
        this.fuelType = "None";
    }
}
class AutoVehicle extends Vehicle {
    int mileage;

    AutoVehicle(String brand, String fuelType, int maxSpeed, int wheels, int mileage) {
        this.brand = brand;
        this.fuelType = fuelType;
        this.maxSpeed = maxSpeed;
        this.wheels = wheels;
        this.mileage = mileage;
    }
}
class Bike extends AutoVehicle {
    Bike(String brand, String fuelType, int maxSpeed, int mileage){
        super(brand, fuelType, maxSpeed, 2, mileage);
    }

    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Mileage: "+ mileage);
        System.out.println("Type: Bike\n");
    }

    void ride(){
        System.out.println("Bike is riding...");
    }
}   
class Car extends AutoVehicle{
    Car(String brand, String fuelType, int maxSpeed, int mileage){
        super(brand, fuelType, maxSpeed, 4, mileage);
    }

    @Override
    void displayInfo(){
        super.displayInfo();
        System.out.println("Mileage: "+ mileage);
        System.out.println("Type: Car\n");
    }

    void honk(){
        System.out.println("Car is honking...");
    }
}
