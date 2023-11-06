package com.gmail.tsa;
import java.util.Arrays;

public class Main {
	public static void main(String[]) {
		int[] array = new int[] {5, 0, -2, 7, 3};
		int sortedIndex = array.length - 1;
		int numberOfSwap = 1;

		while(numberOfSwap > 0) {
			numberOfSwap = 0
			for(int i = 0; i < sortedIndex; i++) {
				if(array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					numberOfSwap += 1;
				}
			}
			sortedIndex -= 1;
		}

		System.out.println(Arrays.toString(array));
	}
}

void bubbleSort(int[] arr) {
	int length = arr.length;
	while(length != 0) {
		int max_index = 0;
		for(int i = 1; i < length; i++) {
			if(arr[i - 1] > arr[i]) {
				int temp = arr[i - 1];
				arr[i - 1] = arr[i];
				arr[i] = temp;

				max_index = i;
			}
		}
		length = max_index;
	}
}