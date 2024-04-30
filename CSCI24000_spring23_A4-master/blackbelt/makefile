horseRace: race.o horse.o money.o main.o
	g++ -g race.o horse.o money.o main.o -o horseRace

main.o: race.h main.cpp 
	g++ -c -g main.cpp

race.o: race.h race.cpp horse.h money.h
	g++ -c -g race.cpp

horse.o: horse.h horse.cpp
	g++ -c -g horse.cpp

money.o: money.h money.cpp
	g++ -c -g money.cpp

clean: 
	rm *.o
	rm horseRace

run: horseRace
	./horseRace

debug: horseRace
	gdb horseRace