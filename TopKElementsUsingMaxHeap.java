package binary_heap;

public class TopKElementsUsingMaxHeap {

	public static void main(String[] args) {
		int[] arr = {5,30,99,80,100,1};
		int size = arr.length-1;
		int k=4;
		getTopKElements(arr, size, k);
	}
	
	static void getTopKElements(int arr[], int size, int k) {
		buildHeap(arr, size);  
		
		int i = 0;
		while(i < k) {
			swap(arr, 0, size);
			size--;
			heapify(arr, 0, size);
			i++;
		}
		
		int len = arr.length-1;
		for(i=len; i>len-k; i--) {
			System.out.print(arr[i]+" ");
		}
	}
	
	static void buildHeap(int[] arr, int size){
	    for(int i=size/2; i>=0; i--){
	        heapify(arr, i, size);
	    }
	}

	static void heapify(int[] arr, int index, int size){
	    int left = (2*index) + 1;
	    int right = left + 1;
	    
	    int max = index;
	    
	    if(left <= size && arr[left] > arr[max]){
	        max = left;
	    }
	    if(right <= size && arr[right] > arr[max]){
	        max = right;
	    }
	    if(max != index){
	        swap(arr, max, index);
	        heapify(arr, max, size);
	    }
	}

	static void swap(int[] arr, int i, int j){
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}

}
