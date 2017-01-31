package string.matching;

public class BoyerMoore {

	/**
	 * ���㻬������
	 *
	 * @param c
	 *          ������Դ�����е��ַ�
	 * @param T
	 *          ģʽ����Ŀ�괮���ַ�����
	 * @param noMatchPos
	 *          �ϴβ�ƥ���λ��
	 * @return ��������
	 */
	private static int dist(char c, char T[], int noMatchPos) {

		int n = T.length;

		for (int i = noMatchPos; i >= 1; i--) {
			if (T[i - 1] == c) {
				return n - i;
			}
		}

		// c��������ģʽ��ʱ
		return n;
	}

	/**
	 * �ҳ�ָ���ַ�����Ŀ���ַ����е�λ��
	 *
	 * @param source
	 *          Ŀ���ַ���
	 * @param pattern
	 *          ָ���ַ���
	 * @return ָ���ַ�����Ŀ���ַ����е�λ��
	 */
	public static int match(String source, String pattern) {

		char[] s = source.toCharArray();
		char[] t = pattern.toCharArray();
		int slen = s.length;
		int tlen = t.length;

		if (slen < tlen) {
			return -1;
		}

		int i = tlen;
		int j = -1;

		while (i <= slen) {
			j = tlen;
			// S[i-1]��T[j-1]��ƥ�䣬�������һ��Ƚϣ���֮�뿪ѭ����
			while (j > 0 && s[i - 1] == t[j - 1]) {
				i--;
				j--;
			}

			// j=0ʱ����ʾ����ƥ�䣬�����俪ʼƥ���λ��
			if (0 == j) {
				return i;
			} else {
				// ��������ģʽ�������һ���һ�ξ���dist(s[i-1]).
				i = i + dist(s[i - 1], t, j - 1);
			}
		}

		// ģʽ���������޷�ƥ��
		return -1;
	}
}
