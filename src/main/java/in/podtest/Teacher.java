package in.podtest;

public class Teacher {

    String name;
    String subject;

    Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    /**
     * Prints the teacher's name and subject.
     */
    public void getTeacherInfo() {
        System.out.println("Teacher Name is: " + name + " and Subject is: " + subject);
    }
}