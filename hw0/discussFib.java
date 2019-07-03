public class discussFib {
	public static int fib(int n){
		int sum = 0;
		int sum1 = 1;
		int sum2 = 0;
		if (n==1){
			return sum;
		}else if (n == 2){
			return sum1;
		}else{
			for(int i = 0; i < n-2; i++){
			sum2 = sum + sum1;
			sum = sum1;
			sum1 = sum2;
			}
			return sum2;
		}
		
	}
	public static void main(String[] args) {
		System.out.print(fib(9));	
	}
}