import java.util.Arrays;

public class QuickSort {
    private int partition(int arr[], int left, int right){
        int pivot = arr[right];
        int pivotIndex = right;

        while(left < right){
            while(left < right && arr[left] <= pivot)
                left++;
            while(left < right && arr[right] >= pivot)
                right--;
            swap(arr, left, right);
        }
        swap(arr, pivotIndex, right);
        return right;
    }

    private void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void quickSort(int arr[]){
        if(arr == null || arr.length == 0)
            return;
        qSort(arr, 0, arr.length-1);
    }

    private void qSort(int arr[], int left, int right){
        if(left >= right)
            return;
        int pivot = partition(arr, left, right);
        qSort(arr, left, pivot-1);
        qSort(arr, pivot+1, right);
    }

    public static void main(String[] args) {
        int arr[] = {19, 45, 12, 22, 11, 90, 65};
        QuickSort qs = new QuickSort();
        System.out.println(Arrays.toString(arr));
        qs.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
