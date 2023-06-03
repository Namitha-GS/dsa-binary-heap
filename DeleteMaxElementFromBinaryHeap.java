package binary_heap;

public class DeleteMaxElementFromBinaryHeap {

	public static void main(String[] args) {
		int[] arr = {10,20,40,30,80,60,50};
		buildHeap(arr, arr.length-1);
		System.out.println("Before deleting: ");
		print(arr, arr.length-1);
		
		deleteMax(arr);
	}

	private static void deleteMax(int[] arr) {
		int size = arr.length-1;
		swap(arr, 0, size);
		System.out.println("Deleted element is : "+arr[size]);
		size = size-1;
		heapify(arr, 0, size);
		System.out.println("After deleting Max element: ");
		print(arr, size);
	}

	private static void print(int[] arr, int size) {
		for(int i=0; i<=size; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	private static void buildHeap(int[] arr, int size) {
		for(int i=size/2; i>=0; i--) {
			heapify(arr, i, size);
		}
	}

	private static void heapify(int[] arr, int index, int size) {
		int left = 2*index + 1;
		int right = left + 1;
		
		int max = index;
		
		if(left <= size && arr[left] > arr[max])
			max = left;
		
		if(right <= size && arr[right] > arr[max])
			max = right;
		
		if(index != max) {
			swap(arr, index, max);
			heapify(arr, max, size);
		}
	}

	private static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;		
	}

}
