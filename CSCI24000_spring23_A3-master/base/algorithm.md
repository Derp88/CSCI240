Goals: Simulate a horse race with 5 horses on a track.  
Input: A seed  
Output: A horse race with the numbers moving across the screen.  
Steps:    
	main:  
		- Get a random seed value input  
		- Have an array with the values representing the position of the horse. The index will represent the horse's number.  
		- Run a function that updates the horses position. moveHorses()  
		- Run a function that prints the current race with the horses positions. printRace()  
		- Check if the race has been won. If so stop main loop. checkWinner() 

	
moveHorses()  
Goals: Do a 50% chance of moving a horse forward based off a seed.  
Input: The array of horses and a random seed.  
Output: Array with horses moved.  
Steps:  
	- For every horse:  
		- Get a random number based off the seed  
		- If the number that is generated is even, move the horse forward. If not, do nothing  

printRace()  
Goals: Print the race using dots and numbers to represent the track and horses.  
Input: The array of horses with their positions.  
Output: The race with the horses and dots.  
Steps:   
	- For every horse in the array.  
		- Print a number of dots corresponding to the horses position. So if the horse is in position 0, print 0 dots, since we are at the start.  
		- Print the horses index number. So horse 0,1, or 2 etc...  
		- Print the remaining dots. Print the amount that is (15 - horse current position) - 1. So if the horse is at the start (0), we should print 14 dots.  

checkWinnder()  
Goals: Check if a horse has won the race, so we can stop the program.  
Input: Horse posisionts  
Output: Change keepGoing to false and print the winning horse.  
Steps:  
	- For every horse:  
		- If the horses position is greater than the track length:  
			- End the race  
			- Print the winner  
