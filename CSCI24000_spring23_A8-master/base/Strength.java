public class Strength extends Attribute{

    public String getAttribStr(){
        if (getAttribute() < 2){
            return ("Super Weak");
        }else if (getAttribute() < 4){
            return ("Weak");
        }else if (getAttribute() < 6){
            return ("Normal");
        }else if (getAttribute() < 8){
            return ("Strong");
        }else{
            return ("Super Strong");
        }
    }
    //For Testing
    public static void main(String[] args){
        System.out.println("Strength test");
        Strength testStrength = new Strength();
        System.out.println(testStrength.getAttribute());
        System.out.println(testStrength.getAttribStr());
        System.out.println(testStrength.decreaseAttribute(1));
        System.out.println(testStrength.getAttribute());
        System.out.println(testStrength.getAttribStr());
    }
}
