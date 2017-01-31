package string.matching;

/**
 * �ַ�������ƥ���㷨��<br>
 * ��Ŀ�괮String�ĳ���Ϊm��Pattern�ĳ���Ϊn��BF�㷨��ʱ�临�Ӷ��ΪO(mn)��
 * 
 * @author JavaSking 2017��1��11��
 */
public class BruteForce {

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
