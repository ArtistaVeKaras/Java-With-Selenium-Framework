package in.oopspkg.Polymorthism;

public class OverLoadingDemo {

    public void walking() {
        System.out.println("Walking");
    }

    public void walking(int x) {
        System.out.println("Variable name is " + x);
    }

    public void walking(String name) {
        System.out.println("Name is " + name);
    }
}