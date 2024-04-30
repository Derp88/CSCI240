#ifndef ADDRESS_H_EXISTS
#define ADDRESS_H_EXISTS
#include <string>

class Address{
    private:
        std::string line1;
        std::string line2;
        std::string city;
        std::string state;
        int zip;
    public:
        Address();
        Address(std::string line1, std::string line2, std::string city, std::string state, int zip);

        void setLine1(std::string line1);
        void setLine2(std::string line2);
        void setCity(std::string city);
        void setState(std::string state);
        void setZip(int zip);

        std::string getLine1();
        std::string getLine2();
        std::string getCity();
        std::string getState();
        int getZip();
};

#endif