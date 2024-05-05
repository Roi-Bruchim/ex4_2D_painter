package geoShapesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Rect2D;

class Rect2DTest {
	
	
	@Test
	void ToStringTest()
	{
		Point2D p1= new Point2D (2,0);
		Point2D p2= new Point2D (2,3);
		Point2D p3= new Point2D (4,0);
		Point2D p4= new Point2D (4,3);
		Rect2D r= new Rect2D (p1,p2,p3,p4);
		assertEquals(r.toString(),"2.0,0.0, 2.0,3.0, 4.0,0.0, 4.0,3.0");
	}
	

	@Test
	void areaTest()
	{
		Point2D p1= new Point2D (2,0);
		Point2D p2= new Point2D (2,3);
		Point2D p3= new Point2D (4,0);
		Point2D p4= new Point2D (4,3);
		Rect2D r= new Rect2D (p1,p2,p3,p4);
		assertEquals((int)(r.area()),6);
		p1= new Point2D (0,2);
		p2= new Point2D (4,2);
		p3= new Point2D (2,0);
		p4= new Point2D (2,4);
		r= new Rect2D (p1,p2,p3,p4);
		assertEquals((int)(r.area()),8);
	}

	@Test
	void perimeterTest()
	{
		Point2D p1= new Point2D (2,0);
		Point2D p2= new Point2D (2,3);
		Point2D p3= new Point2D (4,0);
		Point2D p4= new Point2D (4,3);
		Rect2D r= new Rect2D (p1,p2,p3,p4);
		assertEquals(10,r.perimeter());
		p1= new Point2D (0,2);
		p2= new Point2D (4,2);
		p3= new Point2D (2,0);
		p4= new Point2D (2,4);
		r= new Rect2D (p1,p2,p3,p4);
		assertEquals(r.perimeter(),Math.sqrt(8)*4,0.001);
	}


		@Test
		void moveTest()
		{
			Point2D p1= new Point2D (2,0);
			Point2D p2= new Point2D (2,3);
			Point2D p3= new Point2D (4,0);
			Point2D p4= new Point2D (4,3);
			Rect2D r= new Rect2D (p1,p2,p3,p4);
			Point2D pCheck= new Point2D(-2,3);
			r.move(pCheck);
			Point2D p5= new Point2D (0,3);
			Point2D p6= new Point2D (0,6);
			Point2D p7= new Point2D (2,3);
			Point2D p8= new Point2D (2,6);
			Point2D[] arr = r.points4();
			assertEquals(arr[0],p5);
			assertEquals(arr[1],p6);
			assertEquals(arr[2],p7);
			assertEquals(arr[3],p8);

		}
		

	@Test
	void getPointsTest()
	{
		Point2D p1= new Point2D (2,0);
		Point2D p2= new Point2D (2,3);
		Point2D p3= new Point2D (4,3);
		Point2D p4= new Point2D (4,0);
		Rect2D r= new Rect2D (p1,p2,p3,p4);
		Point2D[] arr = r.getPoints();
		assertEquals(arr[0],p1);
		assertEquals(arr[1],p3);


	}
	
	@Test
	void scaleTest() {
		Point2D p1= new Point2D (2,0);
		Point2D p2= new Point2D (2,3);
		Point2D p4= new Point2D (4,0);
		Point2D p3= new Point2D (4,3);
		Rect2D r= new Rect2D (p1,p2,p3,p4);
		
		r.scale(new Point2D(3, 1.5), 2);
		
		assertEquals(r.getPoints()[0], new Point2D(1.0,-1.5));
		assertEquals(r.getPoints()[1], new Point2D(5.0,4.5));
	}
	
	@Test
	void rotateTest() {
		Point2D p1= new Point2D (2,0);
		Point2D p2= new Point2D (2,3);
		Point2D p4= new Point2D (4,0);
		Point2D p3= new Point2D (4,3);
		Rect2D r= new Rect2D (p1,p2,p3,p4);
		
		r.rotate(new Point2D(3, 1.5), 90);
		assertEquals(r.getPoints()[0], new Point2D(4.5,0.4999999999999999));
		assertEquals(r.getPoints()[1], new Point2D(1.5,2.5));

	}
	



}