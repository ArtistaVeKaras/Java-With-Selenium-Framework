package in.oopspkg.Inheritance;

public class InheritanceDemoClass {

    public static void main(String[] args) {
        MarutiCar m1 = new MarutiCar();
        m1.drive();
        m1.playVideoMusic();
        m1.carInfo("Maruti Car", "Spring", "Petrol", "1.5L", "Ford");


        Suzuki s1 = new Suzuki();
        s1.drive();
        s1.playVideoMusic();
        s1.carInfo("Suzuki Car", "Spring", "Diesel", "5L", "Chevrolet");
    }
}