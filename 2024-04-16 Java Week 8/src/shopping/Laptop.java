package shopping;

import java.util.ArrayList;
import java.util.Comparator;

public class Laptop {
    public static final String BRAND = "BRAND";
    public static final String MODEL = "MODEL";
    public static final String RAM = "RAM";
    public static final String SSD = "SSD";
    public static final String PRICE = "PRICE";

    private String barcode;
    private String brand;
    private String model;
    private int ram;
    private int ssd;
    private int price;

    public Laptop() {

    }

    public Laptop(String barcode, String brand, String model, int ram, int ssd, int price) {
        this.barcode = barcode;
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.ssd = ssd;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRAM() {
        return ram;
    }

    public void setRAM(int ram) {
        this.ram = ram;
    }

    public int getSSD() {
        return ssd;
    }

    public void setSSD(int ssd) {
        this.ssd = ssd;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static Comparator<Laptop> getComparator(String field) throws IllegalArgumentException {
        switch (field) {
            case BRAND:
                return Comparator.comparing(Laptop::getBrand);
            case MODEL:
                return Comparator.comparing(Laptop::getModel);
            case RAM:
                return Comparator.comparingInt(Laptop::getRAM);
            case SSD:
                return Comparator.comparingInt(Laptop::getSSD);
            case PRICE:
                return Comparator.comparingInt(Laptop::getPrice);
            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }
    }

    public String toString() {
        double num = price/100;
        return "<" + brand + ":" + model + "(RAM=" + ram + "GB, SSD=" + ssd + "GB, Price=£" + String.format("%.2f", num) + ")>";
    }

    public static void main(String[] args) {
        ArrayList<Laptop> laps = new ArrayList<>();
        laps.add(new Laptop("001", "Apple", "mac", 8, 128, 60000));
        laps.add(new Laptop("002", "Microsoft", "SurfaceBook2",
                                       16, 512, 260000));
        laps.add(new Laptop("003", "HP", "Sensa", 8, 256, 80000));
        laps.add(new Laptop("004", "Asus", "zen13", 16, 256, 100000));
        laps.add(new Laptop("005", "Asus", "minibook", 2, 64, 40000));

        ArrayList<Laptop> lapsToSort = new ArrayList<>(laps);
        lapsToSort.sort(getComparator(BRAND));
        System.err.println(lapsToSort);
        // ListIterator<Laptop> li = lapList.listIterator();
        // System.err.println(li.next());
    }
}