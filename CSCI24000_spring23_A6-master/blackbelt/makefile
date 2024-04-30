studentHeap: main.o student.o address.o date.o
	g++ main.o student.o address.o date.o -g -o studentHeap
main.o: main.cpp student.h address.h date.h
	g++ -g -c main.cpp
student.o: student.cpp student.h address.h date.h
	g++ -g -c student.cpp
address.o: address.cpp address.h 
	g++ -g -c address.cpp
date.o: date.cpp date.h
	g++ -g -c date.cpp




clean:
	rm studentHeap
	rm *.o
	rm fullReport.txt
	rm shortReport.txt

run: studentHeap
	./studentHeap

debug: studentHeap
	gdb studentHeap

valgrind: studentHeap
	valgrind --leak-check=full ./studentHeap