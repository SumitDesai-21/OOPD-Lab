public class Main {
    public static void main(String[] args) {
        Inventory<Electronics> electronicItem = new Inventory<>();
        electronicItem.addItem(new Electronics(1, "laptop", 50000, 2));
        electronicItem.addItem(new Electronics(2, "mobile", 20000, 1));


        Inventory<Grocery> groceryItem = new Inventory<>();
        groceryItem.addItem(new Grocery(3, "Milk", 30, "2 days"));
        groceryItem.addItem(new Grocery(4, "Bread", 35, "7 days"));

        Inventory<Clothing> clothItem = new Inventory<>();
        clothItem.addItem(new Clothing(5, "Shirt", 299.99, "L"));
        clothItem.addItem(new Clothing(6, "T Shirt", 199.99, "L"));

        // electronicItem.displayItems();
        // groceryItem.displayItems();
        // clothItem.displayItems();
        
        electronicItem.updatePrice(2, 15000);
        electronicItem.sortItems();
        electronicItem.displayItems();
    }
}
