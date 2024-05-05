package tests.geoShapesTest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Polygon;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Polygon2D;
import Exe.Ex4.geo.Segment2D;

class Polygon2DTest {
	
	
	
	@Test
	void ToStringTest()
	{
		Point2D p1= new Point2D (0,0);
		Point2D p2= new Point2D (1,0);
		Point2D p3= new Point2D (2,1);
		Point2D p4= new Point2D (1,2);
		Point2D p5= new Point2D (0,1);
		
		ArrayList <Point2D> p = new ArrayList <Point2D>();
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		Polygon2D poli= new Polygon2D (p);
		assertEquals(poli.toString(),"[0.0,0.0, 1.0,0.0, 2.0,1.0, 1.0,2.0, 0.0,1.0]");
	}

	@Test
	void perimeterTest() 
	{
		Point2D p1= new Point2D(0,0);
		Point2D p2= new Point2D(1,0);
		Point2D p3= new Point2D(1,1);
		Point2D p4= new Point2D(0,1);
		ArrayList <Point2D> p = new ArrayList <Point2D>();
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		Polygon2D poli= new Polygon2D (p);
		assertEquals(poli.perimeter(),4);
		
		
	}
	
	
	@Test
	void moveTest()
	{
		Point2D p1= new Point2D(6,2);
		Point2D p2= new Point2D(1,5);
		Point2D p3= new Point2D(11,-3);
		Point2D p4= new Point2D(0,1);
		Point2D p5= new Point2D(9.2,1);
		ArrayList <Point2D> p = new ArrayList <Point2D>();
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		Polygon2D poli= new Polygon2D (p);
		double pre1= poli.perimeter();
		Point2D pCheck= new Point2D(3,-3);
		poli.move(pCheck);
		double pre2= poli.perimeter();
		assertEquals(pre1,pre2);
		
		
	}
	
	
	@Test
	void getPoints()
	{
		Point2D p1= new Point2D(1,0);
		Point2D p2= new Point2D(3,1);
		Point2D p3= new Point2D(0,1);
		Point2D p4= new Point2D(8,0);
		Point2D p5= new Point2D(-1,0);
		Point2D p6= new Point2D(2,1);
		ArrayList <Point2D> p = new ArrayList <Point2D>();
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		p.add(p6);
		Polygon2D poli= new Polygon2D (p);
		Point2D[] arr = poli.getPoints();
		assertEquals(p1,arr[0]);
		assertEquals(p2,arr[1]);
		assertEquals(p3,arr[2]);
		assertEquals(p4,arr[3]);
		assertEquals(p5,arr[4]);
		assertEquals(p6,arr[5]);
		
		
	}
	
	
	@Test
	void scaleTest() {
		Point2D p1= new Point2D (0,0);
		Point2D p2= new Point2D (1,0);
		Point2D p3= new Point2D (2,1);
		Point2D p4= new Point2D (1,2);
		Point2D p5= new Point2D (0,1);
		
		ArrayList <Point2D> p = new ArrayList <Point2D>();
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		Polygon2D poli= new Polygon2D (p);
		
	    poli.scale(new Point2D(1,1), 2);
		
		assertEquals(poli.getPoints()[0], new Point2D(-1,-1));
		assertEquals(poli.getPoints()[1], new Point2D(1,-1));
		assertEquals(poli.getPoints()[2], new Point2D(3,1));
		assertEquals(poli.getPoints()[3], new Point2D(1,3));
		assertEquals(poli.getPoints()[4], new Point2D(-1,1));
	}
	
	@Test
	void rotateTest() {
		Point2D p1= new Point2D (0,0);
		Point2D p2= new Point2D (1,0);
		Point2D p3= new Point2D (2,1);
		Point2D p4= new Point2D (1,2);
		Point2D p5= new Point2D (0,1);
		
		ArrayList <Point2D> p = new ArrayList <Point2D>();
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);
		Polygon2D poli= new Polygon2D (p);
		
	    poli.rotate(new Point2D(1,1), 360);
		
		assertEquals(poli.getPoints()[0],p1);
		assertEquals(poli.getPoints()[1],p2);
		assertEquals(poli.getPoints()[2],p3);
		assertEquals(poli.getPoints()[3],p4);
		assertEquals(poli.getPoints()[4],p5);
	}
	
	@Test
	void AreaTest() {
		
			Point2D p1= new Point2D (0,0);
			Point2D p2= new Point2D (1,0);
			Point2D p3= new Point2D (2,1);
			Point2D p4= new Point2D (1,2);
			Point2D p5= new Point2D (0,1);
			
			ArrayList <Point2D> p = new ArrayList <Point2D>();
			p.add(p1);
			p.add(p2);
			p.add(p3);
			p.add(p4);
			p.add(p5);
			Polygon2D poli= new Polygon2D (p);
			
			assertEquals(poli.area(),2.5);
		
	}
	
	@Test
	void isCutTest() {
		
		Point2D p1= new Point2D (1,1);
		Point2D p2= new Point2D (3,2);
		Point2D p3= new Point2D (0,1.5);
		Point2D p4= new Point2D (5,1.5);
		Segment2D s1= new Segment2D (p1,p2);
		Segment2D s2= new Segment2D (p3,p4);
		
		assertEquals(Polygon2D.isCut(s1,s2),true);
		
		 p4= new Point2D (1,1.5);
		 s2= new Segment2D (p3,p4);
		 
		 assertEquals(Polygon2D.isCut(s1,s2),false);
		 
		  p1= new Point2D (1,1);
		  p2= new Point2D (4,1);
		  p3= new Point2D (1,0);
		  p4= new Point2D (2,0);
		  s1= new Segment2D (p1,p2);
		  s2= new Segment2D (p3,p4);
		  
		  assertEquals(Polygon2D.isCut(s1,s2),false);
		  
		  p1= new Point2D (6,1);
		  p2= new Point2D (5,4);
		  p3= new Point2D (1,4);
		  p4= new Point2D (7,2);
		  s1= new Segment2D (p1,p2);
		  s2= new Segment2D (p3,p4);
		  
		  assertEquals(Polygon2D.isCut(s1,s2),true);
		  
	}
	
	
	
	@Test
	void ContainsTest() {
		
			Point2D p1= new Point2D (0,0);
			Point2D p2= new Point2D (1,0);
			Point2D p3= new Point2D (2,1);
			Point2D p4= new Point2D (1,2);
			Point2D p5= new Point2D (0.1,1);
			
			ArrayList <Point2D> p = new ArrayList <Point2D>();
			p.add(p1);
			p.add(p2);
			p.add(p3);
			p.add(p4);
			p.add(p5);
			Polygon2D poli= new Polygon2D (p);
			
			Point2D p6= new Point2D (0.75, 0.75);
			Point2D p7= new Point2D (1.1,1.1);
			
			assertEquals(poli.contains(p6),true);
			assertEquals(poli.contains(p7),true);
			
			p6= new Point2D (2,0.2);
			p7= new Point2D (0,1);
			assertEquals(poli.contains(p6),false);
			assertEquals(poli.contains(p7),false);
		
	}
	


}