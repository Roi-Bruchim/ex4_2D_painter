package Exe.Ex4.geo;

import java.util.Comparator;

import Exe.Ex4.Ex4_Const;
import Exe.Ex4.GUI_Shapeable;

/**
 * This class represents a Comparator over GUI_Shapes - 
 * as a linear order over GUI_Shapes.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class ShapeComp implements Comparator<GUI_Shapeable>{
	//////////add your code below ///////////
	
	
	public static final Comparator<GUI_Shapeable> CompByToString = new ShapeComp(Ex4_Const.Sort_By_toString);
	public static final Comparator<GUI_Shapeable> CompByAntiToString = new ShapeComp(Ex4_Const.Sort_By_Anti_toString);
	public static final Comparator<GUI_Shapeable> CompByPerimeter = new ShapeComp(Ex4_Const.Sort_By_Perimeter);
	public static final Comparator<GUI_Shapeable> CompByAntiPerimeter = new ShapeComp(Ex4_Const.Sort_By_Anti_Perimeter);
	public static final Comparator<GUI_Shapeable> CompByTag = new ShapeComp(Ex4_Const.Sort_By_Tag);
	public static final Comparator<GUI_Shapeable> CompByAntiTag = new ShapeComp(Ex4_Const.Sort_By_Anti_Tag);
	public static final Comparator<GUI_Shapeable> CompByArea = new ShapeComp(Ex4_Const.Sort_By_Area);
	public static final Comparator<GUI_Shapeable> CompByAntiArea = new ShapeComp(Ex4_Const.Sort_By_Anti_Area);
	
	
	private int _flag;
	public ShapeComp(int flag) {
		_flag = flag;
		
	}
	@Override
	public int compare(GUI_Shapeable o1, GUI_Shapeable o2) {
		
		int ans=0;
		if(_flag == Ex4_Const.Sort_By_toString) {
			//making sure to check first them both not null to make sure the sort will not get exception 
			// only if they both null we will compare they toString
	        if (o1.toString() == null && o2.toString() == null) {
	            ans = 0;
	        } else if (o1.toString() == null) {
	            ans = -1;
	        } else if (o2.toString() == null) {
	            ans = 1;
	        } else {
	            ans = o1.toString().compareTo(o2.toString());
	        }
	    }
		if(_flag == Ex4_Const.Sort_By_Anti_toString) {
			//same idea as the toString sort
			if (o2.toString() == null && o1.toString() == null) {
	            ans = 0;
	        } else if (o2.toString() == null) {
	            ans = -1;
	        } else if (o1.toString() == null) {
	            ans = 1;
	        } else {
	            ans = o2.toString().compareTo(o1.toString());
	        }
	    }
		
		
		if(_flag == Ex4_Const.Sort_By_Perimeter) {
			ans = (int) o1.getShape().perimeter() - (int) o2.getShape().perimeter();
		}
		
		if(_flag == Ex4_Const.Sort_By_Anti_Perimeter) {
			ans = (int) o2.getShape().perimeter() - (int) o1.getShape().perimeter();
		}
		if(_flag == Ex4_Const.Sort_By_Area) {
			ans = (int) o1.getShape().area() - (int) o2.getShape().area();
		}
		
		if(_flag == Ex4_Const.Sort_By_Anti_Area) {
			ans = (int) o2.getShape().area() - (int) o1.getShape().area();
		}
		if(_flag == Ex4_Const.Sort_By_Tag) {
			 
			ans = (int) o2.getTag() - (int) o1.getTag();
		}
		if(_flag == Ex4_Const.Sort_By_Anti_Tag) {
			 
			ans = (int) o1.getTag() - (int) o2.getTag();
		}
		
		//////////////////////////////////////////
		return ans;
		
		
	}

}