import java.util.Arrays;

public class insertionSort {
	public static void main(String[] args) {
		int[] array = new int[] {5, 0, -2, 7, 3};

		for(int i = 0; i < array.length; i++) {
			int cur = array[i];
			int j;

			for(j = i; j > 0; j--) {
				if(array[j - 1] <= cur) {
					break;
				}
				array[j] = array[j - 1];
			}
			array[j] = cur;
		}
		System.out.println(Arrays.toString(array));
	}
}
