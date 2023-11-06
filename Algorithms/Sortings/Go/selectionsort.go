func SelectionSort(arr T[]) T[] {
	for i := 0; i < len(arr) - 1; i++ {
		min := 0
		for j := i + 1; j < len(arr); j++ {
			if(arr[j] < arr[min]) {
				min = j
			}
		}
		if(min != i) {
			arr[i], arr[min] = arr[min], arr[i]
		}
	}
	return arr
}