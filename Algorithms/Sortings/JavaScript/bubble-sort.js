function bubbleSort(array) {
  for (let i = 0; i < array.length; i++) {
    for (let j = 0; j < array.length; j++) {
      if (array[j] > array[j + 1]) {
        let temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
      }
    }
  }
  return array;
}

console.log(
  bubbleSort([
    120, 28, 23, 24, 48, 454, 1, 402, 31, 44, 50, 420, 3, 15, 14, 16, 35, 27,
    111, 30, 11, 6, 230, 37, 50, 8, 26, 505, 1588, 2298,
  ])
);
