import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Strings2 {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = keyboard.nextLine();

        List<String> newSentence = new ArrayList<String>();

        String builder = "";
        for (int i = 0; i < input.length(); i++) {
            Character currentChar = input.charAt(i);
            if (Character.isUpperCase(currentChar) && i > 0) {
                newSentence.add(builder);
                builder = "";
            }
            builder += currentChar;
            if (i + 1 == input.length()) {
                newSentence.add(builder);
            }
        }

        System.out.print(newSentence);
        keyboard.close();
    }   
}