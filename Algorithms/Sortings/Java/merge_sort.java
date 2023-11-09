import java.util.Arrays;
import java.util.Comparator;

public class Sample1 {
	public static void mergeSortIterative(int[] array) {
		int[] supportArray = Arrays.copyOf(array, array.length);
		int n = array.length;
		for(int size = 1; size < n; size *= 2) {
			for(int j = 0; j < n - size; j += size * 2) {
				merge(array, supportArray, j, j+size-1; j+size, Math.min(j+2*size-1, n-1));
			}
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] {0, 5, -2, 7, 3};
		mergeSort(array);
		System.out.println(Arrays.toString(array));
	}

	public static void mergeSort(int[] array) {
		int[] support = Arrays.copyOf(array, array.length);
		int startIndex = 0;
		int endIndex = support.length - 1;
		mergeSort(array, support, startIndex, endIndex)
	}

	public static void mergeSort(int[] array, int[] support, int ls, int le, int rs, int re) {
		if(startIndex >= endIndex) {
			return;
		}
		int h = startIndex + (endIndex - startIndex) / 2;
		mergeSort(array, support, startIndex, h);
		mergeSort(array, support, h + 1, endIndex);
		merge(array, support, startIndex, h, h + 1, endIndex);
	}

	public static void merge(int[] array, int[] supportArray, int ls, int le, int rs, int re) {
		for(int i = ls; i <= re; i++) {
			supportArray[i] = array[i];
		}

		int l = ls;
		int r = rs;

		for(int i = ls; i <= re; i++) {
			if(l > le) {
				array[i] = supportArray[r];
				r += 1;
			} else if(r > re) {
				array[i] = supportArray[l];
				l += 1;
			} else if(supportArray[l] < supportArray[r]) {
				array[i] = supportArray[l];
				l += 1;
			} else {
				array[i] = supportArray[r];
				r += 1;
			}
		}
	}
}



public class Sample2 {

	public static void main(String[] args) {
		String[] array = new String[] { "Python", "Ada", "Java", "C", "Fortran" };
		Comparator<String> comp = (a, b) -> a.length() - b.length();
		mergeSort(array, comp);
		System.out.println(Arrays.toString(array));

	}

	public static <T> void mergeSort(T[] array, Comparator<T> comp) {
		T[] support = Arrays.copyOf(array, array.length);
		int startIndex = 0;
		int endIndex = support.length - 1;
		mergeSort(array, support, comp, startIndex, endIndex);
	}

	public static <T> void mergeSort(T[] array, T[] support, Comparator<T> comp, int startIndex, int endIndex) {
		if (startIndex >= endIndex) {
			return;
		}
		int h = startIndex + (endIndex - startIndex) / 2;
		mergeSort(array, support, comp, startIndex, h);
		mergeSort(array, support, comp, h + 1, endIndex);
		merge(array, support, comp, startIndex, h, h + 1, endIndex);
	}

	public static <T> void merge(T[] array, T[] support, Comparator<T> comp, int ls, int le, int rs, int re) {
		for (int i = ls; i <= re; i++) {
			support[i] = array[i];
		}
		int l = ls;
		int r = rs;
		for (int i = ls; i <= re; i++) {
			if (l > le) {
				array[i] = support[r];
				r += 1;
			} else if (r > re) {
				array[i] = support[l];
				l += 1;
			} else if (comp.compare(support[l], support[r]) < 0) {
				array[i] = support[l];
				l += 1;
			} else {
				array[i] = support[r];
				r += 1;
			}
		}
	}

}