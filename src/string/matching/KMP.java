package string.matching;

/**
 * KMP字符串匹配算法。<br>
 * 设目标串String的长度为m，Pattern的长度为n，算法的时间复杂度为O(n+m)。
 * 
 * @author JavaSking 2017年1月11日
 */
public class KMP {

	private static int[] calculateNext(String str) {

		int i = -1;
		int j = 0;
		int length = str.length();
		int next[] = new int[length];
		next[0] = -1;
		while (j < length - 1) {
			if (i == -1 || str.charAt(i) == str.charAt(j)) {
				i++;
				j++;
				next[j] = i;
			} else {
				i = next[i];
			}
		}
		return next;
	}

	/**
	 * 找出指定字符串在目标字符串中的位置。
	 * 
	 * @param source
	 *          目标字符串。
	 * 
	 * @param pattern
	 *          指定字符串。
	 * 
	 * @return 指定字符串在目标字符串中的位置。
	 */
	public static int match(String source, String pattern) {

		int i = 0;
		int j = 0;
		int input_len = source.length();
		int kw_len = pattern.length();
		int[] next = calculateNext(pattern);
		while ((i < input_len) && (j < kw_len)) {
			if (j == -1 || source.charAt(i) == pattern.charAt(j)) {
				j++;
				i++;
			} else {
				j = next[j];
			}
		}
		if (j == kw_len) {
			return i - kw_len;
		} else {
			return -1;
		}
	}
}
