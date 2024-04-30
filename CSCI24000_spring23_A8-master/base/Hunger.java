public class Hunger extends Attribute{

    public String getAttribStr(){
        if (getAttribute() < 2){
            return ("Starving");
        }else if (getAttribute() < 4){
            return ("Hungry");
        }else if (getAttribute() < 6){
            return ("Content");
        }else if (getAttribute() < 8){
            return ("Full");
        }else{
            return ("Stuffed");
        }
    }
    //For Testing
    public static void main(String[] args){
        System.out.println("Hunger test");
        Hunger testHunger = new Hunger();
        System.out.println(testHunger.getAttribute());
        System.out.println(testHunger.getAttribStr());
        System.out.println(testHunger.decreaseAttribute(1));
        System.out.println(testHunger.getAttribute());
        System.out.println(testHunger.getAttribStr());
    }
}
