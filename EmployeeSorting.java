import java.util.*;

class Employee {
    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class EmployeeSorting {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 60000));
        employees.add(new Employee("Bob", 25, 50000));
        employees.add(new Employee("Charlie", 35, 70000));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sort by: 1) Name 2) Age 3) Salary");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                employees.sort(Comparator.comparing(Employee::getName));
                break;
            case 2:
                employees.sort(Comparator.comparingInt(Employee::getAge));
                break;
            case 3:
                employees.sort(Comparator.comparingDouble(Employee::getSalary));
                break;
            default:
                System.out.println("Invalid choice! Sorting by name by default.");
                employees.sort(Comparator.comparing(Employee::getName));
        }

        System.out.println("\nSorted Employees:");
        employees.forEach(System.out::println);
        scanner.close();
    }
}
