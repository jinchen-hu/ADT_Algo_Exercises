import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int arr[]){
        mSort(arr, 0, arr.length -1);
    }

    private void mSort(int arr[], int l, int r){
        if(l < r){
            int m = (l+r) / 2;

            //Sort the left partition
            mSort(arr, l, m);
            //Sort the right partition
            mSort(arr, m+1, r);
            // merge sorted partitions
            merge(arr, l, m, r);
        }
    }

    private void merge(int arr[], int l, int m, int r){
        // Two partitions [l, m], [m+1, r]
        // Create a temp array
        int temp[] = new int[r-l+1];

        // index of the frist element in the left array
        int i = l;
        // index of the first element in the right array
        int j = m+1;
        // index of the frist element in the temp array
        int k = 0;

        // Merge two partitions to temp array by comparing each element 
        // one by one from left to right
        while(i <= m && j <= r){
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        // merge the remaining elements if any
        while(i <= m){
            temp[k++] = arr[i++];
        }
        while(j <= r){
            temp[k++] = arr[j++];
        }

        // Copy the values to original array
        for(int p = 0; p < temp.length; ++p){
            arr[l+p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int arr[] = {19, 45, 12, 22, 11, 90, 65};
        MergeSort ms = new MergeSort();
        System.out.println(Arrays.toString(arr));
        ms.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
