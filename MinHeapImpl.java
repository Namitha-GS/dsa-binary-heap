package binary_heap;

public class MinHeapImpl {

	public static void main(String[] args) {
		int arr[] = {25,7,9,15,20,36,50};
		buildHeap(arr, arr.length-1);
		print(arr, arr.length);
	}

	private static void print(int[] arr, int size) {
		for(int i=0; i<size; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	private static void buildHeap(int[] arr, int size) {
		for(int i=size/2; i>=0; i--) {
			heapify(arr, i, size);
		}
	}

	private static void heapify(int[] arr, int index, int size) {
		int left = (2 * index) + 1;
		int right = left + 1;
		int min = index;
		
		if(left <= size && arr[left] < arr[min])
			min = left;		
		
		if(right <= size && arr[right] < arr[min])
			min = right;
		
		if(index != min) {
			int temp = arr[min];
			arr[min] = arr[index];
			arr[index] = temp;
			
			heapify(arr, min, size);
		}
	}

}
