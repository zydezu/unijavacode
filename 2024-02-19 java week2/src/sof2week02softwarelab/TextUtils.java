package sof2week02softwarelab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TextUtils {
    static int toBase10(String binary) {
        int total = 0;
        int power = binary.length() - 1;
        for (char val : binary.toCharArray()) {
            if (val == '1') {
                total += Math.pow(2, power);
            }
            power -= 1;
        }
        return total;
    }

    static String[] split(String text) {
        List<String> textSplit = new ArrayList<String>();
        String builder = "";
        for (char val : text.toCharArray()) {
            if (val == ' ') {
                textSplit.add(builder);
                builder = "";
            } else {
                builder += val;
            }
        }
        if (builder.length() > 0) {
            textSplit.add(builder);
        }
        return textSplit.toArray(new String[0]);
    }

    static String[] split(String text, String seperators) {
        List<String> textSplit = new ArrayList<String>();
        String builder = "";
        for (char val : text.toCharArray()) {
            if (seperators.contains(Character.toString(val))) {
                if (builder.length() > 0) {
                    textSplit.add(builder);
                }
                builder = "";
            } else {
                builder += val;
            }
        }
        if (builder.length() > 0) {
            textSplit.add(builder);
        }
        return textSplit.toArray(new String[0]);
    }

    static int[][] rasterise(int[] data, int width) {
        if (width == 0 || data.length % width != 0){
            return null;
        }
        int[][] newArray = new int[data.length/width][width];
        for (int i = 0; i < newArray.length; i++) {
            for (int j = 0; j < width; j++) {
                newArray[i][j] = data[(i*width)+j];
            }
        }
        return newArray;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(toBase10("10001011"));
        System.err.println(Arrays.toString(split("hello every body"))); //PRINT array
        System.err.println(Arrays.toString(split("huh. what?", " ,.!?"))); //PRINT array
        
        int[] data = {1,2,3,4,5,6,7,8,9,10,11,12};
        System.err.println(Arrays.deepToString(rasterise(data, 4))); //PRINT array
    }
}
