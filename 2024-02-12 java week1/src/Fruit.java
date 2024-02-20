import java.util.Scanner;

public class Fruit {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter number of kilo of bananas: ");
        int kilos = Integer.parseInt(keyboard.next()); 

        float price = kilos * 3;
        if (price > 50.00) {
            price += 3.49;
        } else {
            price += 4.99;
        }

        System.out.println("Price is: £" + String.format("%.2f", price));

        keyboard.close();
    }

    
}
