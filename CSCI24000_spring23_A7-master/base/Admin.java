import java.util.ArrayList;

public class Admin implements java.io.Serializable{
    ArrayList<User> userList = new ArrayList<User>();

    public void addUser(int accountNum, int pin, double savingsBalance, double checkingBalance){
        User newUser = new User(accountNum, pin, savingsBalance, checkingBalance);
        userList.add(newUser);
    }
    public void deleteUser(int accountNum){
        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).accountNumber == accountNum){ //Search for an account with a matching number
                if (userList.get(i).getChecking().getBalance() == 0){ //Check to see if the checking account is empty
                    if(userList.get(i).getSavings().getBalance() == 0){ //Check to see if the savings account is empty
                        userList.remove(i);
                        System.out.println("Removed user");
                    }else{
                        System.out.println("This account can not be deleted! There is " + userList.get(i).getSavings().getBalance() + " left in the savings account.");
                    }
                }else{
                    System.out.println("This account can not be deleted! There is " + userList.get(i).getChecking().getBalance() + " left in the checking account.");
                }
            }
        }
    }
    public void applyInterst(double rate, double time){
        for (int i = 0; i < userList.size(); i++){
            userList.get(i).getSavings().updateInterest(rate, time);
        }
    }
    public void listUsers(){
        for (int i = 0; i < userList.size(); i++){
            System.out.println("ACCOUNT NUM: " + userList.get(i).accountNumber + " CHECK BAL: " + userList.get(i).getChecking().getBalance() + " SAVINGS BAL: "+ userList.get(i).getSavings().getBalance());
        }
    }
    public int findMatchingUser(double accountNum){
        int account = -1;
        for (int i = 0; i < userList.size(); i++){
            if (userList.get(i).accountNumber == accountNum){
                account = i;
            }
        }
        return account;
    }
}
