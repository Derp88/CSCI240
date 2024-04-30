#ifndef DATE_H_EXISTS
#define DATE_H_EXISTS

class Date{
    private:
        int month;
        int day;
        int year;
    public:
        Date();
        Date(int month, int day, int year);
        void setMonth(int month);
        void setDay(int day);
        void setYear(int year);
        int getMonth();
        int getDay();
        int getYear();
};

#endif