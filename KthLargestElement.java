private static int getKthLargestElement(int[] arr, int size, int k) {		
		buildHeap(arr, k-1);
		
		for(int i=k; i<=size; i++) {
			if(arr[i] > arr[0]) {
				arr[0] = arr[i];
				heapify(arr, 0, k-1);
			}
		}
		return arr[0];
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
