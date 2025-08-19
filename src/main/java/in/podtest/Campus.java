package in.podtest;

public class Campus {

    String name;
    String location;

    Campus(String name, String location) {
        this.name = name;
        this.location = location;
    }

    /**
     * Prints the campus name and location of the Campus.
     */
    public void getCampusInfo() {
        System.out.println("Campus Name is: " + name + " and Location is: " + location);
    }
}