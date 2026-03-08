package Employees;

public class Employee {
    int id;
    String name;
    double baseSalary;
    double salary;
    double bonus;
    int rating;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.baseSalary = 10000.00;
        this.bonus = 0.0;
        this.rating = 1;
        this.salary = baseSalary + (bonus * rating);
    }

    Employee(int id, String name, double baseSalary, double bonus, int rating) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.rating = rating;
        this.salary = baseSalary + (bonus * rating);
    }

    void update(double bonus) {
        this.bonus = bonus;
        this.salary = baseSalary + (this.bonus * this.rating);
    }

    void update(int rating) {
        this.rating = rating;
        this.salary = baseSalary + (this.bonus * this.rating);
    }

    void update(double bonus, int rating) {
        this.bonus = bonus;
        this.rating = rating;
        this.salary = baseSalary + (this.bonus * this.rating);
    }
}
