public class drawTriangle {
	public static void main(String[] args) {
		drawTriangle(10);
		
	}
	public static void drawTriangle(int N){
		int i = 0;
		String star = "*";
		while(i < N) {
			System.out.print(star);
			System.out.print("\n");
			star = star + "*";
			i++;
		}
	}
}