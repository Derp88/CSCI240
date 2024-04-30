#include "date.h"

//Constructors
Date::Date(){
    Date::month = 0;
    Date::day = 0;
    Date::year = 0;
}
Date::Date(int month, int day, int year){
    Date::month = month;
    Date::day = day;
    Date::year = year;
}

//Set
void Date::setMonth(int month){
    Date::month = month;
}
void Date::setDay(int day){
    Date::day = day;
}
void Date::setYear(int year){
    Date::year = year;
}

//Get
int Date::getMonth(){
    return Date::month;
}
int Date::getDay(){
    return Date::day;
}
int Date::getYear(){
    return Date::year;
}