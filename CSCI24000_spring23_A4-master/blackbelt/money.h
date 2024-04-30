#ifndef MONEY_H_EXISTS
#define MONEY_H_EXISTS

class Money{
    private:
        int dollars;
        int betHorse;
        int betAmount;
    public:
        Money();
        Money(int dollarAmount);
        void changeDollars(int dollarAmount);
        int getDollars();
        void setBetHorse(int horseNum);
        int getBetHorse();
        void setBetAmount(int bet);
        void betWon();
        void betLost();
        
}; //end class def

#endif