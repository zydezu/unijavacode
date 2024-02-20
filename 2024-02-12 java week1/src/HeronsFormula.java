import java.util.Scanner;

public class HeronsFormula {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter sides a, b and c: ");
        float a = Integer.parseInt(keyboard.next()); 
        float b = Integer.parseInt(keyboard.next()); 
        float c = Integer.parseInt(keyboard.next()); 

        float s = (a+b+c) / 2;
        double area = Math.pow(s*(s-a)*(s-b)*(s-c), 0.5);

        System.out.println("The area of the triangle is " + area);

        keyboard.close();
    }
}