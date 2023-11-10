function quickSort(secuence, start = 0, end = secuence.length - 1) {
  if (start >= end) return;
  const pivot = partition(secuence, start, end);
  quickSort(secuence, start, pivot - 1);
  quickSort(secuence, pivot + 1, end);
}

function partition(secuence, start, end) {
  const support = secuence[start];
  let j = start;
  for (let i = start + 1; i <= end; i++) {
    if (secuence[i] < support) {
      j++;
      swap(secuence, i, j);
    }
  }
  swap(secuence, start, j);
  return j;
}

function swap(arr, i, j) {
  let temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

const secuence = [0, 5, -2, 7, 3];
quickSort(secuence);
console.log(secuence);
