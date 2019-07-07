public class Body{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static double G = 6.67e-11;

	public Body(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;

	}

	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Body b){
		return Math.sqrt((Math.pow((b.xxPos - this.xxPos), 2) + Math.pow((b.yyPos - this.yyPos), 2)));
	}
	
	public double calcForceExertedBy(Body b){
		return G * this.mass * b.mass / Math.pow(this.calcDistance(b), 2);
	}

	public double calcForceExertedByX(Body b){
		return this.calcForceExertedBy(b) * (b.xxPos - this.xxPos)/this.calcDistance(b);
	}

	public double calcForceExertedByY(Body b){
		return this.calcForceExertedBy(b) * (b.yyPos - this.yyPos)/this.calcDistance(b);
	}

	public double calcNetForceExertedByX(Body[] allBodys){
		double netForceExertedByX = 0.0;
		for(Body b : allBodys){
			if(this.equals(b)){
				continue;
			}else {
				netForceExertedByX = netForceExertedByX + this.calcForceExertedByX(b);
			}
		}
		return netForceExertedByX;
	}

	public double calcNetForceExertedByY(Body[] allBodys){
		double netForceExertedByY = 0.0;
		for(Body b : allBodys){
			if(this.equals(b)){
				continue;
			}else {
				netForceExertedByY = netForceExertedByY + this.calcForceExertedByY(b);
			}
		}
		return netForceExertedByY;
	}

	public void update(double dt, double fX, double fY){
		this.xxVel = this.xxVel + dt * fX / this.mass;
		this.yyVel = this.yyVel + dt * fY / this.mass;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}

	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, imgFileName);
		StdDraw.show();
	}
}