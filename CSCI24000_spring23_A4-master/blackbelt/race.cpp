#include <cstdlib>
#include <iostream>
#include "race.h"
#include "time.h"

//Default Constructor
Race::Race(){ 
    //Race::seed = 0;
    Race::length = 14;
    Race::numberHorses = 5;
    Race::keepGoing = true;
    Race::horseArray[numberHorses];
    Race::moneySystem = Money();

    //std::cout << "Please enter a random seed: ";
	//std::cin >> seed; //Gets user input
	std::srand(time(NULL)); //Initializes random
}//end default constructor

//Construct with length
Race::Race(int length){
    //Race::seed = 0;
    Race::length = length;
    Race::numberHorses = 5;
    Race::keepGoing = true;
    Race::horseArray[numberHorses];
    Race::moneySystem = Money();

    //std::cout << "Please enter a random seed: ";
	//std::cin >> seed; //Gets user input
	std::srand(time(NULL)); //Initializes random
}//end constructor with length parameter

void Race::printLane(int horseNum){
    std::cout << std::string(horseArray[horseNum].getPosition(), '.'); //Prints the dots before the horse
    //Only run this part if the horse has not won yet!
	if (length - horseArray[horseNum].getPosition()  > -1){
		std::cout << horseNum; //Prints the horse
		std::cout << std::string(length - horseArray[horseNum].getPosition(), '.'); //Prints the dots after the horses
	}//end if
	std::cout << std::endl;
}//end printLane

void Race::checkWinner(){
    for (int horseNum = 0; horseNum < numberHorses; horseNum ++){ //for every horse
        if (horseArray[horseNum].getPosition() > length){ //if the horse has gone more than the track length (it has won!)
            keepGoing = false;
            std::cout << std::endl;
            std::cout << "Horse " << horseNum << " wins!" << std::endl;
            //Check the bet
            if (horseNum == moneySystem.getBetHorse()){
                moneySystem.betWon();
                std::cout << "You won your bet!" << std::endl;;
            }
            else{
                moneySystem.betLost();
                std::cout << "You lost your bet" << std::endl;;
            }
        }//end if
    }//end for
}//end checkWinner

void Race::start(){
    //Bet amount
    std::cout << "You have " << moneySystem.getDollars() << " dollars, how much would you like to bet?" << std::endl;
    int betAmount;
    std::cin >>betAmount;
    moneySystem.setBetAmount(betAmount);
    //Bet Horse
    std::cout << "Which horse number would you like to bet on?" << std::endl;
    int betHorse;
    std::cin >> betHorse;
    moneySystem.setBetHorse(betHorse);

    //Reset horses to 0 position
    for (int horseNum = 0; horseNum < numberHorses; horseNum ++){
            horseArray[horseNum].resetHorse();
    }//end for

    while(keepGoing){
        //For every horse, run a chance to advance and then print the lane
        for (int horseNum = 0; horseNum < numberHorses; horseNum ++){
            horseArray[horseNum].advance(rand() % 2);
            printLane(horseNum);
        }//end for
        checkWinner();
        std::cout << std::endl;
    }//end while
    
    //Keep looping the game while we still have money.
    if(moneySystem.getDollars() > 0){
        keepGoing = true;
        std::srand(time(NULL));
        start();
    }

}//end start
