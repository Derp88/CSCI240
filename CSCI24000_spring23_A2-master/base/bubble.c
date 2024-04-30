//bubble.c
//famous bubble sort
//implement the swap algorithm with pointers

#include <stdio.h>
#define MAX 9

//function prototypes
void printValues();
void sort();
void swap(int*, int*);

int values[] = {7, 3, 9, 4, 6, 1, 2, 8, 5};

int main(){
  printf("Before: \n");
  printValues();
  sort();
  printf("After: \n");
  printValues();

  return(0);
} // end main

void printValues(){
	for (int value = 0; value < MAX; value++){
		printf("%d ", values[value]);
	}//end for loop
	printf("\n"); //Addes newline after values are printed out
}//end printValues

void sort(){
	for (int outValue = 0; outValue < MAX-1; outValue++){
		for (int inValue = 0; inValue < MAX-1; inValue++){
			if (values[inValue] > values[inValue + 1]){
				swap(&values[inValue] , &values[inValue + 1]);
			}//enc if
		}//end inner for
	}//end outter for
}//end sort

void swap(int *firstNum, int *secNum){
	int originalFirstNum = *firstNum;
	int originalSecNum = *secNum;
	*firstNum = originalSecNum; //We have these here because the orginal values would get overriden.
	*secNum = originalFirstNum;
	printValues();	
	
}//end swap

