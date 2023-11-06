func InsertionSort(arr []T) []T {
	for i := 1; i < len(arr); i++ {
		cur := arr[i]
		j := i
		for ; j > 0 && arr[j-1] > cur; j-- {
			arr[j] = arr[j-1]
		}
		arr[j] = cur
	}
	return arr
}