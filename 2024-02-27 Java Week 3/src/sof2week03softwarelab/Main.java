package sof2week03softwarelab;

public class Main {
    public static void main(String[] args) throws Exception {
        // these are test cases aaaa~ 

        double[] data = { 1.0, 2.0, 3.0 };
        Vector vectorObj = new Vector(data);
        System.out.println(vectorObj.toString());
        System.out.println(vectorObj.size());
        System.out.println(vectorObj.get(2));
        System.out.println(vectorObj.set(1, 5.0));
        System.out.println(vectorObj.get(1));

        System.out.println("Scalar: " + vectorObj.scalarProduct(5).toString());

        System.out.println("Vector add: " + vectorObj.add(new Vector(data)).toString());

        Vector vectorObj2 = new Vector(data);
        Vector vectorObj3 = new Vector(data);
        System.out.println(vectorObj2.equals(vectorObj3));
    }
}
