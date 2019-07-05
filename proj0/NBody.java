public class NBody{
	public static double readRadius(String fileName){
		In in = new In(fileName);
		int N = in.readInt();
		double R = in.readDouble();
		return R;
	}

	public static Body[] readBodies(String fileName){
		In in = new In(fileName);
		int N = in.readInt();
		double R = in.readDouble();
		double xP;
		double yP;
		double xV;
		double yV;
		double mass;
		String image;
		Body[] bodies= new Body[N];
		for(int i = 0; i < N; i++){
			xP = in.readDouble();
			yP = in.readDouble();
			xV = in.readDouble();
			yV = in.readDouble();
			mass = in.readDouble();
			image = in.readString();
			bodies[i] = new Body(xP, yP, xV, yV, mass, image);
		}
		return bodies;
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(System.in.read());
		double dt = Double.parseDouble(System.in.read());
		String filename = System.in.read();
	}
}