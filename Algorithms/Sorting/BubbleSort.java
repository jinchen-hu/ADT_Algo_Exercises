import java.util.Arrays;

public class BubbleSort{
    public void bubbleSort(int arr[]){
        if(arr == null || arr.length == 0)
            return;

        int len = arr.length;
        boolean swapped;

        for(int i = 0; i < len-1; ++i){
            swapped = false;
            for(int j = 0; j < len-i-1; ++j){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    swapped = true;
                }
            }

            // if no swaps, then break the loops
            if(!swapped)
                break;
        }
    }

    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {19, 45, 12, 22, 11, 90, 65};
        BubbleSort bs = new BubbleSort();
        System.out.println(Arrays.toString(arr));
        bs.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}