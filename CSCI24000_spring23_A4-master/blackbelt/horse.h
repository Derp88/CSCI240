#ifndef HORSE_H_EXISTS
#define HORSE_H_EXISTS

class Horse{
    private: 
        int position;
    public:
        Horse();
        void advance(int distance);
        int getPosition();
        void resetHorse();
}; //end class def
#endif