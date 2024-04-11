package tools;

public class LinkedStackInteger implements IStackInteger{

    Node top; // index of the top of the stack, 0 if empty

    public LinkedStackInteger(){
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean push(Integer value) {
        top = new Node(value, top);
        return true;
    }

    @Override
    public Integer peek() {
        if(top == null){
            return null;
        }
        return top.data;
    }

    @Override
    public Integer pop() {
        if(top == null){
            return null;
        }
        Integer value = peek();
        top = top.next;
        return value;
    }

    public static void main(String[] args) {
        IStackInteger stack = new ArrayStackInteger(10);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        int product = 1;
        while(!stack.isEmpty()){
            Integer element = (Integer) stack.pop();
            product *= element;
        }
        System.out.println("product is: " + product);
        product = -1;
        while(!stack.isEmpty()){
            Integer element = (Integer) stack.pop();
            product *= element;
        }
        System.out.println("product is: " + product);
        System.out.println("pop empty is: " + stack.pop());
    }

}