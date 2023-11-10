import java.util.Arrays;

public class Hoare {

	public static void main(String[] args) {
		int[] array = new int[] {11, 3, 2, 7, 4, 0};
		qiuckSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void qiuckSort(int[] array) {
		qiuckSort(array, 0, array.length - 1);
	}

	public static void qiuckSort(int[] array, int lo_index, int hi_index) {
		if(hi_index - lo_index <= 32) {
			insertionSort(array, lo_index, hi_index);
			return;
		}
		int med = median(array, lo_index, lo_index+(hi_index-lo_index)/2, hi_index);
		swap(array, lo_index, med);
		int pivot = partition(array, lo_index, hi_index);
		qiuckSort(array, lo_index, pivot - 1);
		qiuckSort(array, pivot + 1, hi_index);
	}

	public static int partition(int[] array, int lo_index, int hi_index) {
		int support_element = array[lo_index];
		int i = lo_index + 1;
		int j = hi_index;
		while(true) {
			while(i < hi_index && array[i] < support_element) {
				i += 1;
			}
			while(j > lo_index && array[j] > support_element) {
				j -= 1;
			}
			if(i >= j) break;
			swap(array, i++, j--);
		}
		swap(array, lo_index, j);
		return j;
	}

	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void insertionSort(int[] array, int start, int end) {
		for(int i = start + 1; i <= end; i++) {
			int cur = array[i];
			int j = i - 1;

			while(j >= 0 && array[j] > cur) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = cur;
		}
	}

	public static int median(int[] array, int lo, int mid, int hi) {
		if(array[lo] <= array[mid]) {
			if(array[mid] <= array[hi]) {
				return mid;
			}
		} else {
			if(array[lo] <= array[hi]) {
				return lo;
			}
		}
		return hi;
	}
}