package tests.geoShapesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.Point2D;

class Point2DTest {

	@Test
	void distanceTest() {
		Point2D p1= new Point2D (1,1);
		Point2D p2= new Point2D (-2,0);
		assertEquals(p1.distance(),Math.sqrt(2));
		assertEquals(p2.distance(),2);
		Point2D p3= new Point2D (8,0);
		assertEquals(p2.distance(p3),10);
	}
	
	
	@Test
	void moveTest()
	{
		Point2D p1= new Point2D (7.2,-3);
		Point2D p2= new Point2D (3,-3.5);
		p1.move(p2);
		Point2D p3= new Point2D (10.2,-6.5);
		assertEquals(p1,p3);
		
	}
	
	@Test
	void containsTest()
	{
		Point2D p1= new Point2D (2,2);
		Point2D p2= new Point2D (2,2);
		Point2D p3= new Point2D (2.01,2);
		assertEquals(p1.contains(p2),true);
		assertEquals(p2.contains(p3),false);
		
	}
	
	@Test
	void copyTest()
	{
		Point2D p1= new Point2D (-5,5);
		Point2D p2= p1.copy();
		Point2D[] arr = p2.getPoints();
		assertEquals(arr[0],p1);
	}
	
	
	@Test
	void getPoints()
	{
		Point2D p1= new Point2D (Math.PI,8);
		Point2D[] arr = p1.getPoints();
		assertEquals(arr[0],p1);
		
	}

}