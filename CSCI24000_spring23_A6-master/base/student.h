#ifndef STUDENT_H_EXISTS
#define STUDENT_H_EXISTS
#include <string>
#include "address.h"
#include "date.h"

class Student{
    private:
        std::string firstName;
        std::string lastName;
        Address* Home;
        Date* BirthDate;
        Date* CompletionDate;
        float gpa;
        int creditHours;
    public:
        Student();
        ~Student(); //Destructor
        std::string generateReport();
        std::string generateFullName();
        //Set
        void setFirstName(std::string firstName);
        void setLastName(std::string lastName);
        void setStudentAddress(Address* Home);
        void setBirthDate(Date* BirthDate);
        void setCompletionDate(Date* CompletionDate);
        void setGpa(float gpa);
        void setCreditHours(int creditHours);
        //Get
        std::string getFirstName();
        std::string getLastName();
        Address* getStudentAddress();
        Date* getBirthDate();
        Date* getCompletionDate();
        float getGpa();
        int getCreditHours();

};

#endif

//get the home address object, the use the set