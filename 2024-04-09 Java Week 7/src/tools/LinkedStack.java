package tools;

public class LinkedStack<T> implements IStack<T>{

    Node<T> top; // index of the top of the stack, 0 if empty

    public LinkedStack(){
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean push(T value) {
        top = new Node<T>(value, top);
        return true;
    }

    @Override
    public T peek() {
        if(top == null){
            return null;
        }
        return top.data;
    }

    @Override
    public T pop() {
        if(top == null){
            return null;
        }
        T value = peek();
        top = top.next;
        return value;
    }

    public static void main(String[] args) {
        IStack<Integer> stack = new ArrayStack<>(10);
        stack.push(3);
        stack.push(2);
        stack.push(5);
        stack.push(12);
        stack.push(7);
        int product = 1;
        while(!stack.isEmpty()){
            Integer element = (Integer) stack.pop();
            product *= element;
        }
        System.out.println("product is: " + product);

        IStack<String> stackStr = new ArrayStack<>(10);
        stackStr.push("two");
        stackStr.push("three");
        stackStr.push("four");
        stackStr.push("five");
        while(!stackStr.isEmpty()) {
            System.err.println(stackStr.pop());
        }
    }

}