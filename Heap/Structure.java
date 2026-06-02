import java.util.*;

class Heap {

    ArrayList<Integer> heap;
    int size;

    public Heap() {
        heap = new ArrayList<>();
        size = 0;
    }

    public void insert(int x) {
        heap.add(x);
        size++;

        int i = heap.size() - 1;

        while (i > 0) {
            int parent = (i - 1) / 2;

            if (heap.get(parent) > heap.get(i)) {
                Collections.swap(heap, parent, i);
                i = parent;
            } else {
                return;
            }
        }
    }

    public void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int smallest = i;

        if (left < size && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < size && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            Collections.swap(heap, smallest, i);
            heapify(smallest);
        }
    }
    public int delete(){
        if(size==0) return -1;

        int root=heap.get(0);
        int last=heap.get(size-1);
        heap.set(0,last);
        heap.remove(size-1);
        size--;
        heapify(0);
        return root;
    }

    public void buildHeap(int[] arr) {
        for (int x : arr) {
            insert(x);
        }
    }
}

public class Structure {
    public static void main(String[] args) {

        Heap h = new Heap();

        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5};

        h.buildHeap(arr);

        System.out.println(h.heap);
        int x=h.delete();
        System.out.println("delete value: " + x+ " " +h.heap);
    }
}