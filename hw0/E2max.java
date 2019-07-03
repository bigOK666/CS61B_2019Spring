public class E2max {
	/** Returns the max value from a list m*/
	public static int max(int[] m){
		int i = 0;
		int max_value = m[0];
		while (i < m.length){
			if (max_value < m[i]){
				max_value = m[i];
			}
			i++;
		}
		return max_value;
	}
	public static void main(String[] args) {
		int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.print(max(numbers));
	}
}