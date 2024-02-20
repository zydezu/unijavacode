import java.util.Scanner;

public class UserInputs {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter an int: ");
        int number = Integer.parseInt(keyboard.next()); 

        System.out.println("number entered is: " + number);

        keyboard.close();
    }

    
}
