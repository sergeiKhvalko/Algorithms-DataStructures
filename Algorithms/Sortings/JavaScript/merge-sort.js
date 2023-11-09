function merge(array, support, ls, le, rs, re) {
  for (let i = ls; i <= re; i++) {
    support[i] = array[i];
  }

  let l = ls;
  let r = rs;

  for (let i = ls; i <= re; i++) {
    if (l > le) {
      array[i] = support[r];
      r += 1;
    } else if (r > re) {
      array[i] = support[l];
      l += 1;
    } else if (support[l] < support[r]) {
      array[i] = support[l];
      l += 1;
    } else {
      array[i] = support[r];
      r += 1;
    }
  }
}

function mergeSortRecursive(array, support, startIndex, endIndex) {
  if (startIndex >= endIndex) return;
  let mid = Math.floor(startIndex + (endIndex - startIndex) / 2);
  mergeSortRecursive(array, support, startIndex, mid);
  mergeSortRecursive(array, support, mid + 1, endIndex);
  merge(array, support, startIndex, mid, mid + 1, endIndex);
}

function mergeSort(array) {
  const support = new Array(array.length);
  let startIndex = 0;
  let endIndex = support.length - 1;
  mergeSortRecursive(array, support, startIndex, endIndex);
}

const array = [4, -3, 3, 18, 2, 7, 55, 0];
console.log(mergeSort(array));
console.log(array);
