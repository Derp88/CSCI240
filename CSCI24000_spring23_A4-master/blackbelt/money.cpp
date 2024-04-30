#include "money.h"

//Default Constructor
Money::Money(){
    Money::dollars = 100;
    Money::betHorse = 0;
    Money::betAmount = 0;
} 
//Constructor with money value input
Money::Money(int dollarAmount){
    Money::dollars = dollarAmount;
    Money::betHorse = 0;
    Money::betAmount = 0;
}
void Money::changeDollars(int dollarAmount){
    dollars = dollars + dollarAmount;
}
int Money::getDollars(){
    return dollars;
}
void Money::setBetHorse(int horseNum){
    betHorse = horseNum;
}
int Money::getBetHorse(){
    return betHorse;
}
void Money::setBetAmount(int bet){
    betAmount = bet;
}
void Money::betWon(){
    dollars = dollars + betAmount;
}
void Money::betLost(){
    dollars = dollars - betAmount;
}
