const arr = [4, -3, 3, 18, 2, 7, 55, 0];

for (let i = 1; i < arr.length; i++) {
  let cur = arr[i];
  let j = i - 1;

  while (j >= 0 && arr[j] > cur) {
    arr[j + 1] = arr[j];
    j--;
  }
  arr[j + 1] = cur;
}

console.log(arr);
