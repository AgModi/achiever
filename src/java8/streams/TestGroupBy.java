package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

class Employee {
    int number;
    String name;
    int marks;

    Employee (int number, String name, int marks) {
        this.number = number;
        this.name = name;
        this.marks = marks;
    }

    Employee() {}

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}


public class TestGroupBy {
    public static void main(String[] args) {
        groupBy();
    }

    private static void groupBy(){
        List<Employee>  empList = Arrays.asList(
                new Employee(1, "Sat", 10),
                new Employee(2, "Sun", 20),
                new Employee(3, "Mon", 30),
                new Employee(4, "Mon", 40),
                new Employee(5, "Tue", 50),
                new Employee(6, "Wed", 60),
                new Employee(7, "Thu", 70),
                new Employee(8, "Fri", 80),
                new Employee(9, "Thu", 90)
        );

        Map<String, List<Employee>> map = empList.stream().collect(Collectors.groupingBy(emp -> emp.getName()));
        System.out.println(map);

        Map<String, List<Integer>> mapNew = empList.stream().collect(Collectors.groupingBy(emp -> emp.getName(), Collectors.mapping(emp1 -> emp1.getNumber(), Collectors.toList())));
        System.out.println(mapNew);
    }
}
