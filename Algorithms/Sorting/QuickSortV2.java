import java.util.Arrays;

public class QuickSortV2 {
    private int partition(int arr[], int left, int right){
        int pivot = arr[right];

        for(int i = left; i < right; i++){
            if(arr[i] < pivot){
                swap(arr, left, i);
                left++;
            }
        }

        swap(arr, left, right);
        return left;
    }

    private void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void qSort(int arr[], int left, int right){
        int partition = partition(arr, left, right);

        if(partition - 1 > left){
            qSort(arr, left, partition-1);
        }
        if(partition+1 < right){
            qSort(arr, partition+1, right);
        }
    }

    public void quickSort(int arr[]){
        if(arr == null || arr.length == 0)
            return;
        qSort(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        int arr[] = {19, 45, 12, 22, 11, 90, 65};
        QuickSortV2 qs = new QuickSortV2();
        System.out.println(Arrays.toString(arr));
        qs.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
