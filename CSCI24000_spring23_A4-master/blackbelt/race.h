#ifndef RACE_H_EXISTS
#define RACE_H_EXISTS

#include "horse.h"
#include "money.h"

class Race{
    private:
        //int seed;
        int length;
        int numberHorses;
        bool keepGoing;
        Horse horseArray[5];
        Money moneySystem;
    public:
        Race();
        Race(int length);
        void printLane(int horseNum);
        void checkWinner();
        void start();
        
}; //end class def

#endif