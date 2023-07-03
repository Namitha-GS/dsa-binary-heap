void getTopKElements(int arr[], int size, int k) 
{
    BuildHeap(arr, k-1);
		
    for(int i=k; i<=size; i++) {
		if(arr[i] > arr[0]) {
			arr[0] = arr[i];
			Heapify(arr, 0, k-1);
		}
	}
		
	for(int i=k-1; i>=0; i--) {
		System.out.println(arr[i]);
	}

}

void BuildHeap(int arr[], int size) {
	int i;

	for (i = size / 2; i >= 0; i--)
		Heapify(arr, i, size);
}

void Heapify(int arr[], int index, int size) {
	
	int left = 2 * index + 1;
	int right = left + 1;

	int min = index;

	if (left <= size && arr[left] < arr[min])
		min = left;

	if (right <= size && arr[right] < arr[min])
		min = right;

    if (index != min) {
        int temp = arr[min];
        arr[min] = arr[index];
        arr[index] = temp;
        Heapify(arr, min, size);
    }
}
