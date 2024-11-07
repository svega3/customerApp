package duke.choice;

import java.net.InetAddress;
import java.net.UnknownHostException;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.util.logging.Logger;

//Program that runs an SE server inside main, listens for request from browser and responds with the output of the program.

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Duke Choice App");
        System.out.println("The min price is: " + Clothing.minPrice);
        Customer c1 = new Customer("pinky", 3);
        Clothing item1 = new Clothing("Blue Jacket", 20.9,"M");
        Clothing item2 = new Clothing("Orange T-shirt",10.5,"s");

        Clothing [] items = {item1,item2,new Clothing("Green Scarf", 5, "s"), new Clothing("Blue T-shirt", 10.5,"s")};

        try{
            ItemList list = new ItemList(items);
            Routing routing = Routing.builder().get("/items",list).build();
            ServerConfiguration config = ServerConfiguration.builder().bindAddress(InetAddress.getLocalHost()).port(8888).build(); //builder is patter
            WebServer ws = WebServer.create(config,routing);
            ws.start(); //starts the server
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }

//        c1.addItems(items); //adding items to the array and passed it in
//        //printing out cutomer information here
//        System.out.println("Customer is " + c1.getName() + "!" + c1.getSize() + "," + c1.getTotalClothingCost());
//
//        //iterate through the items and printing out each item
//        for (Clothing item: c1.getItems()){
//            System.out.println("item" + item);
//        }
////code below is used to learn try catch; calculates average cost for a customer only for size l
//        int average = 0;
//        int count = 0;
//        for (Clothing item :c1.getItems()){
//            if(item.getSize().equals("L")){
//                count ++;
//                average += item.getPrice();
//            }
//        }try{
//            average = (count ==0)? 0:average/count; //if equal to 0; return
//            average=average/count; //trows exception
//            System.out.println("average Price"+average+"coun"+count);
//        } catch (ArithmeticException e){
//            System.out.println("don't divide by 0");
//        }
//        Arrays.sort(c1.getItems());
//        for (Clothing item: c1.getItems()){
//            System.out.println("item" + item);
//        }


    }
}
