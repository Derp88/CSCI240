
public abstract class Attribute implements java.io.Serializable{
    private int attributeVal;

    //Constructors
    public Attribute(){
        attributeVal = 5;
    }
    public Attribute(int initVal){
        attributeVal = initVal;
    }

    //Methods
    public void setAttribute(int val){
        attributeVal = val;
    }
    public int getAttribute(){
        return attributeVal;
    }
    public boolean increaseAttribute(int val){
        val = Math.abs(val);
        if (attributeVal + val < 10){
            attributeVal = attributeVal + val;
            return true;
        }else{
            return false; //Returns false incase the value tries to go above 10
        }
    }
    public boolean decreaseAttribute(int val){
        val = Math.abs(val);
        if (attributeVal - val > 0){
            attributeVal = attributeVal - val;
            return true;
        }else{
            return false; //Returns false incase the value tries to go below 0
        }
    }

    public abstract String getAttribStr();
}