package Employees;
public class Employee {
    int id;
    String name;
    double salary;
    int bonus;
    int rating;
    
    // every employee must have an id & name
    public Employee(int id, String name){
        this.id = id;
        this.name = name;
        this.bonus = 0;
        this.salary = 10000.00;
        this.rating = 1;
    }
    public Employee(int id, String name, double salary, int bonus_amount, int rating){
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.bonus = bonus_amount * rating;
        this.salary = salary + this.bonus;
    }
}
