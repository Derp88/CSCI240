#include "horse.h"

Horse::Horse(){
    Horse::position = 0; //Set inital horse position to 0
} //end constructor
void Horse::advance(int distance){
    position = position + distance;
} //end advance
int Horse::getPosition(){
    return position;
} //end getPosition
