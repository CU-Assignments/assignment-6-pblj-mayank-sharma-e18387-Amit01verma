import java.util.*;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', marks=" + marks + "}";
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 80),
                new Student("Bob", 70),
                new Student("Charlie", 90),
                new Student("David", 60),
                new Student("Emma", 85)
        );

        // Filter students scoring above 75%, sort by marks (descending), and collect names
        List<String> topStudents = students.stream()
                .filter(s -> s.getMarks() > 75)           // Filter students
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed()) // Sort by marks
                .map(Student::getName)                   // Extract names
                .collect(Collectors.toList());

        // Display the sorted student names
        System.out.println("Students scoring above 75% (sorted by marks):");
        topStudents.forEach(System.out::println);
    }
}
