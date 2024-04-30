#include <cstdlib>
#include <iostream>
#include "race.h"

//Default Constructor
Race::Race(){ 
    Race::seed = 0;
    Race::length = 14;
    Race::numberHorses = 5;
    Race::keepGoing = true;
    Race::horseArray[numberHorses];

    std::cout << "Please enter a random seed: ";
	std::cin >> seed; //Gets user input
	std::srand(seed); //Initializes random
}//end default constructor

//Construct with length
Race::Race(int length){
    Race::seed = 0;
    Race::length = length;
    Race::numberHorses = 5;
    Race::keepGoing = true;
    Race::horseArray[numberHorses];

    std::cout << "Please enter a random seed: ";
	std::cin >> seed; //Gets user input
	std::srand(seed); //Initializes random
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
        }//end if
    }//end for
}//end checkWinner

void Race::start(){
    while(keepGoing){
        //For every horse, run a chance to advance and then print the lane
        for (int horseNum = 0; horseNum < numberHorses; horseNum ++){
            horseArray[horseNum].advance(rand() % 2);
            printLane(horseNum);
        }//end for
        checkWinner();
        std::cout << std::endl;
    }//end while
}//end start
