public class Grocery extends Item{
    // a grocery item have an expiry date for sure
    String expiryDate;

    Grocery(int id, String name, double price, String expiryDate){
        super(id, name, price);
        this.expiryDate = expiryDate;
    }
}
