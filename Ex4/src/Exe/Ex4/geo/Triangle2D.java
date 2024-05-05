package Exe.Ex4.geo;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle2D implements GeoShapeable{
	
	private Point2D p1;
	private Point2D p2;
	private Point2D p3;
	
	//constactor for triangle
	public Triangle2D(Point2D p1, Point2D p2, Point2D p3) {
		this.p1 = new Point2D(p1);
		this.p2 = new Point2D(p2);
		this.p3=  new Point2D(p3);
	}

	@Override
    public String toString()
    { return p1.toString()+", "+p2.toString()+", "+p3.toString();}

	@Override
	public boolean contains(Point2D ot) {
		// TODO Auto-generated method stub
		//we will check the 3 areas that the point has with every edge
		double area1 = getArea(ot,p1,p2);
		double area2 = getArea(ot,p2,p3);
		double area3 = getArea(ot,p1,p3);
		//checking the big triangle area
		double area4 = getArea(p1,p2,p3);
		//if the sum of the 3 areas is equal to the big triangle area its mean the point is in the triangle
		if((area1+area2+area3)==area4)
		return true;
		return false;
	}
	//returning the area of triangle by given 3 points
	public static double getArea(Point2D p1,Point2D p2,Point2D p3)
	{
		double s= 0.5*(p1.x()*(p3.y()-p2.y())+p2.x()*(p1.y()-p3.y())+p3.x()*(p2.y()-p1.y()));
		return Math.abs(s);
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		//Formula for calculating the area of ​​a triangle by 3 points
		double s= 0.5*(p1.x()*(p3.y()-p2.y())+p2.x()*(p1.y()-p3.y())+p3.x()*(p2.y()-p1.y()));
		return Math.abs(s);
	}

	@Override
	//sum up the edges values
	public double perimeter() {
		// TODO Auto-generated method stub
		double zela1=Math.sqrt((Math.pow((p1.x()-p2.x()), 2))+(Math.pow((p1.y()-p2.y()), 2)));//p1,p2
		double zela2=Math.sqrt((Math.pow((p2.x()-p3.x()), 2))+(Math.pow((p2.y()-p3.y()), 2)));//p2,p3
		double zela3=Math.sqrt((Math.pow((p1.x()-p3.x()), 2))+(Math.pow((p1.y()-p3.y()), 2)));//p1,p3
				
		return zela1+zela2+zela3;
	}

	@Override
	public void move(Point2D vec) {
		// TODO Auto-generated method stub
		p1.move(vec);
		p2.move(vec);
		p3.move(vec);
		
	}

	@Override
	public GeoShapeable copy() {
		// TODO Auto-generated method stub
		return new Triangle2D(p1, p2,p3);
	}

	@Override
	public void scale(Point2D center, double ratio) {
		// TODO Auto-generated method stub
		this.p1.scale(center,  ratio);
		this.p2.scale(center,  ratio);
		this.p3.scale(center,  ratio);
		
		
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		// TODO Auto-generated method stub
		this.p1.rotate(center,  angleDegrees);
		this.p2.rotate(center,  angleDegrees);
		this.p3.rotate(center,  angleDegrees);
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] p = new Point2D [3];
		p[0]= new Point2D (p1);
		p[1]= new Point2D (p2);
		p[2]= new Point2D (p3);
		return p;
	}
	
	
	
}