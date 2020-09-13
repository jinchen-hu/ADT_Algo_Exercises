import java.util.Arrays;

public class RecursiveInsertionSort {
    public void recursiveInsertionSort(int arr[], int len){
        //Base Case
        if(len <= 1)
            return;
        // Sort first n-1 elements
        recursiveInsertionSort(arr, len-1);
        
        // Insert last element at its correct position in sorted array
        int last = arr[len-1];
        int j = len - 2;

        while(j >= 0 && arr[j] > last){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = last;
    }

    public static void main(String[] args) {
        int arr[] = {19, 45, 12, 22, 11, 90, 65};
        RecursiveInsertionSort ris = new RecursiveInsertionSort();
        System.out.println(Arrays.toString(arr));
        ris.recursiveInsertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
