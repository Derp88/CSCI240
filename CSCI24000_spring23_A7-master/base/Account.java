public abstract class Account implements java.io.Serializable{
    private double balance; 
    public Account(){
        balance = 0;
    }
    public Account(double startBalance){
        balance = startBalance;
    }
    public void deposit(double amount){
        balance = balance + Math.abs(amount);
    }
    public boolean withdraw(double amount){
        if (amount < balance){
            balance = balance - amount;
            return true;
        }else{
            System.out.println("Invalid Amount");
            return false;
        }
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double amount){
        balance = amount;
    }
}