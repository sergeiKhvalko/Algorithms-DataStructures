def quick_sort(secuence, lo_index=None, hi_index=None):
	if lo_index is None:
		lo_index = 0
	if hi_index is None:
		hi_index = len(secuence) - 1
	if lo_index >= hi_index:
		return None
	pivot = partition(secuence, lo_index, hi_index)
	quick_sort(secuence, lo_index, pivot - 1)
	quick_sort(secuence, pivot + 1, hi_index)

def partition(secuence, lo_index, hi_index):
	support_element = secuence[lo_index]
	i = lo_index + 1
	j = hi_index

	while True:
		while i < hi_index and secuence[i] < support_element:
			i += 1
		while j > lo_index and secuence[j] > support_element:
			j -= 1
		if i >= j:
			break
		secuence[i], secuence[j] = secuence[j], secuence[i]
		i += 1
		j -= 1
	secuence[lo_index], secuence[j] = secuence[j], secuence[lo_index]
	return j

list = [3, 1, 7, 0, 4, 2]
print(quick_sort(list))
print(list)