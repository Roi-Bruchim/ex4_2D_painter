package geoShapesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Segment2D;

class Circle2DTest {

	@Test
	void areaTest() {
		Point2D p1= new Point2D(5,2);
		double rad=3.5;
		Circle2D c= new Circle2D(p1,rad);
		assertEquals(Math.pow(3.5, 2)*Math.PI,c.area());
	}
	
	@Test
	void perimeterTest()
	{
		Point2D p1= new Point2D(5,2);
		double rad=3.5;
		Circle2D c= new Circle2D(p1,rad);
		assertEquals(7*Math.PI,c.perimeter());
	}
	
	@Test
	void containsTest()
	{
		Point2D p1= new Point2D(0,0);
		double rad=1;
		Circle2D c= new Circle2D(p1,rad);
		Point2D pCheck= new Point2D(0.333,-0.2);
		if(!c.contains(pCheck))
			fail();
		pCheck= new Point2D(3.333,8.5);
		if(c.contains(pCheck))
			fail();
	}
	
	@Test
	void moveTest()
	{
		Point2D p1= new Point2D(0,0);
		double rad=1;
		Circle2D c= new Circle2D(p1,rad);
		Point2D pCheck= new Point2D(1,1);
		c.move(pCheck);
		Point2D p2 = new Point2D(1,1);
		assertEquals(p2,c.getCenter());
		p2 = new Point2D(2,1.1);
		assertNotEquals(p2,c.getCenter());
		assertEquals(1,c.getRadius());
		
	}
	
	@Test
	void copyTest()
	{
		Point2D p1= new Point2D(5,2);
		double rad=3.5;
		Circle2D c= new Circle2D(p1,rad);
		GeoShapeable cc= c.copy();
		assertEquals(c.toString(),cc.toString());
		assertEquals(c.area(),cc.area());
		assertEquals(true,cc instanceof Circle2D );
		assertEquals(false,cc instanceof Segment2D );
	}
	
	@Test
	void scaleTest()
	{
		Point2D p1= new Point2D(0,0);
		double rad=1;
		Circle2D c= new Circle2D(p1,rad);
		c.scale(p1, 2);
		assertEquals(p1,c.getCenter());
		assertEquals(c.getRadius(),Math.sqrt(2));
		Point2D p2= new Point2D(1,1);
		Point2D p3= new Point2D(2,2);
		assertEquals(c.contains(p2),true);
		assertEquals(c.contains(p3),false);
	}
	
	@Test
	void rotateTest()
	{
		Point2D p1= new Point2D(0,0);
		double rad=1;
		Circle2D c= new Circle2D(p1,rad);
		c.rotate(p1, 289);
		assertEquals(p1,c.getPoints()[0]);
		
	}
	
	

}