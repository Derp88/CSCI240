public class Cat extends Pet {
    //Abstract Method Implementations
    public void feedPet(){
        if (getHunger().increaseAttribute(1)){ //Only returns true when you can feed
            System.out.println("You fed " + getName() + " some lasanga");
        }else{
            System.out.println(getName() + " is too full to eat!");
        }
    }
    public void playPet(){
        System.out.println("You shined a lazer around the room that " + getName() + " chased");
        getStrength().increaseAttribute(1);
        getHunger().decreaseAttribute(1);
        getThirst().decreaseAttribute(1);
    }
    public void makeSound(){
        System.out.println("Meow!");
    }
}
