import java.util.Arrays;

public class Lomuto {
	public static void main(String[] args) {
		int[] array = new int[] {0, 5, -2, 7, 3};
		qiuckSort(array);
		System.out.println(array);
	}

	public static void qiuckSort(int[] array) {
		qiuckSort(array, 0, array.length - 1);
	}

	public static void qiuckSort(int[] secuence, int lo_index, int hi_index) {
		if(lo_index >= hi_index) return;

		int pivot = partition(secuence, lo_index, hi_index);
		qiuckSort(secuence, lo_index, pivot - 1);
		qiuckSort(secuence, pivot + 1, hi_index);
	}

	public static int partition(int[] secuence, int lo_index, int hi_index) {
		int support_element = secuence[lo_index];
		int j = lo_index;
		for(int i = lo_index + 1; i <= hi_index; i++) {
			if(secuence[i] < support_element) {
				j += 1;
				swap(secuence, i, j);
			}
		}
		swap(secuence, lo_index, j);
		return j;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}