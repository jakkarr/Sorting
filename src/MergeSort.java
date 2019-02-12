import java.util.Arrays;

public class MergeSort extends Thread {
    public int[] mergeSort(int[] list){
        if(list.length>1) {
            int[] firsthalf = Arrays.copyOfRange(list, 0, (list.length / 2));
            int[] secondhalf = Arrays.copyOfRange(list, list.length / 2, list.length);
            return merge(new MergeSort().mergeSort(firsthalf), new MergeSort().mergeSort(secondhalf));
        }else {
            return list;
        }
    }

    private int[] merge(int[] a, int[] b){
        int[] retval = new int[a.length+b.length];
        int apos = 0;
        int bpos = 0;
        for (int i = 0; i < retval.length; i++) {
            if (apos>=a.length){
                if (bpos>= b.length){
                    return retval;
                }else{
                    retval = copy(b, retval, b.length-bpos);
                    return retval;
                }
            }else{
                if (bpos>= b.length){
                    copy(a, retval, a.length-apos);
                }else{
                    if (a[apos]<= b[bpos]){
                        retval[i] = a[apos];
                        apos++;
                    }else{
                        retval[i] = b[bpos];
                        bpos++;
                    }
                }
            }

        }
        return retval;
    }

    private int[] copy(int[] thisArray, int[] intoThis, int remainingBits){
        for (int i = 0; i < remainingBits; i++) {
            intoThis[intoThis.length-i-1] = thisArray[thisArray.length-i-1];
        }
        return intoThis;
    }
}
