package tools;

public class ArraySet<E> implements ISet<E> {
    
    E[] data;
    int size;

    public ArraySet(int size) {
        this.size = size;
        data = (E[]) new Object[size];
    }

    @Override
    public boolean add(E elt) {
        // Check for duplicates
        for (int i = 0; i < data.length; i++) {
            if (data[i] == elt) {
                return false;
            }
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = elt;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        data = (E[]) new Object[size];
        for (int i = 0; i < data.length; i++) {
            data[i] = null;
        }
    }

    @Override
    public boolean contains(E elt) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == elt) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty(){
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean remove(E elt){
        for (int i = 0; i < data.length; i++) {
            if (data[i] == elt) {
                data[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ISet<Integer> setInt = new ArraySet<>(5);
        System.err.println(setInt.isEmpty());
        System.err.println(setInt.add(2));
        System.err.println(setInt.add(3));
        System.err.println(setInt.add(4));
        System.err.println(setInt.add(5));
        System.err.println(setInt.add(2));
        setInt.clear();
        System.err.println(setInt.add(2));
        System.err.println(setInt.isEmpty());

        ISet<String> setStr = new ArraySet<>(5);
        System.err.println(setStr.add("hi"));
        System.err.println(setStr.add("hello"));
        System.err.println(setStr.add("howdy"));
        System.err.println(setStr.add("hi"));
    }
}
