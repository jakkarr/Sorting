import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
            int[] random = m.createRandomArray(50_000_000);

        long start= System.nanoTime();
        MergeSort sort = new MergeSort();
        sort.mergeSort(random);
        System.out.println("fertig\t"+((System.nanoTime()-start)/1_000_000f+" ms"));
    }
    
    public int[] createRandomArray(int size){
        Random r = new Random(System.currentTimeMillis());
        int[] retval = new int[size];
            for (int i = 0; i < size; i++) {
                retval[i] = r.nextInt(size);
            }
        return retval;
    }
    


    public void show(int[] a){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        System.out.println(list);
    }
}
