function quickSort(arr, start = 0, end = arr.length - 1) {
  if (start >= end) return;
  const pivot = partition(arr, start, end);
  quickSort(arr, start, pivot - 1);
  quickSort(arr, pivot + 1, end);
}

function partition(arr, start, end) {
  const supportElement = arr[start];
  let i = start + 1;
  let j = end;

  while (true) {
    while (i < end && arr[i] < supportElement) {
      i += 1;
    }
    while (j > start && arr[j] > supportElement) {
      j -= 1;
    }
    if (i >= j) break;
    swap(arr, i++, j--);
  }
  swap(arr, start, j);
  return j;
}

function swap(array, i, j) {
  let temp = array[i];
  array[i] = array[j];
  array[j] = temp;
}

const array = [0, 5, -2, 7, 3, -2, -7, 66, 45];
quickSort(array);
console.log(array);
