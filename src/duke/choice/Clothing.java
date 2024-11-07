package duke.choice;

//we later implemented the class to use the interface to compare objects
public class Clothing implements Comparable<Clothing>  { //in brackets are the type of things that we are comparing
    //static fields must be marked as public to be used by other classes; they are constants and there is no reason to use a getter and setter since they cannot be manipulated
    public static double minPrice = 10.0;
    public static double taxRate =  0.2;
    public Clothing(String description, double price, String size) {
        this.description = description;
        this.price = price;
        this.size = size;
    }
    private String description = "";
    private double price;
    private String size = "M";
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
       return price + (price * taxRate); //automatically add tax
    }
    public void setPrice(double price) {
        this.price = (price > minPrice) ? price : minPrice; //ensure price never smaller than min price;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    @Override// checks method signature
    public String toString(){
        return getDescription() + "," +  getSize() + "," + getPrice();
    }
    //this code is to understand interfaces
    @Override
    public int compareTo(Clothing c) {
        //the sort algorithm calls the compare and
        return this.description.compareTo(c.description); //comparing objects description
    }
}
