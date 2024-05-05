package tests.geoShapesTest;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Exe.Ex4.GUIShape;
import Exe.Ex4.GUI_Shapeable;
import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.Triangle2D;

class ShapeCollectionTest {
	
	 private ArrayList<GUI_Shapeable> _shapes;
	
	
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
	void GetTest() {
		_shapes = new ArrayList<GUI_Shapeable>();
		_shapes.add(gs1);
		_shapes.add(gs2);
		_shapes.add(gs3);
		assertEquals(_shapes.get(0),gs1);
		assertEquals(_shapes.get(1),gs2);
	}
	
	@Test
	void sizeTest() {
		_shapes = new ArrayList<GUI_Shapeable>();
		assertEquals(_shapes.size(),0);
		_shapes.add(gs1);
		_shapes.add(gs2);
		_shapes.add(gs3);
		assertEquals(_shapes.size(),3);
	}
				
				
	@Test
	void removeElementAtTest() {
		
		_shapes = new ArrayList<GUI_Shapeable>();
		_shapes.add(gs1);
		_shapes.add(gs2);
		_shapes.add(gs3);
		assertEquals(_shapes.size(),3);
		_shapes.remove(1);
		assertEquals(_shapes.size(),2);
		assertEquals(_shapes.get(1),gs3);
	}
	
	@Test
	void removeAllTest() {
		
		_shapes = new ArrayList<GUI_Shapeable>();
		_shapes.add(gs1);
		_shapes.add(gs2);
		_shapes.add(gs3);
		assertEquals(_shapes.size(),3);
		_shapes.removeAll(_shapes);
		assertEquals(_shapes.size(),0);
	}
	
	@Test
	void AddAtTest() {
		
		_shapes = new ArrayList<GUI_Shapeable>();
		_shapes.add(gs1);
		_shapes.add(gs2);
		_shapes.add(gs3);
		assertEquals(_shapes.size(),3);
		assertEquals(_shapes.get(1),gs2);
		_shapes.add(1, gs1);
		assertEquals(_shapes.size(),4);
		assertEquals(_shapes.get(1),gs1);
	}
	
	@Test
	void TestAdd() {
		
		_shapes = new ArrayList<GUI_Shapeable>();
		_shapes.add(gs1);
		_shapes.add(gs2);
		_shapes.add(gs3);
		assertEquals(_shapes.size(),3);
		_shapes.add(gs1);
		assertEquals(_shapes.size(),4);
		assertEquals(_shapes.get(3),gs1);
		
	}

	
}
