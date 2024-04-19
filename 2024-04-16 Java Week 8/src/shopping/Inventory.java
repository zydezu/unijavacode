package shopping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    Map<String, Laptop> stockList;

    public Inventory() {
        stockList = new HashMap<>();
    }

    public void addLaptop(Laptop laptop) {
        stockList.put(laptop.getBarcode(), laptop);
    }

    public List<Laptop> sortInventory(String field) throws IllegalArgumentException {
        List<Laptop> laptops = new ArrayList<>(stockList.values());
        laptops.sort(Laptop.getComparator(field));
        return laptops;
    }

    public List<Laptop> sortInventory(String field, Boolean reversed) throws IllegalArgumentException {
        List<Laptop> laptops = new ArrayList<>(stockList.values());
        laptops.sort(Laptop.getComparator(field));
        if (reversed) Collections.reverse(laptops);
        return laptops;
    }

    public static void main(String[] args) throws Exception {
        Inventory inventory = new Inventory();
        inventory.addLaptop(new Laptop("001", "Apple", "mac", 8, 128, 60000));
        inventory.addLaptop(new Laptop("002", "Microsoft", "SurfaceBook2",
                                       16, 512, 260000));
        inventory.addLaptop(new Laptop("003", "HP", "Sensa", 8, 256, 80000));
        inventory.addLaptop(new Laptop("004", "Asus", "zen13", 16, 256, 100000));
        inventory.addLaptop(new Laptop("005", "Asus", "minibook", 2, 64, 40000));
        System.out.println(inventory.sortInventory(Laptop.BRAND));
        System.out.println(inventory.sortInventory(Laptop.PRICE));
        System.out.println(inventory.sortInventory(Laptop.PRICE, true));
      }      
}
