package in.podtest;

public class School {

    public static void main(String[] args) {

        Teacher teacher1 = new Teacher("Akim", "Maths");
        Teacher teacher2 = new Teacher("Adam", "Science");
        Campus campus1 = new Campus("Oxford", "London");
        Campus campus2 = new Campus("India", "Mumbai");
        Student student1 = new Student("Akira", 1, new int[] {90, 80, 70}, teacher1, campus1);
        Student student2 = new Student("Kojima", 2, new int[] {85, 75, 65}, teacher2, campus2);

        student1.getStudentInfo();
        student2.getStudentInfo();
    }
}