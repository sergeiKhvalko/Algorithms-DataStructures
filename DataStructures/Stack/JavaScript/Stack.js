const minOperations = function (s) {
	const arr = s.split('')
	console.log(arr)
	let count = 0
	for (let i = 0; i < arr.length - 1; i++) {
		if (arr[i] == arr[i + 1]) {
			arr[i + 1] = arr[i + 1] == 1 ? 0 : 1
			count += 1
		}
	}
	console.log(arr)
	return count
}

console.log(minOperations('10010100'))
// console.log(minOperations('1111'))
//                         1010101
