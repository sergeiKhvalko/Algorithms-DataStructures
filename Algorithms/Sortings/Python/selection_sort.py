list = [5, 0, -2, 7, 3]

for i in range(0, len(list) - 1):
	min_index = i
	for j in range(i + 1, len(list)):
		if list[min_index] > list[j]:
			min_index = j
	if min_index != i:
		temp = list[min_index]
		list[min_index] = list[i]
		list[i] = temp

print(list)