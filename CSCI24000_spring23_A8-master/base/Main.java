import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
    private boolean keepGoing = true;
    private int choice0 = 0;
    private int choice = 0;
    private String name;
    Object currentPet = null;
    public static void main(String[] args){
        Main petProgram = new Main();
        petProgram.mainMenu();
    }
    public void mainMenu(){
        Scanner input = new Scanner(System.in);
        while(keepGoing){
            System.out.println("");
            System.out.println("What would you like to do?");
            System.out.println("1) Create a pet");
            System.out.println("2) Interact with a pet");
            System.out.println("3) Load Pet");
            System.out.println("4) Save Pet");
            System.out.println("5) Quit");
            try {
                choice0 = input.nextInt();
            } catch (Exception e){
                System.out.println("Bad Input!");
                //System.out.println(e.getMessage());
            }
            if (choice0 == 1){
                createPet(input);
            }
            if (choice0 == 2){
                interactPet(input);
            }
            if (choice0 == 3){
                System.out.println("Attempting to load pet");
                loadPet();
            }
            if (choice0 == 4){
                System.out.println("Attempting to save pet");
                savePet();
            }
            if (choice0 == 5){
                keepGoing = false;
                System.out.println("Goodbye have a good day");
            }
        }
    }

    public void createPet(Scanner input){
        System.out.println("What pet would you like to make");
        System.out.println("1) Dog");
        System.out.println("2) Cat");
        System.out.println("3) Lizard");
        System.out.println("4) Exit");
        try {
            choice = input.nextInt();
            if (choice == 1 || choice == 2 || choice == 3){ //Only run this if a valid animal is selected
                System.out.println("What name do you want to give it?");
                name = input.next();
            }
        } catch (Exception e){
            System.out.println("Bad Input!");
            //System.out.println(e.getMessage());
        }
        if (choice == 1){
            currentPet = new Dog();
            ((Dog) currentPet).assignName(name);
        }
        if (choice == 2){
            currentPet = new Cat();
            ((Cat) currentPet).assignName(name);
        }
        if (choice == 3){
            currentPet = new Lizard();
            ((Lizard) currentPet).assignName(name);
        }
    }
    public void interactPet(Scanner input){
        if (currentPet != null){
            //These are options for all pets
            System.out.println("What would you like to do with: " + ((Pet) currentPet).getName());
            System.out.println("1) Sleep");
            System.out.println("2) Rename");
            System.out.println("3) Give Water");
            System.out.println("4) Give Food");
            System.out.println("5) Play");
            System.out.println("6) Make sound");
            System.out.println("7) Get Status");

            //Extra options for dog and lizard
            if (currentPet instanceof Dog){
                System.out.println("8) Give Bath");
            }
            if (currentPet instanceof Lizard){
                System.out.println("8) Shed Skin");
            }

            //Input
            try {
                choice = input.nextInt();
            } catch (Exception e){
                System.out.println("Bad Input!");
                //System.out.println(e.getMessage());
            }
            if (choice == 1){ //Sleep
                System.out.println( (((Pet) currentPet).getName()) + " gets some sleep");
                ((Pet) currentPet).petSleep();
            }
            if (choice == 2){ //Rename
                System.out.println("What name do you want to give it?");
                try {
                    name = input.next();
                    ((Pet) currentPet).assignName(name);
                } 
                catch (Exception e){
                    System.out.println("Bad Input!");
                }
            }
            if (choice == 3){ //Water
                System.out.println("You gave " + (((Pet) currentPet).getName()) + "some water");
                ((Pet) currentPet).giveWater();
            }
            if (choice == 4){ //Food
                if (currentPet instanceof Dog){
                    ((Dog) currentPet).feedPet();
                }
                if (currentPet instanceof Cat){
                    ((Cat) currentPet).feedPet();
                }
                if (currentPet instanceof Lizard){
                    ((Lizard) currentPet).feedPet();
                }
            }
            if (choice == 5){ //Play
                if (currentPet instanceof Dog){
                    ((Dog) currentPet).playPet();
                }
                if (currentPet instanceof Cat){
                    ((Cat) currentPet).playPet();
                }
                if (currentPet instanceof Lizard){
                    ((Lizard) currentPet).playPet();
                }
            }
            if (choice == 6){ //Sound
                if (currentPet instanceof Dog){
                    ((Dog) currentPet).makeSound();
                }
                if (currentPet instanceof Cat){
                    ((Cat) currentPet).makeSound();
                }
                if (currentPet instanceof Lizard){
                    ((Lizard) currentPet).makeSound();
                }
            }
            if (choice == 8){ //Special
                if (currentPet instanceof Dog){
                    ((Dog) currentPet).giveBath();
                }
                if (currentPet instanceof Lizard){
                    ((Lizard) currentPet).shedSkin();
                }
            }
            ((Pet) currentPet).printStatus();
        }else{
            System.out.println("Error: No pet loaded!");
        }
    }
    
    public void loadPet(){
        try {
            FileInputStream fileIn = new FileInputStream("Pet.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            currentPet = objectIn.readObject();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void savePet(){
        try {
            FileOutputStream fileOut = new FileOutputStream("Pet.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(currentPet);
            objectOut.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
