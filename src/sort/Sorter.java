package sort;

/**
 * 排序器。<br>
 * 收集了各种排序算法及其比较。<br>
 * <ul>
 * <li>冒泡排序bubbleSort
 * <li>插入排序insertSort
 * <li>选择排序selectSort
 * <li>希尔排序shellSort
 * <li>快速排序quickSort
 * <li>桶排序RadixSort
 * <li>归并排序mergeSort
 * </ul>
 * 
 * @author JavaSking 2017年1月11日
 */
public class Sorter {

	/**
	 * 冒泡排序。
	 * 
	 * @param sources
	 *          待排序数组。
	 */
	public static <T extends Comparable<T>> void bubbleSort(T[] sources) {

		T temporary;
		int size = sources.length;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (sources[i].compareTo(sources[j]) < 0) {
					temporary = sources[i];
					sources[i] = sources[j];
					sources[j] = temporary;
				}
			}
		}
	}

	/**
	 * 插入排序。
	 * 
	 * @param sources
	 *          待排序数组。
	 */
	public static <T extends Comparable<T>> void insertSort(T[] sources) {

		int size = sources.length;
		T temporary;
		int j;
		for (int i = 1; i < size; i++) {
			temporary = sources[i];
			for (j = i; j > 0 && temporary.compareTo(sources[j - 1]) < 0; j--) {
				sources[j] = sources[j - 1];
			}
			sources[j] = temporary;
		}
	}

	/**
	 * 选择排序。
	 * 
	 * @param sources
	 *          待排序数组。
	 */
	public static <T extends Comparable<T>> void selectSort(T[] sources) {

		int size = sources.length;
		T temporary;
		for (int i = 0; i < size; i++) {
			int k = i;
			for (int j = size - 1; j > i; j--) {
				if (sources[j].compareTo(sources[k]) < 0)
					k = j;
			}
			temporary = sources[i];
			sources[i] = sources[k];
			sources[k] = temporary;
		}
	}

	/**
	 * 希尔排序。
	 * 
	 * @param sources
	 *          待排序数组。
	 */
	public static <T extends Comparable<T>> void shellSort(T[] sources) {

		int j = 0;
		T temporary;
		// 每次将步长缩短为原来的一半
		for (int increment = sources.length / 2; increment > 0; increment /= 2) {
			for (int i = increment; i < sources.length; i++) {
				temporary = sources[i];
				for (j = i; j >= increment; j -= increment) {
					if (temporary.compareTo(sources[j - increment]) > 0) {
						sources[j] = sources[j - increment];
					} else {
						break;
					}
				}
				sources[j] = temporary;
			}
		}
	}

	/**
	 * 快速排序。
	 * 
	 * @param sources
	 *          待排序数组。
	 */
	public static <T extends Comparable<T>> void quickSort(T[] sources, int start, int end) {

		if (start < end) {
			T base = sources[start];
			T temporary;
			int i = start, j = end;
			do {
				while ((sources[i].compareTo(base) < 0) && (i < end))
					i++;
				while ((sources[j].compareTo(base) > 0) && (j > start))
					j--;
				if (i <= j) {
					temporary = sources[i];
					sources[i] = sources[j];
					sources[j] = temporary;
					i++;
					j--;
				}
			} while (i <= j);
			if (start < j)
				quickSort(sources, start, j);
			if (end > i)
				quickSort(sources, i, end);
		}
	}

	/**
	 * 桶排序。
	 * 
	 * @param sources
	 *          待排序数组。
	 */
	public static <T extends Comparable<T>> void RadixSort(T[] sources) {

	}

}
