public class BinarySearch{
    public boolean binarySearch(int arr[], int start, int end, int target){
        if(end >= start){
            int mid = (end - start) / 2 + start;

            if(target == arr[mid])
                return true;
            if(target < arr[mid])
                return binarySearch(arr, start, mid - 1, target);
            return binarySearch(arr, mid + 1, end, target);
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 7, 10};
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(arr, 0, arr.length, 3));
        System.out.println(bs.binarySearch(arr, 0, arr.length, 7));
    }
}