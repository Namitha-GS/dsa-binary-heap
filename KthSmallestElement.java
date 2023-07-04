int kthSmallestNumber(int arr[], int size, int k)
{
    buildHeap(arr, k-1);
    
    for(int i=k; i<=size; i++){
        if(arr[i] < arr[0]){
            arr[0] = arr[i];
            heapify(arr, 0, k-1);
        }
    }
    return arr[0];
}

void buildHeap(int[] arr, int size){
    for(int i=size/2; i>=0; i--){
        heapify(arr, i, size);
    }
}

void heapify(int arr[], int index, int size){
    int left = 2*index + 1;
    int right = left + 1;
    
    int max = index;
    
    if(left<=size && arr[left] > arr[max]){
        max = left;
    }
    
    if(right<=size && arr[right] > arr[max]){
        max = right;
    }
    
    if(max != index){
        int temp = arr[max];
        arr[max] = arr[index];
        arr[index] = temp;
        heapify(arr, max, size);
    }
}
