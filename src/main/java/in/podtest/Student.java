package in.podtest;

public class Student {

    String name;

    int rollNo;

    int[] marks;

    Teacher classTeacher;
    Campus classCampus;

    Student(String name, int rollNo, int[] marks, Teacher classTeacher, Campus classCampus) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
        this.classTeacher = classTeacher;
        this.classCampus = classCampus;
    }

    /**
     * Print the student's name.
     */
    public void getStudentInfo() {
        System.out.println("Student Name is: " + name + " and Roll No is: " + rollNo);
        System.out.println("Total Marks is: " + getTotalMarks() + " and the Class teacher name is " + classTeacher.name);
        System.out.println("Campus name is: " + classCampus.name + " and location is " + classCampus.location);
    }

    /**
     * Prints the marks of the student.
     */
    public int getTotalMarks() {
        int totalMarks = 0;

        for (int i: marks) {
            totalMarks = totalMarks +i;
        }

        return totalMarks;
    }
}