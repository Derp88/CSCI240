public class User implements java.io.Serializable{
    private Checking checkingAccount = new Checking();;
    private Savings savingsAccount = new Savings();;
    protected int accountNumber;
    private int PIN;

    public User(){
        accountNumber = 0;
        PIN = 0;
    }
    public User(int accountNum, int pin, double savingsBalance, double checkingBalance){
        this.accountNumber = accountNum;
        this.PIN = pin;
        savingsAccount.setBalance(savingsBalance);
        checkingAccount.setBalance(checkingBalance);
    }
    public void setChecking(Checking checkingAcc){
        this.checkingAccount = checkingAcc;
    }
    public Checking getChecking(){
        return checkingAccount;
    }
    public void setSavings(Savings savingsAcc){
        this.savingsAccount = savingsAcc;
    }
    public Savings getSavings(){
        return savingsAccount;
    }
    public boolean checkAccountNumber(int accountNum){
        return (accountNumber == accountNum);
    }
    public boolean checkPIN(int pin){
        return (this.PIN == pin);
    }
    public void setPIN(int pin){
        this.PIN = pin;
    }
    public void setAccountNumber(int accountNum){
        this.accountNumber = accountNum;
    }
}
