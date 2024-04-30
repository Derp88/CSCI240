import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args){
        ATM ATMInteract = new ATM();
        ATMInteract.mainMenu();
    }

    public void mainMenu(){
        Admin AdminAccount;
        if (loadAdmin() != null){
            AdminAccount = loadAdmin();
        }else{
            System.out.println("Data not found");
            AdminAccount = new Admin();
        }

        Scanner input = new Scanner(System.in);
        int accountNu= loginMenu(input);
        if (accountNu == -1){ //Bad input catcher
            System.out.println("Bad Input. Try Again");
            mainMenu();
        }
        if (accountNu == 00000){ //Is admin
            if (pinInput(input) == 12345){
                adminMenu(input, AdminAccount);
            }
            else{
                System.out.println("Invalid password!");
                exit(AdminAccount);
            }
        }
        if (AdminAccount.findMatchingUser(accountNu) != -1 && accountNu != 00000){
            int activeUser = AdminAccount.findMatchingUser(accountNu);
            if (AdminAccount.userList.get(activeUser).checkPIN(pinInput(input))){
                System.out.println("Welcome User!");
                userMenu(input, AdminAccount, activeUser);
            }else{
                System.out.println("Invalid password!");
            }
            
        }
    }

    public void saveAdmin(Admin adminAccount){
        try {
            FileOutputStream fileOut = new FileOutputStream("Data.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(adminAccount);
            objectOut.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Admin loadAdmin(){
        try {
            FileInputStream fileIn = new FileInputStream("Data.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            //objectIn.close();
            return (Admin)objectIn.readObject();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public int loginMenu(Scanner input){
        try {
            System.out.println("Please enter your account number");
            int accountNum = input.nextInt();
            return accountNum;
        } catch (Exception e){
            System.out.println("Input Error");
            System.out.println(e.getMessage());
            return -1; 
        }
    }
    public int pinInput(Scanner input){
        try {
            System.out.println("Please enter your account PIN");
            int pin = input.nextInt();
            return pin;
        } catch (Exception e){
            System.out.println("Input Error");
            System.out.println(e.getMessage());
            return -1; 
        }
    }
    
    public void adminMenu(Scanner input, Admin admAccount){
        boolean keepGoing = true;
        while(keepGoing){
            input.nextLine();
            System.out.println("Please select what to do: ");
            System.out.println("1) Add User");
            System.out.println("2) Delete User");
            System.out.println("3) List Users");
            System.out.println("4) Apply Interest");
            System.out.println("5) Exit");
            try {
                int choice = input.nextInt();
                if (choice == 1){
                    System.out.println("Please enter the user account number: ");
                    int accountNum = input.nextInt();
                    System.out.println("Please enter the user PIN:");
                    int pin = input.nextInt();
                    admAccount.addUser(accountNum, pin, 0, 0);
                }
                if (choice == 2){
                    System.out.println("Please enter the user account number: ");
                    int accountNum = input.nextInt();
                    if (admAccount.findMatchingUser(accountNum) != -1){
                        admAccount.deleteUser(accountNum);
                    }else{
                        System.out.println("Sorry, I couldn't find that user!");
                    }
                }
                if (choice == 3){
                    admAccount.listUsers();
                }
                if (choice == 4){
                    System.out.println("Please enter the interest rate");
                    double intRate = input.nextDouble();
                    System.out.println("Please enter the period: ");
                    double time = input.nextDouble();
                    admAccount.applyInterst(intRate, time);
                }
                if (choice == 5){
                    keepGoing = false;
                    exit(admAccount);
                }
            } catch (Exception e){
                System.out.println("Input Error");
                System.out.println(e.getMessage());
            }
        }
    }
    public void userMenu(Scanner input, Admin admAccount, int user){
        boolean keepGoing = true;
        while(keepGoing){
            input.nextLine();
            System.out.println();
            System.out.println("Please select what to do: ");
            System.out.println("1) Checking Balance");
            System.out.println("2) Checking Deposit");
            System.out.println("3) Checking Withdraw");
            System.out.println("4) Savings Balance");
            System.out.println("5) Savings Deposit");
            System.out.println("6) Savings Withdraw");
            System.out.println("7) Exit");
            try {
                int choice = input.nextInt();
                if (choice == 1){
                    System.out.println("Checking Balance: " + admAccount.userList.get(user).getChecking().getBalance());
                }
                if (choice == 2){
                    System.out.println("Please enter the amount you wish to deposit: ");
                    int deposit = input.nextInt();
                    admAccount.userList.get(user).getChecking().deposit(deposit);
                }
                if (choice == 3){
                    System.out.println("Please enter the amount you wish to withdraw: ");
                    int withdraw = input.nextInt();
                    admAccount.userList.get(user).getChecking().withdraw(withdraw);
                }
                if (choice == 4){
                    System.out.println("Savings Balance: " + admAccount.userList.get(user).getSavings().getBalance());
                }
                if (choice == 5){
                    System.out.println("Please enter the amount you wish to deposit: ");
                    int deposit = input.nextInt();
                    admAccount.userList.get(user).getSavings().deposit(deposit);
                }
                if (choice == 6){
                    System.out.println("Please enter the amount you wish to withdraw: ");
                    int withdraw = input.nextInt();
                    admAccount.userList.get(user).getSavings().withdraw(withdraw);
                }
                if (choice == 7){
                    keepGoing = false;
                    exit(admAccount);
                }
            } catch (Exception e){
                System.out.println("Input Error");
                System.out.println(e.getMessage());
            }
        }
    }
    public void exit(Admin admAccount){
        saveAdmin(admAccount);
        System.out.println("Thanks for using this ATM. Data saved");
    }
}
