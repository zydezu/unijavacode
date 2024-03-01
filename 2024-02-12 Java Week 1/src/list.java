import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Random;
import java.util.Queue;

class Item {
    String name = "default";
    int quantity = 0;
    public Item(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    @Override /////////////////rrrrrrrrrrarws
    public String toString(){
        return this.name + "x" + this.quantity;
    }

    // @Override
    // public MOreThan add(Point other) {
        
    // }
}

class Converter {
    public static final double ZERO_KELVIN = -273.15;  

    public static double kelvinToCelcius(double t) {
        return t - ZERO_KELVIN;
    }   
    
    public static void printCelcius(double t) {
        System.out.println("The temperature is: " + t + "C.");
    }

    public static boolean isPalindrome(String data){
        String lower = data.toLowerCase();
        for (int i = 0; i < lower.length()/2; i++){
            if (lower.charAt(i) != lower.charAt(lower.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int data){
        return isPalindrome(Integer.toString(data));    
    }
}

public class list{
    public static void main(String[] args) throws Exception {

        int value = 2;
        final int x = 3;
        // switch is used over if here for readability
        switch (value) {
            case 2:
                System.out.println("two");
            case 5:
                System.out.println("one");
            case 4:
                System.out.println("one");
                break; // if you don't have a 'break' - it'll keep trickling downwards
            case x:
                System.out.println("x");
            default:
                System.out.println("I don't understand");
        }

        System.err.println(30 + Converter.ZERO_KELVIN);
        System.out.println(Converter.kelvinToCelcius(300));
        Converter.printCelcius(22);

        System.out.println(Converter.isPalindrome("racecar"));
        System.out.println(Converter.isPalindrome("10011"));
        System.out.println(Converter.isPalindrome(1001));

        Random random = new Random();

        String[] modules = {"SOF1", "SOF2", "DATA1"};

        System.err.println(Math.PI);

        final float PI = 3.14f;
        
        List<Integer> numList = new ArrayList<Integer>();
        numList.add(5);
        numList.add(5);
        numList.add(12);

        ArrayList<String> words = new ArrayList<String>(20);
        words.add("BLARGH");
        words.add("BLARGH");
        words.add("BLARGH");
        words.add("BLARGH");
        words.add("BLARGH");
        words.add(3,"WOOOO");
        System.err.println(words);
        System.err.println(words.get(3));
        for (String w : words) {
            System.err.println(w);
        }
        words.clear();
        //ArrayLIst<Integer> < Here "Integer" is a wrapper class

        int[][] arrayTest = new int[5][5];

        int[][] array2d = {{20,20},
                            {10,15},
                            {5,0}};

        int sumNumbers = 0;
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[i].length; j++) {
                sumNumbers += array2d[i][j];
            }
        }
        System.err.println("The sum of numbers is: " + sumNumbers);
        
        // jagged arrays can have rows of different length
        int[][] jaggedA = {{1,2,0,4}, {5,6}, {7,8,9}};
        jaggedA[0][3] = 0;
        
        // creating rows of different sizes using for loop
        int[][] triangular = new int[4][];
        for (int r = 0; r < triangular.length; r++){
            triangular[r] = new int[r+1];
        }
        int[] thirdRow = triangular[2];

        arrayTest[2][2] = 555;
        System.err.println(arrayTest[2][2]);

        Integer obj;
        int num = 42;
        int i;
        obj = num;

        System.err.println(Integer.parseInt("42"));

        Stack<Item> stackTest = new Stack<Item>();
        stackTest.push(new Item("Bread", 5));
        stackTest.push(new Item("Pizza", 2));
        stackTest.push(new Item("Pasta", 9));
        System.err.println(stackTest.pop());
        System.err.println(stackTest.peek());
        System.err.println(stackTest.pop());
        System.err.println(stackTest.pop());

        Queue<Item> hungry = new LinkedList<Item>();

        System.err.println("Loading...");
    }
}