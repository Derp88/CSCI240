#include "student.h"

//Constructor
Student::Student(){
    Student::firstName = "";
    Student::lastName = "";
    Student::Home = new Address();
    Student::BirthDate = new Date();
    Student::CompletionDate = new Date();
    Student::gpa = 0;
    Student::creditHours = 0;
}
Student::~Student(){
    delete Student::Home;
    delete Student::BirthDate;
    delete Student::CompletionDate;
}
std::string Student::generateReport(){
    //I'm sorry for this line.
    return "First: " + firstName + " Last: " + lastName
    + " Line 1: " + getStudentAddress()->getLine1() + " Line 2: " + getStudentAddress()->getLine2()
    + " City: " + getStudentAddress()->getCity() + " State: " + getStudentAddress()->getState()+ " ZIP: " + std::to_string(getStudentAddress()->getZip()) 
    + " Birth Month: " + std::to_string(getBirthDate()->getMonth()) + " Birth Day: " + std::to_string(getBirthDate()->getDay())+ " Birth Year: " + std::to_string(getBirthDate()->getYear())
    + " Done Month: " + std::to_string(getCompletionDate()->getMonth()) + " Done Day: " +std::to_string(getCompletionDate()->getDay()) + " Done Year: " + std::to_string(getCompletionDate()->getYear())
    + " GPA: " + std::to_string(getGpa()) + " Credit Hours: " + std::to_string(getCreditHours());
}
std::string Student::generateFullName(){
    return firstName + " " + lastName;
}
//Set
void Student::setFirstName(std::string firstName){
    Student::firstName = firstName;
}
void Student::setLastName(std::string lastName){
    Student::lastName = lastName;
}
void Student::setStudentAddress(Address* Home){
    Student::Home = Home;
}
void Student::setBirthDate(Date* BirthDate){
    Student::BirthDate = BirthDate;
}
void Student::setCompletionDate(Date* CompletionDate){
    Student::CompletionDate = CompletionDate;
}
void Student::setGpa(float gpa){
    Student::gpa = gpa;
}
void Student::setCreditHours(int creditHours){
    Student::creditHours = creditHours;
}

//Get
std::string Student::getFirstName(){
    return Student::firstName;
}
std::string Student::getLastName(){
    return Student::lastName;
}
Address* Student::getStudentAddress(){
    return Student::Home;
}
Date* Student::getBirthDate(){
    return Student::BirthDate;
}
Date* Student::getCompletionDate(){
    return Student::CompletionDate;
}
float Student::getGpa(){
    return Student::gpa;
}
int Student::getCreditHours(){
    return Student::creditHours;
}