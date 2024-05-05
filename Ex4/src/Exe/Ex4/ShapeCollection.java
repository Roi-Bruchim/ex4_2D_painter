package Exe.Ex4;

import Exe.Ex4.geo.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 *
 * @author I2CS
 */
public class ShapeCollection implements ShapeCollectionable {
    private ArrayList<GUI_Shapeable> _shapes;

    public ShapeCollection() {
        _shapes = new ArrayList<GUI_Shapeable>();
    }

    @Override
    public GUI_Shapeable get(int i) {
        return _shapes.get(i);
    }

    @Override
    public int size() {
        if (_shapes.isEmpty())
            return 0;
        return _shapes.size();
    }

    @Override
    public GUI_Shapeable removeElementAt(int i) {
        //////////add your code below ///////////
        return _shapes.remove(i);
        //////////////////////////////////////////
    }

    @Override
    public void addAt(GUI_Shapeable s, int i) {
        //////////add your code below ///////////

        _shapes.add(i, s);

        //////////////////////////////////////////
    }

    @Override
    public void add(GUI_Shapeable s) {
        if (s != null && s.getShape() != null) {
            _shapes.add(s);
        }
    }

    @Override
    public ShapeCollectionable copy() {
        ShapeCollectionable c = new ShapeCollection();
        for (int i = 0; i < this._shapes.size(); i++) {
            c.add(this._shapes.get(i).copy());
        }
        return c;
    }

    @Override
    public void sort(Comparator<GUI_Shapeable> comp) {
        //////////add your code below ///////////
        _shapes.sort(comp);
        //////////////////////////////////////////
    }

    @Override
    public void removeAll() {
        //////////add your code below ///////////
        _shapes.removeAll(_shapes);

        //////////////////////////////////////////
    }

    @Override
    public void save(String file) {
        //////////add your code below ///////////
    	//adding String that contains in every line a GUIShape 
        String ans = "";
        for (GUI_Shapeable shape : _shapes) {
            ans+=shape.toString()+"\n";
        }

        try{
        	//writing this string in our file
            FileWriter fw = new FileWriter(file);
            fw.write(ans);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //////////////////////////////////////////
    }

    /**
     * This function loads a collection of shapes from a file.
     * we seen this function in the internet, learned it and implement it.
     *
     * @param file - the name of the text file to create a gui shape file from.
     */
    @Override
    public void load(String file) {
        ////////// add your code below ///////////
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                //spliting the shape string by ","
                String[] splitted = line.split(",");
                //creating the current shape in line (split 4 contains the shape name)
                //split 1 contains color, 2 is filled, 3 tag and rest is points
            	//so we build a GUIShape according the current line (every shape by her format)
                if (splitted[4].equals("Circle2D")) {
	
                    _shapes.add(
                            new GUIShape(
                                    new Circle2D(new Point2D(Double.parseDouble(splitted[5]), Double.parseDouble(splitted[6])), Double.parseDouble(splitted[7])),
                                    Boolean.parseBoolean(splitted[2]),
                                    new Color(Integer.parseInt(splitted[1])),
                                    Integer.parseInt(splitted[3])));

                } else if (splitted[4].equals("Triangle2D")) {
                    _shapes.add(
                            new GUIShape(
                                    new Triangle2D(new Point2D(Double.parseDouble(splitted[5]), Double.parseDouble(splitted[6])),
                                            new Point2D(Double.parseDouble(splitted[7]), Double.parseDouble(splitted[8])),
                                            new Point2D(Double.parseDouble(splitted[9]), Double.parseDouble(splitted[10]))),
                                    Boolean.parseBoolean(splitted[2]),
                                    new Color(Integer.parseInt(splitted[1])),
                                    Integer.parseInt(splitted[3])));


                } else if (splitted[4].equals("Rect2D")) {
                    _shapes.add(
                            new GUIShape(
                                    new Rect2D(new Point2D(Double.parseDouble(splitted[5]), Double.parseDouble(splitted[6])),
                                            new Point2D(Double.parseDouble(splitted[7]), Double.parseDouble(splitted[8])),
                                            new Point2D(Double.parseDouble(splitted[9]), Double.parseDouble(splitted[10])),
                                            new Point2D(Double.parseDouble(splitted[11]), Double.parseDouble(splitted[12]))),
                                    Boolean.parseBoolean(splitted[2]),
                                    new Color(Integer.parseInt(splitted[1])),
                                    Integer.parseInt(splitted[3])));

                } else if (splitted[4].equals("Segment2D")) {
                    _shapes.add(
                            new GUIShape(
                                    new Segment2D(new Point2D(Double.parseDouble(splitted[5]), Double.parseDouble(splitted[6])),
                                            new Point2D(Double.parseDouble(splitted[7]), Double.parseDouble(splitted[8]))),
                                    Boolean.parseBoolean(splitted[2]),
                                    new Color(Integer.parseInt(splitted[1])),
                                    Integer.parseInt(splitted[3])));


                } else if (splitted[4].equals("Polygon2D")) {

                    // get the length of the array including the points
                    int size = splitted.length;
                    // initialize the array of points
                    ArrayList<Point2D> p = new ArrayList<Point2D>();
                    // loop over the array and add the points to the array
                    // start from index 5 because the first point is always start at index 5
                    // run until the size of the array-1 because we get the last element by 'i+1' so we need to stop before the last element
                    for (int i = 5; i < size - 1; i = i + 2) {
                            Point2D pi = new Point2D(Double.parseDouble(splitted[i]), Double.parseDouble(splitted[i + 1]));
                            p.add(pi);
                    }
                    _shapes.add(new GUIShape(new Polygon2D(p), Boolean.parseBoolean(splitted[2]), new Color(Integer.parseInt(splitted[1])), Integer.parseInt(splitted[3])));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //////////////////////////////////////////
    }

    @Override
    public Rect2D getBoundingBox() {

        if (_shapes==null || _shapes.size() == 0) {
            return null;
        }
        Rect2D ans = null;
        //////////add your code below ///////////
        //finding the minimum and maximum x,y of all the shapes and save the most small and high values
        double minX = Double.MAX_VALUE;
        double minY = Double.MAX_VALUE;
        double maxX = Double.MIN_VALUE;
        double maxY = Double.MIN_VALUE;
        for (GUI_Shapeable shape : _shapes) {
            for (Point2D pts: shape.getShape().getPoints()) {
                if (pts.x() < minX) {
                    minX = pts.x();
                }
                if (pts.y() < minY) {
                    minY = pts.y();
                }
                if (pts.x() > maxX) {
                    maxX = pts.x();
                }
                if (pts.y() > maxY) {
                    maxY = pts.y();
                }
            }
        }
        //create a rect that contain our min and max values 
        ans = new Rect2D(new Point2D(minX, minY), new Point2D(maxX, minY), new Point2D(maxX, maxY), new Point2D(minX, maxY));
        //////////////////////////////////////////
        return ans;
    }

    @Override
    public String toString() {
        String ans = "";
        for (int i = 0; i < size(); i = i + 1) {
            ans += this.get(i);
        }
        return ans;
    }


}