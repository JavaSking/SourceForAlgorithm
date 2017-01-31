package sort;

/**
 * ��������<br>
 * �ռ��˸��������㷨����Ƚϡ�<br>
 * <ul>
 * <li>ð������bubbleSort
 * <li>��������insertSort
 * <li>ѡ������selectSort
 * <li>ϣ������shellSort
 * <li>��������quickSort
 * <li>Ͱ����RadixSort
 * <li>�鲢����mergeSort
 * </ul>
 * 
 * @author JavaSking 2017��1��11��
 */
public class Sorter {

	/**
	 * ð������
	 * 
	 * @param sources
	 *          ���������顣
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
	 * ��������
	 * 
	 * @param sources
	 *          ���������顣
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
	 * ѡ������
	 * 
	 * @param sources
	 *          ���������顣
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
	 * ϣ������
	 * 
	 * @param sources
	 *          ���������顣
	 */
	public static <T extends Comparable<T>> void shellSort(T[] sources) {

		int j = 0;
		T temporary;
		// ÿ�ν���������Ϊԭ����һ��
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
	 * ��������
	 * 
	 * @param sources
	 *          ���������顣
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
	 * Ͱ����
	 * 
	 * @param sources
	 *          ���������顣
	 */
	public static <T extends Comparable<T>> void RadixSort(T[] sources) {

	}

}
