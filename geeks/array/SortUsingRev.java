package geeksforgeeks.array;

public class SortUsingRev {
	
	public int[] rev(int arr[], int i){
		for(int a=0; a<(i+1)/2; a++){
			arr[a]     = arr[a] - arr[i-a];
			arr[i-a]   = arr[i-a] + arr[a];
			arr[a]     = arr[i-a]-arr[a];
		}
		
		return arr;
	}
	
	public void printArray(int arr[]){
		for(int a=0; a<arr.length; a++)
			System.out.print(arr[a] + " ");
		System.out.println();
	}
	
	public int findMax(int arr[], int sz){
		int i=0;
		for(int a=1; a<=sz; a++){
			if(arr[a] > arr[i])
				i = a;
		}
		
		return i;
	}
	
	public int[] sort(int arr[]){
		int sz = arr.length-1;
		for(int i=0; i<arr.length; i++){
			int max = findMax(arr, sz);
			arr = rev(rev(arr, max), sz);
			sz--;
		}
		return arr;
	}
	
	public static void main(String args[]){
		SortUsingRev obj = new SortUsingRev();
		int arr[] = {4,9,3,7,1,2,8};
		obj.printArray(arr);
		obj.printArray(obj.sort(arr));
		
		
	}

}

