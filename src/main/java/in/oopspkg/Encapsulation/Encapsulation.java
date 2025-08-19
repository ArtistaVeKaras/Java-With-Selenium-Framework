package in.oopspkg.Encapsulation;

public class Encapsulation {

    public static void main(String[] args) {

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Adam");
        System.out.println(employee.getId() + " " + employee.getName());
    }
}