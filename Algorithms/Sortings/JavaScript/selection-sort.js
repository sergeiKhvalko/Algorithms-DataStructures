const arr = [4, -3, 3, 18, 2, 7, 55, 0];

for (let i = 0; i < arr.length - 1; i++) {
  let min = i;
  for (let j = i + 1; j < arr.length; j++) {
    if (arr[min] > arr[j]) {
      min = j;
    }
  }
  if (min != i) {
    [arr[i], arr[min]] = [arr[min], arr[i]];
  }
}

console.log(arr);
