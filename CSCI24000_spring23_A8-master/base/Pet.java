public abstract class Pet implements java.io.Serializable{
    private String name;
    private Hunger PetHunger;
    private Thirst PetThirst;
    private Strength PetStrength;

    //Constructor
    public Pet(){
        this.name = "anon";
        PetHunger = new Hunger();
        PetThirst = new Thirst();
        PetStrength = new Strength();
    }

    //Seters and Geters for each object
    public void setHunger(Hunger PetHunger){
        this.PetHunger = PetHunger;
    }
    public Hunger getHunger(){
        return this.PetHunger;
    }
    public void setThirst(Thirst PetThirst){
        this.PetThirst = PetThirst;
    }
    public Thirst getThirst(){
        return this.PetThirst;
    }
    public void setStrength(Strength PetStrength){
        this.PetStrength = PetStrength;
    }
    public Strength getStrength(){
        return this.PetStrength;
    }

    //General ways of interacting with the pet
    public void assignName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    //These are ones the user will mainly use
    public void petSleep(){
        getHunger().decreaseAttribute(1);
        getThirst().decreaseAttribute(1);
    }
    public void giveWater(){
        getThirst().increaseAttribute(1);
    }

    public void printStatus(){
        System.out.println("###################");
        System.out.println("Hunger: " + getHunger().getAttribute() + ", " + getHunger().getAttribStr());
        System.out.println("Thirst: " + getThirst().getAttribute() + ", " + getThirst().getAttribStr());
        System.out.println("Strength: " + getStrength().getAttribute() + ", " + getStrength().getAttribStr());
        System.out.println("###################");
    }

    //Abstract methods
    public abstract void feedPet();
    public abstract void playPet();
    public abstract void makeSound();

}
