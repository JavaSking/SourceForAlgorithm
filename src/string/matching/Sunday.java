package string.matching;

import java.util.HashMap;
import java.util.Map;

public class Sunday {

	private static int currentPos = 0;

	// ƥ���ַ���Map,��¼��ƥ���ַ�������Щchar����ÿ��char�����ֵ�λ��
	private static Map<Character, Integer> map = new HashMap<Character, Integer>();

	// Sundayƥ��ʱ�������洢Pattern��ÿ���ַ����һ�γ��ֵ�λ�ã����ҵ����˳��
	public static void initMap(String pattern) {

		for (int i = 0, plen = pattern.length(); i < plen; i++) {
			map.put(pattern.charAt(i), i);
		}
	}

	/**
	 * Sundayƥ�䣬�ٶ�Text�е�K�ַ���λ��Ϊ����ǰƫ����+Pattern�ַ�������+
	 *
	 * @param source
	 *          Ŀ���ַ���
	 * @param pattern
	 *          ָ���ַ���
	 * @return ָ���ַ�����Ŀ���ַ����е�λ��
	 */
	public static int match(String source, String pattern) {

		int slen = source.length();
		int plen = pattern.length();

		// ��ʣ�µ�ԭ��С��ָ���ַ���ʱ��ƥ�䲻�ɹ�
		if ((slen - currentPos) < plen) {
			return -1;
		}

		// ���û��ƥ��ɹ�
		if (!isMatchFromPos(source, pattern, currentPos)) {
			int nextStartPos = currentPos + plen;

			// ����ƶ�λ�������ǽ�β������û��ƥ�䵽
			if ((nextStartPos) == slen) {
				return -1;
			}

			// ���ƥ��ĺ�һ���ַ�û����Pattern�ַ����г��֣�����������Pattern�ַ�������
			if (!map.containsKey(source.charAt(nextStartPos))) {
				currentPos = nextStartPos;
			} else {
				// ���ƥ��ĺ�һ���ַ���Pattern�ַ����г��֣��򽫸�λ�ú�Pattern�ַ����е����ұ���ͬ�ַ���λ�ö���
				currentPos = nextStartPos - (Integer) map.get(source.charAt(nextStartPos));
			}

			return match(source, pattern);
		} else {
			return currentPos;
		}
	}

	/**
	 * ����Text��ָ��ƫ������ʼ���Ӵ��Ƿ��Patternƥ��
	 *
	 * @param source
	 *          Ŀ���ַ���
	 * @param pattern
	 *          ָ���ַ���
	 * @param pos
	 *          ��ʼλ��
	 * @return �Ƿ�ƥ��
	 */
	private static boolean isMatchFromPos(String source, String pattern, int pos) {

		for (int i = 0, plen = pattern.length(); i < plen; i++) {
			if (source.charAt(pos + i) != pattern.charAt(i)) {
				return false;
			}
		}

		return true;
	}
}
