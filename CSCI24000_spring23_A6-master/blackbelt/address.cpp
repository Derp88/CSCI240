#include "address.h"

//Constructors
Address::Address(){
    Address::line1 = "";
    Address::line2 = "";
    Address::city = "";
    Address::state = "";
    Address::zip = 0;
}
Address::Address(std::string line1, std::string line2, std::string city, std::string state, int zip){
    Address::line1 = line1;
    Address::line2 = line2;
    Address::city = city;
    Address::state = state;
    Address::zip = zip;
}
//Set
void Address::setLine1(std::string line1){
    Address::line1 = line1;
}
void Address::setLine2(std::string line2){
    Address::line2 = line2;
}
void Address::setCity(std::string city){
    Address::city = city;
}
void Address::setState(std::string state){
    Address::state = state;
}
void Address::setZip(int zip){
    Address::zip = zip;
}
//Get
std::string Address::getLine1(){
    return Address::line1;
}
std::string Address::getLine2(){
    return Address::line2;
}
std::string Address::getCity(){
    return Address::city;
}
std::string Address::getState(){
    return Address::state;
}
int Address::getZip(){
    return Address::zip;
}