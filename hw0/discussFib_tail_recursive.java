public class discussFib_tail_recursive {
	public static int fib(int n, int k, int f0, int f1){
		/** get the n^th Fibonacci number
		* @param n: the n^th Fib number
		* @param k: f0 is the k^th Fib number, namely 1st Fib number
		* @param f0: 1st Fib number
		* @param f1: 2nd Fib number */
		if (n == k){
			return f0;
		}else {
			return fib(n, k+1, f1, f0 + f1);
		}


}
	public static void main(String[] args) {
		System.out.print(fib(9, 1, 0, 1));	
	}
}