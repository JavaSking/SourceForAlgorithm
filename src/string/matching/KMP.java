package string.matching;

/**
 * KMP�ַ���ƥ���㷨��<br>
 * ��Ŀ�괮String�ĳ���Ϊm��Pattern�ĳ���Ϊn���㷨��ʱ�临�Ӷ�ΪO(n+m)��
 * 
 * @author JavaSking 2017��1��11��
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
	 * �ҳ�ָ���ַ�����Ŀ���ַ����е�λ�á�
	 * 
	 * @param source
	 *          Ŀ���ַ�����
	 * 
	 * @param pattern
	 *          ָ���ַ�����
	 * 
	 * @return ָ���ַ�����Ŀ���ַ����е�λ�á�
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
