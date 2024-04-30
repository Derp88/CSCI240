#include <fstream>
#include <iostream>
#include <string>
#include <sstream>
#include <cctype>


int main(){
    //Output File
    std::ofstream outputFile;
    outputFile.open("output.txt");
    //Input File
    std::ifstream inputFile;
    inputFile.open("input.txt");

    std::string entry;
    std::string splitEntry;
    std::stringstream stringConvert;
    std::stringstream stringToInt;
    int intValue;
    int lineTotal;
    int lineNum;
    lineNum = 0;

    //This gets every line
    while (std::getline(inputFile, entry)){
        //Clears the converter
        stringConvert.clear();
        stringConvert.str(entry);

        //This splits the line up
        if (lineNum % 2 == 0){ //Runs only if the line has ints
            while (std::getline(stringConvert, splitEntry, ',')){
                //Conver the string to an int
                stringToInt.clear();
                stringToInt.str(splitEntry);
                stringToInt >> intValue;
                //Create a total of all the ints
                lineTotal = lineTotal + intValue;
            }
        }
        else{ //Runs for the line that doesn't have int
            for(int outputCounter = 0; outputCounter < lineTotal-1; outputCounter++){
                //Prints out the string based on the total (But not the last one)
                outputFile << entry << ",";
            }
            outputFile << entry; //Prints the last one without a comma
            outputFile << std::endl;
            lineTotal = 0;  //Reset the total back to 0, so we can count the next line
        }
        lineNum++;
    }

    
    inputFile.close();
    outputFile.close();

    return 0;
}