public class TestBody{
	public static void main(String[] args) {
		Body a = new Body(3, 4, 3, 4, 1, "a.png");
		Body b = new Body(0, 0, 4, 3, 1, "b.png");

		if (a.calcForceExertedBy(b) == 6.67e-11/25){
			System.out.print("Passed!");
		}else {
			System.out.print("Not Passed!");
		}
	}
}