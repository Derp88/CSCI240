public class Savings extends Account implements java.io.Serializable{
    public void updateInterest(double interestRate, double time){
        setBalance(getBalance()*(1+(interestRate*time)));
    }
}
