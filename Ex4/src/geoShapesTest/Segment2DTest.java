package geoShapesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Segment2D;

class Segment2DTest {
	
	
	
	@Test
	void ToStringTest()
	{
		Point2D p1= new Point2D(2,0);
		Point2D p2= new Point2D(4,2);
		Segment2D s= new Segment2D(p1,p2);
		assertEquals(s.toString(),"2.0,0.0, 4.0,2.0");
	}

	@Test
	void containsTest()
	{
		Point2D p1= new Point2D(2,0);
		Point2D p2= new Point2D(4,2);
		Segment2D s= new Segment2D(p1,p2);
		Point2D pCheck= new Point2D(3,1);
		assertEquals(s.contains(pCheck),true);
		pCheck= new Point2D(3.7,2);
		assertEquals(s.contains(pCheck),false);	
		
	}
	
	@Test
	void perimeterTest()
	{
		Point2D p1= new Point2D(1,1);
		Point2D p2= new Point2D(2,2);
		Segment2D s= new Segment2D(p1,p2);
		assertEquals(Math.sqrt(2)*2,s.perimeter());
		
		Point2D p3= new Point2D(7,-2.2);
		Point2D p4= new Point2D(3,-8);
		Segment2D ss= new Segment2D(p3,p4);
		assertEquals(14,(int)(ss.perimeter()));
		
	}
	
	
	@Test
	void copyTest()
	{
		Point2D p1= new Point2D(1,1);
		Point2D p2= new Point2D(2,2);
		Segment2D s= new Segment2D(p1,p2);
		GeoShapeable ss= s.copy();
		assertEquals(s.toString(),ss.toString());
		assertEquals(s.perimeter(),ss.perimeter());
		assertEquals(true,ss instanceof Segment2D );
		assertEquals(false,ss instanceof Circle2D );
		
	}
	
	
	@Test
	void moveTest()
	{
		Point2D p1= new Point2D(1,1);
		Point2D p2= new Point2D(2,2);
		Segment2D s= new Segment2D(p1,p2);
		Point2D pCheck= new Point2D(2.7,-2);
		s.move(pCheck);
		Point2D[] arr = s.getPoints();
		Point2D p3= new Point2D(3.7,-1);
		Point2D p4= new Point2D(4.7,0);
		assertEquals(p3,arr[0]);
		assertEquals(p4,arr[1]);
	}
	
	@Test
	void getPointsTest() 
	{
		Point2D p1= new Point2D(1,0);
		Point2D p2= new Point2D(-1,0);
		Segment2D t= new Segment2D (p1,p2);
		Point2D[] arr = t.getPoints();
		assertEquals(p1,arr[0]);
		assertEquals(p2,arr[1]);
	}
	
	@Test
	void scaleTest() {
		Point2D p1= new Point2D (2,0);
		Point2D p2= new Point2D (2,4);
		Segment2D s= new Segment2D (p1,p2);
	
		s.scale(new Point2D(2,2), 0.5);
		
		assertEquals(s.getPoints()[0], new Point2D(2,1));
		assertEquals(s.getPoints()[1], new Point2D(2,3));
	}
	
	@Test
	void rotateTest() {
		Point2D p1= new Point2D (2,0);
		Point2D p2= new Point2D (2,4);
		Segment2D s= new Segment2D (p1,p2);
		
		s.rotate(new Point2D(2,2), 90);
		assertEquals(s.getPoints()[0], new Point2D(4,1.9999999999999998));
		assertEquals(s.getPoints()[1], new Point2D(0,2));
	}
	

}