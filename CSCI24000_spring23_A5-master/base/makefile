main: main.o
	g++ -g main.o -o main

main.o: main.cpp
	g++ -c -g main.cpp

clean: 
	rm *.o
	rm main

run: main
	./main

debug: main
	gdb main
