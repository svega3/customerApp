package duke.choice;

public class Customer {
    private String name = "";
    public Customer(String name, int measurement) {
        this.name = name;
        setSize(measurement); //calling setSize here
    }
    private String size;
    private Clothing [] items;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public void setSize(int measurement){
        switch (measurement){
            case 1, 2, 3:
                setSize("S"); //calling on setter to
                break;
            case 4, 5, 6:
                setSize("M");
                break;
            case 7, 8, 9:
                setSize("L");
                break;
            default:
                setSize("X");
        }
    }
    //assings the array it accepts to the items instance variable
    public void addItems(Clothing [] someItems){
        items = someItems;
    }
    //returns an array of clothing items
    public Clothing[] getItems(){
        return items;
    }
    public  double getTotalClothingCost(){
        double total = 0.0;
        //calculate and return cost for all clothing items
        for (Clothing item: items){
            //calc total only include items that match customer size, small
            total = total + item.getPrice();
//            if (c1.getSize().equals(item.getSize())){
//                total= total + total *tax;
//                if (total >=15){break;}
        }
        return total;
    }
}
