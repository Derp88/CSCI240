Main.class: Main.java Cat.class Lizard.class Dog.class Pet.class Hunger.class Strength.class Thirst.class Attribute.class
	javac -g Main.java
Cat.class: Cat.java Pet.class Hunger.class Strength.class Thirst.class Attribute.class
	javac -g Cat.java
Lizard.class: Lizard.java Pet.class Hunger.class Strength.class Thirst.class Attribute.class
	javac -g Lizard.java
Dog.class: Dog.java Pet.class Hunger.class Strength.class Thirst.class Attribute.class
	javac -g Dog.java
Pet.class: Pet.java Hunger.class Strength.class Thirst.class Attribute.class
	javac -g Pet.java
Hunger.class: Hunger.java Attribute.class
	javac -g Hunger.java
Strength.class: Strength.java Attribute.class
	javac -g Strength.java
Thirst.class: Thirst.java Attribute.class
	javac -g Thirst.java
Attribute.class: Attribute.java
	javac -g Attribute.java

run: Main.class
	java Main

clean:
	rm *.class
	rm Pet.dat

debug: Main.class
	jdb Main

jar: Main.java Cat.class Lizard.class Dog.class Pet.class Hunger.class Strength.class Thirst.class Attribute.class
	jar cvfm PetSim.jar manifest.txt *.*

