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
	j = lo_index
	for i in range(lo_index + 1, hi_index + 1):
		if secuence[i] < support_element:
			j += 1
			secuence[j], secuence[i] = secuence[i], secuence[j]
	secuence[lo_index], secuence[j] = secuence[j], secuence[lo_index]
	return j


secuence = [0, 5, -2, 7, 3]
print(quick_sort(secuence))
print(secuence)