list = [
    120, 28, 23, 24, 48, 454, 1, 402, 31, 44, 50, 420, 3, 15, 14, 16, 35, 27,
    111, 30, 11, 6, 230, 37, 50, 8, 26, 505, 1588, 2298,
  ]

length = len(list)

while True:
	number_of_swap = 0
	for i in range(0, length-1):
		if list[i] > list[i + 1]:
			list[i], list[i + 1] = list[i + 1], list[i]
			number_of_swap += 1
	length -= 1
	if number_of_swap == 0:
		break

print(list)