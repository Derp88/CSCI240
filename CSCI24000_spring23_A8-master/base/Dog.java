public class Dog extends Pet{
    //Abstract Method Implementations
    public void feedPet(){
        if (getHunger().increaseAttribute(1)){ //Only returns true when you can feed
            System.out.println("You fed " + getName() + " some kibble");
        }else{
            System.out.println(getName() + " is too full to eat!");
        }
    }
    public void playPet(){
        System.out.println("You took " + getName() + " on a walk");
        getStrength().increaseAttribute(1);
        getHunger().decreaseAttribute(1);
        getThirst().decreaseAttribute(1);
    }
    public void makeSound(){
        System.out.println("Woof Woof!");
    }
    public void giveBath(){
        System.out.println("You gave " + getName() + " a bath. They are now clean");
    }
    public static void main(String[] args){
        System.out.println("DOG TEST!");
        Dog testDog = new Dog();
        testDog.assignName("Billy");
        testDog.printStatus();
        testDog.feedPet();
        testDog.printStatus();
        testDog.feedPet();
        testDog.feedPet();
        testDog.feedPet();
        testDog.feedPet();
        testDog.feedPet();
        testDog.feedPet();
        testDog.feedPet();
        testDog.printStatus();
        testDog.petSleep();
        testDog.printStatus();
        testDog.giveWater();
        testDog.printStatus();
        testDog.makeSound();
        testDog.playPet();
        testDog.printStatus();
    }
}
