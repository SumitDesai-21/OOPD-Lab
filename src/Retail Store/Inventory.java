// generic inventory class

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory<T extends Item>{ // type safety to ensure only valid items would be used
    private List<T> items = new ArrayList<>();

    void addItem(T item){
        items.add(item);
    }
    void removeItem(T item){
        items.remove(item);
    }
    void displayItems(){
        for(T item: items){
            System.out.println(item);
        }
    }
    // update price of an item
    boolean updatePrice(int id, double newPrice){
        for(T item: items){
            if(item.id == id){
                item.price = newPrice;
                return true;
            }
        }
        return false; // item not available
    }

    void sortItems(){
        Collections.sort(items);
    }
}