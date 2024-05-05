package geoShapesTest;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import Exe.Ex4.GUIShape;
import Exe.Ex4.GUI_Shapeable;
import Exe.Ex4.ShapeCollection;
import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.ShapeComp;
import Exe.Ex4.geo.Triangle2D;

class ShapeCompTest {
	
	
	ShapeCollection _shapes = new ShapeCollection();
	
	// creating the shapes
			Point2D p1= new Point2D (2,0);
			Point2D p2= new Point2D (2,10);
			Point2D p3= new Point2D (80,0);
			Point2D p4= new Point2D (80,10);
			
			Rect2D r= new Rect2D (p1,p2,p3,p4);
			
			Point2D p5= new Point2D(5,2);
			double rad=1;
			
			Circle2D c= new Circle2D(p5,rad);
			
			Point2D p6= new Point2D (2,0);
			Point2D p7= new Point2D (10,10);
			Point2D p8= new Point2D (8,0);
			
			Triangle2D t= new Triangle2D(p6,p7,p8);
			
			GUI_Shapeable gs1 = new GUIShape(r, false, Color.black, 1);
			GUI_Shapeable gs2 = new GUIShape(c, false, Color.blue, 2);
			GUI_Shapeable gs3 = new GUIShape(t, false, Color.yellow, 3);
			
			
	
	@Test
	void testByPerimeter() {

		
		//insert them into shapescollection
		_shapes.add(gs1); // insert rectangle
		_shapes.add(gs2); // insert rectangle 
		_shapes.add(gs3); // insert triangle
		
		assertEquals(_shapes.get(0), gs1);
		assertEquals(_shapes.get(1), gs2);
		assertEquals(_shapes.get(2), gs3);
		
		_shapes.sort(ShapeComp.CompByPerimeter);
		
		assertEquals(_shapes.get(0), gs2);
		assertEquals(_shapes.get(2), gs1);
		assertEquals(_shapes.get(1), gs3);
		
	}
	
	
	@Test
	void testByAntiPerimeter() {

		
		//insert them into shapescollection
		_shapes.add(gs1); // insert rectangle
		_shapes.add(gs2); // insert circle  
		_shapes.add(gs3); // insert triangle
		
		assertEquals(_shapes.get(0), gs1);
		assertEquals(_shapes.get(1), gs2);
		assertEquals(_shapes.get(2), gs3);
		
		_shapes.sort(ShapeComp.CompByAntiPerimeter);
		
		assertEquals(_shapes.get(2), gs2);
		assertEquals(_shapes.get(0), gs1);
		assertEquals(_shapes.get(1), gs3);
		_shapes.removeAll();
	}
	
	
	@Test
	void testByArea() {

		
		//insert them into shapescollection
		_shapes.add(gs1); // insert rectangle
		_shapes.add(gs2); // insert circle  
		_shapes.add(gs3); // insert triangle
		
		assertEquals(_shapes.get(0), gs1);
		assertEquals(_shapes.get(1), gs2);
		assertEquals(_shapes.get(2), gs3);
		
		_shapes.sort(ShapeComp.CompByArea);
		
		assertEquals(_shapes.get(2), gs1);
		assertEquals(_shapes.get(0), gs2);
		assertEquals(_shapes.get(1), gs3);
		_shapes.removeAll();
		
	}
	
	
	@Test
	void testByAntiArea() {

		
		//insert them into shapescollection
		_shapes.add(gs1); // insert rectangle
		_shapes.add(gs2); // insert circle  
		_shapes.add(gs3); // insert triangle
		assertEquals(_shapes.get(0), gs1);
		assertEquals(_shapes.get(1), gs2);
		assertEquals(_shapes.get(2), gs3);
		
		_shapes.sort(ShapeComp.CompByAntiArea);
		
		assertEquals(_shapes.get(0), gs1);
	    assertEquals(_shapes.get(2), gs2);
		assertEquals(_shapes.get(1), gs3);
		_shapes.removeAll();
		
	}
	
	
	
	@Test
	void testByToString() {

		
		//insert them into shapescollection
		_shapes.add(gs1); // insert rectangle
		_shapes.add(gs2); // insert circle 
		_shapes.add(gs3); // insert triangle
		
		assertEquals(_shapes.get(0), gs1);
		assertEquals(_shapes.get(1), gs2);
		assertEquals(_shapes.get(2), gs3);
		_shapes.sort(ShapeComp.CompByToString);
		assertEquals(_shapes.get(1), gs1);
		assertEquals(_shapes.get(0), gs2);
		assertEquals(_shapes.get(2), gs3);
		_shapes.removeAll();
		
	}
	
	
	@Test
	void testByToAntiString() {

		
		//insert them into shapescollection
		_shapes.add(gs1); // insert rectangle 
		_shapes.add(gs2); // insert circle  
		_shapes.add(gs3); // insert triangle
		
		assertEquals(_shapes.get(0), gs1);
		assertEquals(_shapes.get(1), gs2);
		assertEquals(_shapes.get(2), gs3);
		_shapes.sort(ShapeComp.CompByAntiToString);
		assertEquals(_shapes.get(0), gs1);
		assertEquals(_shapes.get(1), gs2);
		assertEquals(_shapes.get(2), gs3);
		_shapes.removeAll();
		
	}
		
		@Test
		void testByTag() {
			{
				//insert them into shapescollection
				_shapes.add(gs1); // insert rectangle
				_shapes.add(gs2); // insert circle  
				_shapes.add(gs3); // insert triangle
				
				assertEquals(_shapes.get(0), gs1);
				assertEquals(_shapes.get(1), gs2);
				assertEquals(_shapes.get(2), gs3);
				
				_shapes.sort(ShapeComp.CompByTag);
				
				assertEquals(_shapes.get(1), gs2);
				assertEquals(_shapes.get(2), gs1);
				assertEquals(_shapes.get(0), gs3);
				_shapes.removeAll();
			}
		}
		
		
		@Test
		void testByAntiTag() {
			{
				//insert them into shapescollection
				_shapes.add(gs1); // insert rectangle 
				_shapes.add(gs2); // insert circle  
				_shapes.add(gs3); // insert triangle
				
				assertEquals(_shapes.get(0), gs1);
				assertEquals(_shapes.get(1), gs2);
				assertEquals(_shapes.get(2), gs3);
				
				_shapes.sort(ShapeComp.CompByAntiTag);
				
				assertEquals(_shapes.get(1), gs2);
				assertEquals(_shapes.get(0), gs1);
				assertEquals(_shapes.get(2), gs3);
				_shapes.removeAll();
			}
		}
	
	
	
	
	

}
