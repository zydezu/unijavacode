import java.util.Scanner;

public class Strings {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = keyboard.nextLine();

        String output = "";
        String[] splits = input.split(" ");
        for (String split : splits) {
            output += split.substring(0,1).toUpperCase() 
            + split.substring(1);
        }

        System.out.print(output);
        keyboard.close();
    }   
}