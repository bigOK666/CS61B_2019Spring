public class discussFib5line {
	public static int fib(int n){
		if (n <= 2){
			return n-1;
		}else {
			return fib(n-1) + fib(n-2);
		}


}
	public static void main(String[] args) {
		System.out.print(fib(9));	
	}
}