import java.util.Arrays;

public class SelectionSort {
    public void selectionSort(int arr[]){
        if(arr==null || arr.length == 0)
            return;
        
        int minIndex = 0;
        int len = arr.length;
        // 
        for (int i = 0; i < len -1; ++i){
            // Current index of minimum element 
            minIndex = i;
            // Find the minimum element in unsorted subarray
            for (int j = i + 1; j < len; j++){
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }

            if (minIndex != i)
                swap(arr, i, minIndex);
        }
    }   
    
    public void swap (int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {19, 45, 12, 22, 11, 90, 65};
        SelectionSort ss = new SelectionSort();
        System.out.println(Arrays.toString(arr));
        ss.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
