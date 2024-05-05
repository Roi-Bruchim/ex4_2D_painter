package geoShapesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Triangle2D;

class Triangle2DTest {
	
	
	
	@Test
	void ToStringTest()
	{
		Point2D p1= new Point2D(2,0);
		Point2D p2= new Point2D(4,0);
		Point2D p3= new Point2D(3,2);
		Triangle2D t= new Triangle2D (p1,p2,p3);
		assertEquals(t.toString(),"2.0,0.0, 4.0,0.0, 3.0,2.0");
	}

	@Test
	void getAreaTest() {
		Point2D p1= new Point2D(2,0);
		Point2D p2= new Point2D(4,0);
		Point2D p3= new Point2D(3,2);
		double area = Exe.Ex4.geo.Triangle2D.getArea(p1,p2,p3);
		assertEquals(2,area);

	}
	@Test
	void containsTest()
	{
		
		Point2D p1= new Point2D(2,0);
		Point2D p2= new Point2D(4,0);
		Point2D p3= new Point2D(3,2);
		Triangle2D t= new Triangle2D (p1,p2,p3);
		Point2D pCheck= new Point2D(7,4);
		if(t.contains(pCheck))
			fail();
	     pCheck = new Point2D(3,1);
	     if(!t.contains(pCheck))
	    	 fail();
	}
	
	@Test
	void perimeterTest()
	{
		Point2D p1= new Point2D(1,0);
		Point2D p2= new Point2D(2,0);
		Point2D p3= new Point2D(2,1);
		Triangle2D t= new Triangle2D (p1,p2,p3);
		assertEquals(Math.sqrt(2)+1+1,t.perimeter());
		assertNotEquals(Math.sqrt(2)+2+1,t.perimeter());
	}
	
	@Test
	void copyTest()
	{
		Point2D p1= new Point2D(2,0);
		Point2D p2= new Point2D(4,0);
		Point2D p3= new Point2D(3,2);
		Triangle2D t= new Triangle2D (p1,p2,p3);
		GeoShapeable tt= t.copy();
		assertEquals(t.toString(),tt.toString());
		assertEquals(t.area(),tt.area());
		assertEquals(true,tt instanceof Triangle2D );
		assertEquals(false,tt instanceof Circle2D );
		
	}
	
	@Test
	void moveTest()
	{
		Point2D p1= new Point2D(1,0);
		Point2D p2= new Point2D(-1,0);
		Point2D p3= new Point2D(0,1);
		Triangle2D t= new Triangle2D (p1,p2,p3);
		Point2D pCheck= new Point2D(1,1);
		t.move(pCheck);
		Point2D p4= new Point2D(2,1);
		Point2D p5= new Point2D(0,1);
		Point2D p6= new Point2D(1,2);
		Point2D[] arr = t.getPoints();
		assertEquals(p4,arr[0]);
		assertEquals(p5,arr[1]);
		assertEquals(p6,arr[2]);
		
	}
	
	@Test
	void getPoints()
	{
		Point2D p1= new Point2D(1,0);
		Point2D p2= new Point2D(-1,0);
		Point2D p3= new Point2D(0,1);
		Triangle2D t= new Triangle2D (p1,p2,p3);
		Point2D[] arr = t.getPoints();
		assertEquals(p1,arr[0]);
		assertEquals(p2,arr[1]);
		assertEquals(p3,arr[2]);
		
		
	}
	
	
	@Test
	void scaleTest() {
		Point2D p1= new Point2D (2,0);
		Point2D p2= new Point2D (1,1);
		Point2D p3= new Point2D (0,0);
		Triangle2D t= new Triangle2D (p1,p2,p3);
		Point2D cntOfmass = new Point2D ((p1.x()+p2.x()+p3.x())/3,(p1.y()+p2.y()+p3.y())/3);
		t.scale(cntOfmass, 2);
		
		assertEquals(t.getPoints()[0], new Point2D(3,-0.3333333333333333));
		assertEquals(t.getPoints()[1], new Point2D(1,1.6666666666666667));
		assertEquals(t.getPoints()[2], new Point2D(-1, -0.3333333333333333));
	}
	
	@Test
	void rotateTest() {
		Point2D p1= new Point2D (2,0);
		Point2D p2= new Point2D (1,1);
		Point2D p3= new Point2D (0,0);
		Triangle2D t= new Triangle2D (p1,p2,p3);
		Point2D cntOfmass = new Point2D ((p1.x()+p2.x()+p3.x())/3,(p1.y()+p2.y()+p3.y())/3);
		
		t.rotate(cntOfmass, 90);
		assertEquals(t.getPoints()[0], new Point2D(1.3333333333333333,1.3333333333333333));
		assertEquals(t.getPoints()[1], new Point2D(0.33333333333333326,0.33333333333333337));
		assertEquals(t.getPoints()[2], new Point2D(1.3333333333333333,-0.6666666666666667));
	}
	
	
			
	

}