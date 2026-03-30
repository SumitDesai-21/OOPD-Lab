// base class i.e structure for each item of any type (electronic, grocery, cloth)

// implement comparable interface
public class Item implements Comparable<Item>{
    int id; // item id 
    String name; // item name
    double price; // price of an item

    // constructor
    Item(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    // override toString
    @Override
    public String toString(){
        return "ID: "+ id+ ", name: "+ name+", price: "+ price;
    }

    @Override
    public int compareTo(Item other){
        return Double.compare(this.price, other.price); // sort by price in ascending order
    }
}
