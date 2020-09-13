import java.util.Arrays;

public class RecursiveBubbleSort {
    public void recursiveBubbleSort(int arr[], int len){
        // Base Case
        if (len <= 1)
            return;
        
        for(int i=0; i < len - 1; i++){
            if(arr[i] > arr[i+1])
                swap(arr, i, i+1);
        }

        recursiveBubbleSort(arr, len-1);
    }

    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {19, 45, 12, 22, 11, 90, 65};
        RecursiveBubbleSort rbs = new RecursiveBubbleSort();
        System.out.println(Arrays.toString(arr));
        rbs.recursiveBubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
