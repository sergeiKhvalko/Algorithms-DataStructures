void selectionSort(int[] arr) {
	for(int i = 0; i < arr.length - 1; i++) {
		int min_index = i;
		for(int j = i + 1; j < arr.length; j++) {
			if(arr[j] < arr[min_index]) {
				min_index = j;
			}
		}
		if(min_index != i) {
			let temp = arr[min_index];
			arr[min_index] = arr[i];
			arr[i] = temp;
		}
	}
}