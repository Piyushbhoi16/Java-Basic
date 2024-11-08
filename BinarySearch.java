public class BinarySearch {
    public static int binarySearch(int[] arr, int target){
        int low = 0; int high = arr.length-1;
        while(low<=high){
            
            int mid = low + (high-low)/2;
            if(arr[mid]==target){
                return mid;
            }
            if(arr[mid]<target){
                low = mid+1;
            }
            else{
                high = mid -1;
            }
        }
        return -1;
    }
	public static void main(String[] args) {
       	int[] arr = {2,4,5,8,12};
	int target = 5;
	int result = binarySearch(arr, target);
	if(result!=-1)
	System.out.println("Element is found at index : "+result);
	else
	System.out.println("Element not found");
	
	}
}
