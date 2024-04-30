#include <iostream>
#include <cstdlib>

void moveHorses(int, int[]);
void printRace(int[]);
void checkWinner(int[]);

int const numberOfHorses = 5;
int const trackLength = 14;

bool keepGoing = true;

int main(){
	//Seed setup
	int seed;
	std::cout << "Please enter a random seed: ";
	std::cin >> seed; //Gets user input
	std::srand(seed); //Initializes random

	int horsePositions[numberOfHorses] = {0,0,0,0,0};
	
	//Move horses, print race, and check for a winner.
	while(keepGoing){
		moveHorses(seed, horsePositions);
		printRace(horsePositions);
		checkWinner(horsePositions);
	}//end while
	return 0;
}//end main

void moveHorses(int seed, int horsePositions[5]){
	//Update currents positions by adding a 50% chance to move forward 1
	horsePositions[0] = horsePositions[0] + rand() % 2;
	horsePositions[1] = horsePositions[1] + rand() % 2;
	horsePositions[2] = horsePositions[2] + rand() % 2;
	horsePositions[3] = horsePositions[3] + rand() % 2;
	horsePositions[4] = horsePositions[4] + rand() % 2;
}//end function

void printRace(int horsePositions[5]){
	for (int horseNum = 0; horseNum < numberOfHorses; horseNum++){
		std::cout << std::string(horsePositions[horseNum], '.'); //Prints the dots before the horse
		//Only run this part if the horse has not won yet!
		if (trackLength - horsePositions[horseNum]  > -1){
			std::cout << horseNum; //Prints the horse
			std::cout << std::string(trackLength - horsePositions[horseNum], '.'); //Prints the dots after the horses
		}//end if
		std::cout << std::endl;
	}//end for
	std::cout << std::endl;	
}//end function
void checkWinner(int horsePositions[5]){
	for (int horseNum = 0; horseNum < numberOfHorses; horseNum++){
		if (horsePositions[horseNum] > trackLength){
			keepGoing = false;
			std::cout << "Horse " << horseNum << " wins!" << std::endl;
		}//end if
	}//end for
}//end function

