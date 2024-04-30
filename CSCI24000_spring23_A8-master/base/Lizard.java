public class Lizard extends Pet {
    //Abstract Method Implementations
    public void feedPet(){
        if (getHunger().increaseAttribute(1)){ //Only returns true when you can feed
            System.out.println("You fed " + getName() + " some crickets");
        }else{
            System.out.println(getName() + " is too full to eat!");
        }
    }
    public void playPet(){
        System.out.println("You try to play with " + getName() + " ,but it seems like Lizards don't like to play");
        getHunger().decreaseAttribute(1);
        getThirst().decreaseAttribute(1);
    }
    public void makeSound(){
        System.out.println("Hiss!");
    }
    public void shedSkin(){
        System.out.println(getName() + " sheds his old skin");
        getStrength().increaseAttribute(1);
    }
}
