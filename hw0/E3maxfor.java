public class E3maxfor {
	/** Returns the max value from a list m*/
	public static int max(int[] m){
		
		int max_value = m[0];
		for (int i = 0; i < m.length; i++){
			if (max_value < m[i]){
				max_value = m[i];
			}
		}
		return max_value;
	}
	public static void main(String[] args) {
		int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.print(max(numbers));
	}
}