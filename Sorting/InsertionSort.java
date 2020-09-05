import java.util.Arrays;

public class InsertionSort {
    public void insertionSort(int arr[]){
        if(arr == null || arr.length == 0)
            return;
        
        for(int i = 1; i < arr.length; ++i){
            int key = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int arr[] = {19, 45, 12, 22, 11, 90, 65};
        InsertionSort is = new InsertionSort();
        System.out.println(Arrays.toString(arr));
        is.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
