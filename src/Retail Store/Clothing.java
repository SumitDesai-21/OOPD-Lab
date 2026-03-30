public class Clothing extends Item {
    String size; // M, L, XL, XXL
    Clothing(int id, String name, double price, String size){
        super(id, name, price);
        this.size = size;
    }
}
