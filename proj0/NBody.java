public class NBody{
	public static double readRadius(String fileName){
		/** read Radius */
		In in = new In(fileName);
		int N = in.readInt();
		double R = in.readDouble();
		return R;
	}

	public static Body[] readBodies(String fileName){
		/** read bodies from file */
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
		/** read everything from file */
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double canvasR = NBody.readRadius(filename);
		Body[] bodies = NBody.readBodies(filename);
		String background = "images/starfield.jpg";

		/** Enables double buffering.
		  * A animation technique where all drawing takes place on the offscreen canvas.
		  * Only when you call show() does your drawing get copied from the
		  * offscreen canvas to the onscreen canvas, where it is displayed
		  * in the standard drawing window. */
		StdDraw.enableDoubleBuffering();

		StdDraw.setScale(-canvasR, canvasR);
		StdDraw.picture(0, 0, background);
		StdDraw.show();


	}
}