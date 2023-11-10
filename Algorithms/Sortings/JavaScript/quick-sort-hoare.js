function insertionSort(secuence, start, end) {
  for (let i = start + 1; i <= end; i++) {
    let cur = secuence[i];
    let j = i - 1;

    while (j >= 0 && secuence[j] > cur) {
      secuence[j + 1] = secuence[j];
      j--;
    }
    secuence[j + 1] = cur;
  }
}

function median(secuence, lo, mid, hi) {
  if (secuence[lo] <= secuence[mid]) {
    if (secuence[mid] <= secuence[hi]) {
      return mid;
    }
  } else {
    if (secuence[lo] <= secuence[hi]) {
      return lo;
    }
  }
  return hi;
}

function tukeyMedian(secuence, lo, hi) {
  const part = Math.floor(secuence.length / 3);
  const medianA = median(secuence, lo, Math.floor((lo + part) / 2), lo + part);
  const medianB = median(
    secuence,
    lo + part + 1,
    Math.floor((lo + part * 3 + 1) / 2),
    lo + part * 2
  );
  const medianC = median(
    secuence,
    Math.floor(lo + part * 2 + 1),
    Math.floor((lo + part * 5) / 2 + 1),
    hi
  );
  return median(secuence, medianA, medianB, medianC);
}

function quickSort(arr, start = 0, end = arr.length - 1) {
  if (end - start <= 32) {
    insertionSort(arr, start, end);
    return;
  }
  let mid = tukeyMedian(arr, start, Math.floor(start + (end - start) / 2), end);
  swap(arr, start, mid);
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
