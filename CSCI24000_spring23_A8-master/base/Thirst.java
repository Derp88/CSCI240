public class Thirst extends Attribute{

    public String getAttribStr(){
        if (getAttribute() < 2){
            return ("Extremely dehydrated");
        }else if (getAttribute() < 4){
            return ("Dehydrated");
        }else if (getAttribute() < 6){
            return ("Content");
        }else if (getAttribute() < 8){
            return ("Hydrated");
        }else{
            return ("Beyond hydrated");
        }
    }
    //For Testing
    public static void main(String[] args){
        System.out.println("Thirst test");
        Thirst testThirst = new Thirst();
        System.out.println(testThirst.getAttribute());
        System.out.println(testThirst.getAttribStr());
        System.out.println(testThirst.decreaseAttribute(1));
        System.out.println(testThirst.getAttribute());
        System.out.println(testThirst.getAttribStr());
    }
}
