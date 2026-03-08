package Employees;

import java.util.Scanner;

public class Main {

    private static final int EMPLOYEE_COUNT = 10;
    Employee[] employees = new Employee[EMPLOYEE_COUNT];

    private void initialize() {
        employees[0] = new Employee(1, "Aarav Sharma", 12000.00, 500, 2);
        employees[1] = new Employee(2, "Diya Verma", 15000.00, 700, 3);
        employees[2] = new Employee(3, "Kabir Singh");
        employees[3] = new Employee(4, "Anaya Gupta");
        employees[4] = new Employee(5, "Ishaan Mehta");
        employees[5] = new Employee(6, "Saanvi Roy", 16000.00, 750, 3);
        employees[6] = new Employee(7, "Vivaan Iyer");
        employees[7] = new Employee(8, "Myra Kapoor", 17000.00, 900, 2);
        employees[8] = new Employee(9, "Arjun Nair");
        employees[9] = new Employee(10, "Aditi Jain");
    }

    private void printAllEmployees() {
        System.out.println("Emp.Id.\t|Name\t\t|Salary\t\t|Bonus\t|Rating\t");
        System.out.println("--------------------------------------------------------");
        for (Employee e : employees) {
            System.out.println(e.id + "\t|" + e.name + "\t|" + e.salary + "\t|" + e.bonus + "\t|" + e.rating);
        }
    }

    private Employee findById(int id) {
        for (Employee e : employees) {
            if (e.id == id)
                return e;
        }
        return null;
    }

    private void menu() {
        System.out.println("Select an operation:");
        System.out.println("1. View all employees");
        System.out.println("2. Update bonus");
        System.out.println("3. Update rating");
        System.out.println("4. Update bonus and rating");
        System.out.print("Choice: ");
    }

    public static void main(String[] args) {
        Main manager = new Main();
        manager.initialize();
        Scanner sc = new Scanner(System.in);

        while (true) {
            manager.menu();
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    manager.printAllEmployees();
                    break;

                case 2: {
                    System.out.println("\nBefore Update: ");
                    manager.printAllEmployees();

                    System.out.print("Enter employee ID: ");
                    int id = sc.nextInt();
                    Employee e = manager.findById(id);

                    if (e == null) {
                        System.out.println("Employee not found.");
                        break;
                    }

                    System.out.print("Enter new bonus amount: ");
                    double bonus = sc.nextDouble();
                    e.update(bonus);

                    System.out.println("\nAfter Update: ");
                    manager.printAllEmployees();
                    break;
                }

                case 3: {
                    System.out.println("\nBefore Update: ");
                    manager.printAllEmployees();

                    System.out.print("Enter employee ID: ");
                    int id = sc.nextInt();
                    Employee e = manager.findById(id);

                    if (e == null) {
                        System.out.println("Employee not found.");
                        break;
                    }

                    System.out.print("Enter new rating: ");
                    int rating = sc.nextInt();
                    e.update(rating);

                    System.out.println("\nAfter Update: ");
                    manager.printAllEmployees();
                    break;
                }

                case 4: {
                    System.out.println("\nBefore Update: ");
                    manager.printAllEmployees();

                    System.out.print("Enter employee ID: ");
                    int id = sc.nextInt();
                    Employee e = manager.findById(id);

                    if (e == null) {
                        System.out.println("Employee not found.");
                        break;
                    }

                    System.out.print("Enter new bonus amount: ");
                    double bonus = sc.nextDouble();
                    System.out.print("Enter new rating: ");
                    int rating = sc.nextInt();
                    e.update(bonus, rating);

                    System.out.println("\nAfter Update: ");
                    manager.printAllEmployees();
                    break;
                }

                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.print("Continue? (yes or no): ");
            if (sc.next().toLowerCase().equals("no"))
                break;
        }

        sc.close();
        System.out.println("Program exited.");
    }
}
