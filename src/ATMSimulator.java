import java.util.Scanner;
/*
1. Assignment 1: User input, Java data types, operators and control structures
• ATM Machine Simulator: The program should allow a customer to perform simple banking operations like
check balance, deposit, withdraw and transfer funds on the available balance depending on the type of
customer. Allow or deny user operations depending on user type and operation using bitwise operators
E.g. Check balance has value 1, transfer funds has value 8 etc.. User of type "Premium" has value 15 and
he will be able to perform all operations.
• Use: User input, data types, bitwise operations, assignment operations, control structures like if, switch,
while etc.
• Input: Balance, user type, operation, repeat? etc.
 */
public class ATMSimulator {
    // standard, premium
    // standard - deposit + withdraw + check balance
    // premium - deposit + withdraw + check balance + transfer funds
    static final int CHECK_BALANCE = 1;
    static final int DEPOSIT = 2;
    static final int WITHDRAW = 4;
    static final int TRANSFER_FUNDS = 8;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 0;
        int userType;
        int operation;
        boolean flag;
        userType = typesOfUser(sc);
        while (userType != 7 && userType != 15){
            System.out.println("Invalid user type! Choose correct one.");
            userType = typesOfUser(sc);
        }

        do {
            operation = typesOfOperation(sc);
            switch (operation){
                case CHECK_BALANCE:
                    if((userType & CHECK_BALANCE) == CHECK_BALANCE){
                        System.out.println("Your account balance is: "+ balance);
                        break;
                    }
                    else{
                        System.out.println("Sorry! You are not eligible to check your balance.");
                        break;
                    }
                case DEPOSIT:
                    if((userType & DEPOSIT) == DEPOSIT){
                        double money;
                        System.out.print("Enter amount of money you want to deposit: ");
                        money = sc.nextDouble();
                        if(money <= 0){
                            System.out.println("Invalid input! pls try again");
                            break;
                        }
                        balance += money;
                        System.out.println(money + " Rs. Deposited in your account");
                        System.out.println("Your account balance is now: "+ balance);
                        break;
                    }
                    else{
                        System.out.println("Sorry! You are not eligible to deposit money in your account.");
                        break;
                    }
                case WITHDRAW:
                    if((userType & WITHDRAW) == WITHDRAW){
                        double money;
                        System.out.print("Enter amount of money you want to withdraw: ");
                        money = sc.nextDouble();
                        if(money <= 0){
                            System.out.println("Invalid input! pls try again");
                            break;
                        }
                        else if(money > balance){
                            System.out.println("Your current balance is: "+ balance+" Rs. you cannot withdraw money greater than that.");
                        }
                        else{
                            balance -= money;
                            System.out.println(money + " Rs. Withdrawn from your account");
                            System.out.println("Your account balance is now: "+ balance);
                        }
                        break;
                    }
                    else{
                        System.out.println("Sorry! You are not eligible to withdraw money from your account.");
                        break;
                    }
                case TRANSFER_FUNDS:
                    if((userType & TRANSFER_FUNDS) == TRANSFER_FUNDS){
                        System.out.print("Enter amount you want to transfer: ");
                        double money;
                        money = sc.nextDouble();
                        if(money <= 0){
                            System.out.println("Invalid input! pls try again");
                            break;
                        }
                        else if(money > balance){
                            System.out.println("Your current balance is: "+ balance+" Rs. you cannot withdraw money greater than that.");
                        }
                        else{
                            balance -= money;
                            System.out.println(money + " Rs. Transferred from your account");
                            System.out.println("Your account balance is now: "+ balance);
                        }
                        break;
                    }
                    else{
                        System.out.println("Sorry! You are not eligible to transfer funds from your account.");
                        break;
                    }
                default:
                    System.out.println("Invalid operation! Choose correct operation");
                    break;
            }
            System.out.println("\nDo you want to continue operations ? (yes or no)");
            String query = sc.next();
            if(query.toLowerCase().equals("yes")) flag = true;
            else {
                flag = false;
                System.out.println("Program exited successfully.");
                sc.close();
                return;
            }
        }
        while(flag);
    }
    public static int typesOfUser(Scanner sc){
        System.out.println("\nSelect user type (7/15): ");
        System.out.println("7. Standard user - features: deposit, withdraw, check balance" + "\n"
                        + "15. Premium user - features: deposit, withdraw, check balance & transfer funds");
        return sc.nextInt();
    }
    public static int typesOfOperation(Scanner sc){
        System.out.println("Select operation type (1/2/4/8): ");
        System.out.println("1. Check balance\n2. Deposit money\n4. Withdraw money\n8. Transfer funds\n");
        return sc.nextInt();
    }
}

