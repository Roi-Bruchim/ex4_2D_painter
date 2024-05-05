package Exe.Ex4.geo;

/**
 * This class represents a 2D rectangle (NOT necessarily axis parallel - this shape can be rotated!)
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShapeable {
	private Point2D p1;
	private Point2D p2;
	private Point2D p3;
	private Point2D p4;
	//constactors for rect
	public Rect2D(Point2D p1, Point2D p2, Point2D p3, Point2D p4) {
		this.p1 = new Point2D(p1);
		this.p2 = new Point2D(p2);
		this.p3=  new Point2D(p3);
		this.p4=  new Point2D(p4);	
	}
	
	public Rect2D(Point2D p1, Point2D p2) {
		this.p1 = p1;
		this.p2 = new Point2D(p1.x(), p2.y());
		this.p3 = p2;
		this.p4 = new Point2D(p2.x(), p1.y());
	}

	 @Override
	    public String toString()
	    { return p1.toString()+", "+p2.toString()+", " +p3.toString()+", "+p4.toString();}

     //Checking if the value of the point is between rect values limits
	@Override
	public boolean contains(Point2D ot) {
		
		// TODO Auto-generated method stub
		double minX=Math.min(p1.x(),p3.x());
		double maxX=Math.max(p1.x(),p3.x());
		double minY=Math.min(p1.y(),p3.y());
		double maxY=Math.max(p1.y(),p3.y());
		double xPoint = ot.x();
		double yPoint = ot.y();
		if((xPoint>minX)&&(xPoint<maxX)&&(yPoint>minY)&&(yPoint<maxY))
		return true;
		return false;
	}
	
	public double getDistance(Point2D p1, Point2D p2)
	{
		return Math.sqrt((Math.pow((p1.x()-p2.x()), 2))+(Math.pow((p1.y()-p2.y()), 2)));
	}
	
	//getter 4 points 
	public Point2D[] points4()
	{
		Point2D[] p = new Point2D [4];
		p[0]=p1;
		p[1]=p2;
		p[2]=p3;
		p[3]=p4;
		return p;
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		double distnance1 = getDistance(this.p1,this.p2);
		double distnance2 = getDistance(this.p1,this.p3);
		double distnance3 = getDistance(this.p1,this.p4);
		double maxDis =Math.max(distnance1, Math.max(distnance2, distnance3));
		double minDis =Math.min(distnance1, Math.min(distnance2, distnance3));
		double midDis= distnance3+distnance2+distnance1-minDis-maxDis;
		
		return midDis*minDis;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		double distnance1 = getDistance(this.p1,this.p2);
		double distnance2 = getDistance(this.p1,this.p3);
		double distnance3 = getDistance(this.p1,this.p4);
		double maxDis =Math.max(distnance1, Math.max(distnance2, distnance3));
		double minDis =Math.min(distnance1, Math.min(distnance2, distnance3));
		double midDis= distnance3+distnance2+distnance1-minDis-maxDis;
		
		return midDis+midDis+minDis+minDis;
	}

	@Override
	public void move(Point2D vec) {
		// TODO Auto-generated method stub
		p1.move(vec);
		p2.move(vec);
		p3.move(vec);
		p4.move(vec);
		
	}

	@Override
	public GeoShapeable copy() {
		// TODO Auto-generated method stub
		return new Rect2D(p1, p2, p3, p4);
	}

	@Override
	public void scale(Point2D center, double ratio) {
		// TODO Auto-generated method stub
		this.p1.scale(center,  ratio);
		this.p2.scale(center,  ratio);
		this.p3.scale(center,  ratio);
		this.p4.scale(center,  ratio);
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		// TODO Auto-generated method stub
		this.p1.rotate(center,  angleDegrees);
		this.p2.rotate(center,  angleDegrees);
		this.p3.rotate(center,  angleDegrees);
		this.p4.rotate(center,  angleDegrees);
	}

	@Override
	public Point2D[] getPoints() {
		// TODO Auto-generated method stub
		
		Point2D[] p = new Point2D [2];
		p[0] = this.p1;
		p[1] = this.p3;
		return p;
	}

}