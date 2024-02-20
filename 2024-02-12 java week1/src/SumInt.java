import java.util.Scanner;

public class SumInt {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        int total = 0;

        while (true) {
            System.out.print("Enter a number: ");
            int input = Integer.parseInt(keyboard.next());
            if (input == 0) {
                break;
            } else if (input > 0) {
                total += input;
            }
        }

        System.out.print("Total: " + total);
        keyboard.close();
    }   
}