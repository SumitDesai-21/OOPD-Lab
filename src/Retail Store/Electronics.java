public class Electronics extends Item {
    int warranty; // electronic item may have a warranty for few years

    Electronics(int id, String name, double price, int warranty){
        super(id, name, price);
        this.warranty = warranty;
    }
}
