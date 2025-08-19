package in.oopspkg.Inheritance;

public class MarutiCar extends Car{

    String dashBoard;
    String steeringWheel;
    String engine;
    String fuelTank;
    String brand;

    public void carInfo(String dashBoard, String steeringWheel, String engine, String fuelTank, String brand) {
        this.dashBoard = dashBoard;
        this.steeringWheel = steeringWheel;
        this.engine = engine;
        this.fuelTank = fuelTank;
        this.brand = brand;
        System.out.println("Car Information: " + dashBoard + " " + steeringWheel + " " + engine + " " + fuelTank + " " + brand);
    }

    public void playVideoMusic() {
        System.out.println("Playing Video Music");
    }

    public void drive() {
        super.drive();
    }
}