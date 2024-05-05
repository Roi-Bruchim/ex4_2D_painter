package Exe.Ex4.geo;


/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShapeable{
	
	private Point2D p1;
	private Point2D p2;
	
	//constractor to segment
	public Segment2D(Point2D p1, Point2D p2) {
		this.p1 = new Point2D(p1);
		this.p2 = new Point2D(p2);
	}
	
	//getter to segment length
	public double getLength()
	{
		return Math.sqrt((Math.pow((p1.x()-p2.x()), 2))+(Math.pow((p1.y()-p2.y()), 2)));
	}
	
	
	 @Override
	    public String toString()
	    { return p1.toString()+", "+p2.toString();}

	@Override
	public boolean contains(Point2D ot) {
		if (ot.equals(p1) || ot.equals(p2)) return true;
		if (Math.abs(p1.distance(p2) - p1.distance(ot) - p2.distance(ot)) < 0.01) return true;
		if ( ot == null) return false;
		if (ot.x() < Math.min(p1.x(), p2.x()) || ot.x() > Math.max(p1.x(), p2.x())) return false;
		if (ot.y() < Math.min(p1.y(), p2.y()) || ot.y() > Math.max(p1.y(), p2.y())) return false;
		return false;
	}


	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return this.getLength()*2;
	}

	@Override
	public void move(Point2D vec) {
		// TODO Auto-generated method stub
		p1.move(vec);
		p2.move(vec);
		
	}

	@Override
	public GeoShapeable copy() {
		// TODO Auto-generated method stub
		return new Segment2D(p1, p2);
	}

	@Override
	public void scale(Point2D center, double ratio) {
		// TODO Auto-generated method stub
		this.p1.scale(center,  ratio);
		this.p2.scale(center,  ratio);
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		// TODO Auto-generated method stub
		this.p1.rotate(center,  angleDegrees);
		this.p2.rotate(center,  angleDegrees);
	}

	@Override
	public Point2D[] getPoints() {
		// TODO Auto-generated method stub
		Point2D[] p = new Point2D [2];
		p[0]= new Point2D (p1);
		p[1]= new Point2D (p2);
		
		return p;
	}
	
}