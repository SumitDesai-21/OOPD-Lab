package Employees;

import java.util.Scanner;

// Main file to manage employees
public class Main {
    
    // Create record of 10 employees in an array.
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

    public static void main(String[] args) {
        Main manager = new Main(); // manager can update employee data
        manager.initialize();

        Scanner sc = new Scanner(System.in);
        int opr;

        
        boolean repeat = true;
        do {
            opr = menu(sc);
            switch (opr) {
            case 1:
                // as employees is non-static we can refer to it with manager using . operator
                System.out.println("Emp.Id.\t|Name\t\t|Salary\t\t|Bonus\t|Rating\t");
                System.out.println("--------------------------------------------------------");
                for(Employee e: manager.employees){
                    System.out.println(e.id+"\t|"+ e.name+ "\t|"+ e.salary+"\t|"+ e.bonus+"\t|"+ e.rating);
                }
                break;
        
            case 2:
                System.out.print("Enter employee id & bonus amount to be updated respectively. ");
                int id = sc.nextInt();
                int bonus_amt = sc.nextInt();
                boolean found = false;
                for(Employee e: manager.employees){
                    if(e.id == id){
                        found = true;
                        double prev_salary = e.salary;
                        e.salary -= e.bonus;
                        e.bonus = bonus_amt * e.rating;
                        e.salary += e.bonus;
                        
                        System.out.println("Previous salary: "+ prev_salary+", Updated salary: "+ e.salary);
                    }
                }
                if(!found){
                    System.out.println("No employee with id: "+ id);
                }
                break;

            case 3:
                System.out.print("Enter employee id & rating to be updated respectively. ");
                id = sc.nextInt();
                int rating = sc.nextInt();
                found = false;
                for(Employee e: manager.employees){
                    if(e.id == id){
                        found = true;
                        double prev_salary = e.salary;
                        e.salary -= e.bonus;
                        if(e.rating != 0){
                            e.bonus /= e.rating;
                        }
                        e.rating = rating;
                        e.bonus *= rating;
                        e.salary += e.bonus;
                        
                        System.out.println("Previous salary: "+ prev_salary+", Updated salary: "+ e.salary);
                    }
                }
                if(!found){
                    System.out.println("No employee with id: "+ id);
                }
                break;

            case 4:
                System.out.print("Enter employee id, bonus amount & rating to be updated respectively. ");
                id = sc.nextInt();
                bonus_amt = sc.nextInt();
                rating = sc.nextInt();
                found = false;
                for(Employee e: manager.employees){
                    if(e.id == id){
                        found = true;
                        double prev_salary = e.salary;
                        e.salary -= e.bonus;
                        e.rating = rating;
                        e.bonus = bonus_amt * rating;
                        e.salary += e.bonus;
                        
                        System.out.println("Previous salary: "+ prev_salary+", Updated salary: "+ e.salary);
                    }
                }
                if(!found){
                    System.out.println("No employee with id: "+ id);
                }
                break;
            default:
                System.out.println("Invalid operation! pls try again");
                break;
            }
            System.out.println("Do you want to continue? (yes or no)");
            if(sc.next().toLowerCase().equals("no")){
                break;
            }
        } while (repeat);
        System.out.println("Program exited successfully.");
    }
    public static int menu(Scanner sc){
        System.out.println("Enter operation to be performed");
        System.out.println("1. Check employee list\n2. Update bonus of an employee\n3. Update rating of an employee"+
        "\n4. Update bonus & rating both of an employee.");
        return sc.nextInt();
    }
    
}
