package string.matching;

/**
 * 字符串暴力匹配算法。<br>
 * 设目标串String的长度为m，Pattern的长度为n，BF算法的时间复杂度最坏为O(mn)。
 * 
 * @author JavaSking 2017年1月11日
 */
public class BruteForce {

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

		int index = -1;
		boolean match = true;
		for (int i = 0, len = source.length() - pattern.length(); i <= len; i++) {
			match = true;
			for (int j = 0; j < pattern.length(); j++) {
				if (source.charAt(i + j) != pattern.charAt(j)) {
					match = false;
					break;
				}
			}
			if (match) {
				index = i;
				break;
			}
		}
		return index;
	}
}
