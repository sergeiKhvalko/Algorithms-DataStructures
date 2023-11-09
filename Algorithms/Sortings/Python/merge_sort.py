def merge(sequence, support, ls, le, rs, re):
	for i in range(ls, re+1):
		support[i] = sequence[i]

	l = ls
	r = rs

	for i in range(ls, re+1):
		if l > le:
			sequence[i] = support[r]
			r += 1
		elif r > re:
			sequence[i] = support[l]
			l += 1
		elif support[l] < support[r]:
			sequence[i] = support[l]
			l += 1
		else:
			sequence[i] = support[r]
			r += 1
	return None

def merge_sort_iterative(sequence):
	support = sequence[::]
	n = len(support)
	size = 1
	while size < n:
		j = 0
		while j < n - size:
			merge(sequence, support, j, j+size-1, j+size, min(j+2*size-1, n-1))
			j += 2 * size
		size = size * 2
	return None

def merge_sort_recursive(sequence, support=None, start_index=None, stop_index=None):
	if support is None:
		support = sequence[::]
	if start_index is None:
		start_index = 0
	if stop_index is None:
		stop_index = len(sequence) - 1
	if start_index >= stop_index:
		return None
	h = start_index + (stop_index - start_index) // 2
	merge_sort_recursive(sequence, support, start_index, h)
	merge_sort_recursive(sequence, support, h+1, stop_index)
	merge(sequence, support, start_index, h, h+1, stop_index)

sequence = [5, 0, -2, 7, 3]
merge_sort_recursive(sequence)
print(sequence)