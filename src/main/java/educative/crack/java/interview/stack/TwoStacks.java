package educative.crack.java.interview.stack;

public class TwoStacks<V> {
    private int maxSize;
    private V[] array;

    @SuppressWarnings("unchecked")
    public TwoStacks(int max_size) {
        this.maxSize = max_size;
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
    }

    private int firstStackSize = 0;
    private int secondStackSize = 0;

    //insert at top of first stack
    public void push1(V value) {
        array[firstStackSize] = value;
        firstStackSize++;
    }

    //insert at top of second stack
    public void push2(V value) {
        array[maxSize / 2 + secondStackSize] = value;
        secondStackSize++;
    }

    //remove and return value from top of first stack
    public V pop1() {
        V result = array[firstStackSize - 1];
        firstStackSize--;

        return result;
    }

    //remove and return value from top of second stack
    public V pop2() {
        V result = array[maxSize / 2 + secondStackSize - 1];
        secondStackSize--;

        return result;
    }
}
