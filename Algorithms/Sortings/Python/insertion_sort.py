list = [43, 5, 6, 1, 0, 55, 23, -7]

for i in range(1, len(list)):
	cur = list[i]
	j = i - 1

	while j >= 0 & list[j] > cur:
		list[j + 1] = list[j]
		j -= 1
	list[j + 1] = cur