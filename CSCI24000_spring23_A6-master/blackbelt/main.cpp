#include <iostream>
#include <fstream>
#include <sstream>
#include "student.h"
#include <algorithm>

int stringToInt(std::string input);
float stringToFloat(std::string input);
bool sortName(Student& a, Student& b);
void outputList(Student* s);

int main(){
    std::string entry;
    std::string indivEntry;
    std::string splitDate;
    std::stringstream stringSplitter;
    std::stringstream dateSplitter;
    int lineNumber;
    int indivEntryNumber;
    lineNumber = 0;
    indivEntryNumber = 0;
    std::string* dataToStore = new std::string[15];
    Student* studentList = new Student[50];

    //Input File
    std::ifstream inputFile;
    inputFile.open("students.dat");

    //Output Files
    std::ofstream fullOutputFile;
    fullOutputFile.open("fullReport.txt");
    

    //Gets every line
    while (std::getline(inputFile, entry)){
        indivEntryNumber = 0;
        stringSplitter.clear();
        stringSplitter.str(entry);

        //Splits the line up based on commas
        while (std::getline(stringSplitter, indivEntry, ',')){
            dateSplitter.clear();
            dateSplitter.str(indivEntry);

            //Checks for dates
            if (indivEntryNumber == 7 || indivEntryNumber == 10){
                while (std::getline(dateSplitter, splitDate, '/')){
                    dataToStore[indivEntryNumber] = splitDate;
                    indivEntryNumber++;
                }
            }else{
                dataToStore[indivEntryNumber] = indivEntry;
                indivEntryNumber++;
            }
        }

        studentList[lineNumber].setLastName(dataToStore[0]);
        studentList[lineNumber].setFirstName(dataToStore[1]);
        studentList[lineNumber].getStudentAddress()->setLine1(dataToStore[2]);
        studentList[lineNumber].getStudentAddress()->setLine2(dataToStore[3]);
        studentList[lineNumber].getStudentAddress()->setCity(dataToStore[4]);
        studentList[lineNumber].getStudentAddress()->setState(dataToStore[5]);
        studentList[lineNumber].getStudentAddress()->setZip(stringToInt(dataToStore[6]));
        studentList[lineNumber].getBirthDate()->setMonth(stringToInt(dataToStore[7]));
        studentList[lineNumber].getBirthDate()->setDay(stringToInt(dataToStore[8]));
        studentList[lineNumber].getBirthDate()->setYear(stringToInt(dataToStore[9]));
        studentList[lineNumber].getCompletionDate()->setMonth(stringToInt(dataToStore[10]));
        studentList[lineNumber].getCompletionDate()->setDay(stringToInt(dataToStore[11]));
        studentList[lineNumber].getCompletionDate()->setYear(stringToInt(dataToStore[12]));
        studentList[lineNumber].setGpa(stringToFloat(dataToStore[13]));
        studentList[lineNumber].setCreditHours(stringToInt(dataToStore[14]));

        fullOutputFile << studentList[lineNumber].generateReport() << std::endl;
        //shortOutputFile << studentList[lineNumber].generateFullName() << std::endl;
        lineNumber++;
    }
    std::sort(studentList, studentList + 50, sortName);
    outputList(studentList);
    
    
    delete [] dataToStore;
    delete [] studentList;
    inputFile.close();
    fullOutputFile.close();
    
    return 0;
}//end main

int stringToInt(std::string input){
    std::stringstream converter;
    int intValue;

    converter.clear();
    converter.str(input);
    converter >> intValue;
    return intValue;
}
float stringToFloat(std::string input){
    std::stringstream converter;
    float floatValue;
    converter.clear();
    converter.str(input);
    converter >> floatValue;
    return floatValue;
}
bool sortName(Student& a, Student& b){
    return(a.getFirstName() < b.getFirstName());
}
void outputList(Student* s){
    std::ofstream shortOutputFile;
    shortOutputFile.open("shortReport.txt");
    for (int i = 0; i < 50; i++){
        shortOutputFile << s[i].generateFullName() << std::endl;
    }
    shortOutputFile.close();
}