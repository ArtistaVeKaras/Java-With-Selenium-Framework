package in.oopspkg.Encapsulation;

/*Explain the concepts of Encapsulation
 *
 */
public class Employee {

    String name;
    private int id;
    private double salary;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}