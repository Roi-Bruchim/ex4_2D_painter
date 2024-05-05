package Exe.Ex4.geo;

import java.util.ArrayList;

/**
 * This class represents a 2D polygon, as in https://en.wikipedia.org/wiki/Polygon
 * This polygon can be assumed to be simple in terms of area and contains.
 * 
 * You should update this class!
 * @author boaz.benmoshe
 *
 */
public class Polygon2D implements GeoShapeable{
	
	private ArrayList<Point2D> points;
	final double EPS=0.0001;
	
	//constactor for Poligon
	public Polygon2D(ArrayList <Point2D> p) {
		this.points=p;
	}

	// This constructor is used to help us draw the polygon
	public Polygon2D(ArrayList <Point2D> p, Point2D currPoint) {
		this.points = new ArrayList<>();
		this.points.addAll(p);
		this.points.add(currPoint);
	}

	@Override
	public boolean contains(Point2D ot) {
		// TODO Auto-generated method stub
		int sum=0;
		//creating a segment that is parallel to x line at y value (from ot point)
		Point2D p1 =new Point2D (EPS,ot.y());
		Point2D p2 =new Point2D (ot.x(),ot.y());
		Segment2D ourRay= new Segment2D(p1,p2);
		//converting the polygon into segments 
		
		for(int i=0;i<this.points.size()-1;i++)
		{

			Segment2D segI = new Segment2D (points.get(i),points.get(i+1));
			//and check if the segment is cutting with ourRay (with helping function below that check if both segments are collide
			boolean ans= isCut(ourRay,segI);
			// we will sum the number of times the ray collided with the current segment
			if (ans==true) {sum++;}
		}
		
		//checking the last segment in the polygon that wasn't in the for loop
		Segment2D segLast = new Segment2D (points.get(points.size()-1),points.get(0));
		boolean ans2= isCut(ourRay,segLast);
		if (ans2==true) {sum++;}
		
		//if the number of cutting is even its mean the point is not contained in our polygon
		if(sum%2==0)
		return false;
		//if the number of cutting is odd its mean the point is contained in our polygon
		else
		return true;
	}
	
	
	
	//helping function that will help us check if 2 lines cutting each other
	public static boolean isCut(Segment2D s1, Segment2D s2)
	{
		//finding the the equation of the segment1 (y=mx+n)
		double m1 = (s1.getPoints()[0].y()-s1.getPoints()[1].y())/(s1.getPoints()[0].x()-s1.getPoints()[1].x());
	    double n1= s1.getPoints()[1].y()-m1*s1.getPoints()[1].x();
	  //finding the the equation of the segment2 (y=mx+n)
	    double m2 = (s2.getPoints()[0].y()-s2.getPoints()[1].y())/(s2.getPoints()[0].x()-s2.getPoints()[1].x());
	    double n2= s2.getPoints()[1].y()-m2*s2.getPoints()[1].x();
	    
	    //check if the lines are parallel
	    if (m1 == m2) {
	        return false;
	    }
	    
	 //find the intersection point
	    double x = (n1 - n2) / (m2 - m1);
	    double y = m1 * x + n1;
	    
	    //check if the intersection point is outside the bounds of both segments
	    double minX1 = Math.min(s1.getPoints()[0].x(), s1.getPoints()[1].x());
	    double maxX1 = Math.max(s1.getPoints()[0].x(), s1.getPoints()[1].x());
	    double minY1 = Math.min(s1.getPoints()[0].y(), s1.getPoints()[1].y());
	    double maxY1 = Math.max(s1.getPoints()[0].y(), s1.getPoints()[1].y());
	    if (x < minX1 || x > maxX1 || y < minY1 || y > maxY1)
	    {
	        return false;
	    }
	    double minX2 = Math.min(s2.getPoints()[0].x(), s2.getPoints()[1].x());
	    double maxX2 = Math.max(s2.getPoints()[0].x(), s2.getPoints()[1].x());
	    double minY2 = Math.min(s2.getPoints()[0].y(), s2.getPoints()[1].y());
	    double maxY2 = Math.max(s2.getPoints()[0].y(), s2.getPoints()[1].y());
	    if (x < minX2 || x > maxX2 || y < minY2 || y > maxY2) 
	    {
	        return false;
	    }
	    //if the intersection point is in the bounds of both segments, then the segments intersect
	    return true;
	}
    
	
	

	@Override
	public double area() {
		//implements Shoelace theorem (helping source : chatGPT)
	    double area = 0;
	    int n = points.size();
	    for (int i = 0; i < n - 1; i++) {
	        Point2D p1 = points.get(i);
	        Point2D p2 = points.get(i + 1);
	        area += p1.x() * p2.y() - p1.y() * p2.x();
	    }
	    Point2D p1 = points.get(n - 1);
	    Point2D p2 = points.get(0);
	    area += p1.x() * p2.y() - p1.y() * p2.x();
	    return Math.abs(area / 2);
	}

	@Override
	public String toString() {
		String ans = "";
		for (int i = 0; i < points.size(); i++) {
			ans += points.get(i).toString();
			if (i != points.size() - 1)
				ans += ",";
		}
		return ans;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		double ans=0;
		for(int i=0;i<this.points.size()-1;i++)
		{
			//summing all the edges of the polygon until the last one (to not get out of range of the list)
			double zela= Math.sqrt((Math.pow((points.get(i).x()-points.get(i+1).x()), 2))+(Math.pow((points.get(i).y()-points.get(i+1).y()), 2)));
			ans=ans+zela;
		}
		//summing the last edge
		double lastzela= Math.sqrt((Math.pow((points.get(points.size()-1).x()-points.get(0).x()), 2))+(Math.pow((points.get(points.size()-1).y()-points.get(0).y()), 2)));
		ans=ans+lastzela;
		return ans;
	}

	@Override
	public void move(Point2D vec) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.points.size();i++)
		{
			points.get(i).move(vec);
		}
		
	}

	@Override
	public GeoShapeable copy() {
		// TODO Auto-generated method stub
		ArrayList <Point2D> p = new ArrayList <Point2D>();
		for(int i=0;i<this.points.size();i++)
		{
			p.add(points.get(i));
		}
		return new Polygon2D (p);
	}

	@Override
	public void scale(Point2D center, double ratio) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.points.size();i++)
		{
			points.get(i).scale(center,  ratio);
		}
		
	}

	@Override
	public void rotate(Point2D center, double angleDegrees) {
		// TODO Auto-generated method stub
		for(int i=0;i<this.points.size();i++)
		{
			points.get(i).rotate(center,  angleDegrees);
		}
		
	}

	@Override
	public Point2D[] getPoints() {
		
		Point2D[] p = new Point2D [points.size()];
		for(int i=0;i<points.size();i++)
			p[i]=points.get(i);
		// TODO Auto-generated method stub
		return p;
	}

	
}