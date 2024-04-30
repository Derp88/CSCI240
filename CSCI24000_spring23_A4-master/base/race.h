#ifndef RACE_H_EXISTS
#define RACE_H_EXISTS

#include "horse.h"

class Race{
    private:
        int seed;
        int length;
        int numberHorses;
        bool keepGoing;
        Horse horseArray[5];
    public:
        Race();
        Race(int length);
        void printLane(int horseNum);
        void checkWinner();
        void start();
        
}; //end class def

#endif