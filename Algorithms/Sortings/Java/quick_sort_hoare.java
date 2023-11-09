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
		if(lo_index >= hi_index) return;
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
}