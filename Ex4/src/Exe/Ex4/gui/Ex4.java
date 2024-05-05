package Exe.Ex4.gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import Exe.Ex4.Ex4_Const;
import Exe.Ex4.GUIShape;
import Exe.Ex4.GUI_Shapeable;
import Exe.Ex4.ShapeCollection;
import Exe.Ex4.ShapeCollectionable;
import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Polygon2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.Segment2D;
import Exe.Ex4.geo.ShapeComp;
import Exe.Ex4.geo.Triangle2D;

import javax.swing.*;

/**
 * This class is a simple "inter-layer" connecting (aka simplifying) the
 * StdDraw with the Map class.
 * Written for 101 java course it uses simple static functions to allow a
 * "Singleton-like" implementation.
 *
 * @author boaz.benmoshe
 * 
 * ID1:322695883
 * ID2:325763498
 * 
 */
public class Ex4 implements Ex4_GUI {
    private ShapeCollectionable _shapes = new ShapeCollection();
    private GUI_Shapeable _gs;
    private Color _color = Color.blue;
    private boolean _fill = false;
    private String _mode = "";
    private Point2D _p1;
    private Point2D _p2;
    private ArrayList<Point2D> polyPoints;

    private static Ex4 _winEx4 = null;

    private Ex4() {
        init(null);
    }

    public void init(ShapeCollectionable s) {
        if (s == null) {
            _shapes = new ShapeCollection();
        } else {
            _shapes = s.copy();
        }
        GUI_Shapeable _gs = null;
        Polygon2D _pp = null;
        _color = Color.blue;
        _fill = false;
        _mode = "";
        Point2D _p1 = null;
    }

    public void show(double d) {
        StdDraw_Ex4.setScale(0, d);
        StdDraw_Ex4.show();
        drawShapes();
    }

    public static Ex4 getInstance() {
        if (_winEx4 == null) {
            _winEx4 = new Ex4();
        }
        return _winEx4;
    }

    public void drawShapes() {
        StdDraw_Ex4.clear();
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shapeable sh = _shapes.get(i);

            drawShape(sh);
        }
        if (_gs != null) {
            drawShape(_gs);
        }
        StdDraw_Ex4.show();
    }

    private static void drawShape(GUI_Shapeable g) {
        StdDraw_Ex4.setPenColor(g.getColor());
        if (g.isSelected()) {
            StdDraw_Ex4.setPenColor(Color.gray);
        }
        GeoShapeable gs = g.getShape();
        boolean isFill = g.isFilled();
        if (gs instanceof Circle2D) {
            Circle2D c = (Circle2D) gs;
            Point2D cen = c.getPoints()[0];
            double rad = c.getRadius();
            if (isFill) {
                StdDraw_Ex4.filledCircle(cen.x(), cen.y(), rad);
            } else {
                StdDraw_Ex4.circle(cen.x(), cen.y(), rad);
            }
        }
        if (gs instanceof Rect2D) {
            Rect2D r = (Rect2D) gs;
            Point2D[] p = r.getPoints();
            double x = (p[0].x() + p[1].x()) / 2;
            double y = (p[0].y() + p[1].y()) / 2;
            double halfWidth = Math.abs(p[0].x() - p[1].x()) / 2;
            double halfHeight = Math.abs(p[0].y() - p[1].y()) / 2;
            if (isFill) {
                StdDraw_Ex4.filledRectangle(x, y, halfWidth, halfHeight);
            } else {
                StdDraw_Ex4.rectangle(x, y, halfWidth, halfHeight);
            }
        }
        if (gs instanceof Segment2D) {
            Segment2D r = (Segment2D) gs;
            Point2D[] p = r.getPoints();
            StdDraw_Ex4.line(p[0].x(), p[0].y(), p[1].x(), p[1].y());
        }
        if (gs instanceof Triangle2D) {
            Triangle2D t = (Triangle2D) gs;
            //arrays of the points
            Point2D[] p = t.getPoints();
            //array of the triangle x points
            double[] px = {p[0].x(), p[1].x(), p[2].x()};
            //array of the triangle y points
            double[] py = {p[0].y(), p[1].y(), p[2].y()};
            if (isFill) {
                StdDraw_Ex4.filledPolygon(px, py);
            } else {
                StdDraw_Ex4.polygon(px, py);
            }
        }
        if (gs instanceof Polygon2D) {
            Polygon2D pol = (Polygon2D) gs;
            //arrays of the points
            Point2D[] p = pol.getPoints();
            //array of the triangle x points
            double[] px = new double[p.length];
            double[] py = new double[p.length];
            for (int i = 0; i < p.length; i++) {
                px[i] = p[i].x();
                py[i] = p[i].y();
            }
            if (isFill) {
                StdDraw_Ex4.filledPolygon(px, py);
            } else {
                StdDraw_Ex4.polygon(px, py);
            }

        }


    }

    public void actionPerformed(String p) {
        _mode = p;
        // COLOR SECTION
        if (p.equals("Blue")) {
            _color = Color.BLUE;
            setColor(_color);
        }
        if (p.equals("Red")) {
            _color = Color.RED;
            setColor(_color);
        }
        if (p.equals("Green")) {
            _color = Color.GREEN;
            setColor(_color);
        }
        if (p.equals("White")) {
            _color = Color.WHITE;
            setColor(_color);
        }
        if (p.equals("Black")) {
            _color = Color.BLACK;
            setColor(_color);
        }
        if (p.equals("Yellow")) {
            _color = Color.YELLOW;
            setColor(_color);
        }
        if (p.equals("Fill")) {
            _fill = true;
            setFill();
        }
        if (p.equals("Empty")) {
            _fill = false;
            setFill();
        }
        // END COLOR SECTION
        
        // SORT SECTION
        if (_mode.equals("ByArea")) {
            _shapes.sort(ShapeComp.CompByArea);

        }
        if (_mode.equals("ByAntiArea")) {
            _shapes.sort(ShapeComp.CompByAntiArea);

        }
        if (_mode.equals("ByPerimeter")) {
            _shapes.sort(ShapeComp.CompByPerimeter);
        }
        if (_mode.equals("ByAntiPerimeter")) {
            _shapes.sort(ShapeComp.CompByAntiPerimeter);
        }
        if (_mode.equals("ByTag")) {
            _shapes.sort(ShapeComp.CompByTag);
        }
        if (_mode.equals("ByAntiTag")) {
            _shapes.sort(ShapeComp.CompByAntiTag);
        }
        if (_mode.equals("ByToStirng")) {
            _shapes.sort(ShapeComp.CompByToString);
        }
        if (_mode.equals("ByAntiToString")) {
            _shapes.sort(ShapeComp.CompByAntiToString);
        }
        // END SORT SECTION

        // SELECT SECTION
        if (p.equals("All")) {
            for (int i = 0; i < _shapes.size(); i++) {
                GUI_Shapeable s = _shapes.get(i);
                {
                    s.setSelected(!s.isSelected() || s.isSelected());
                }
            }
        }
        if (p.equals("Anti")) {
            for (int i = 0; i < _shapes.size(); i++) {
                GUI_Shapeable s = _shapes.get(i);
                GeoShapeable g = s.getShape();
                if (g != null) {
                    s.setSelected(!s.isSelected());
                }
            }
        }
        if (p.equals("None")) {
            for (int i = 0; i < _shapes.size(); i++) {
                GUI_Shapeable s = _shapes.get(i);
                {
                    s.setSelected(!s.isSelected() && s.isSelected());
                }
            }
        }
        if (p.equals("Info")) {
            System.out.println(getInfo());
        }
        // EDIT SECTION
        if (_mode.equals("Remove")) {
            for (int i = 0; i < _shapes.size(); i++)
                if (_shapes.get(i).isSelected()) {
                    _shapes.removeElementAt(i);
                    //if the shape is been deleted its mean the array list size is -1 so we need to get the i -1 as well
                    i--;
                }
        }
        // END EDIT SECTION

        // FILE SECTION
        if (p.equals("Clear")) {
            _shapes.removeAll();
        }
        if (_mode.equals("Load")) {
            // This object is used to open a file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose a file to load");
            fileChooser.setApproveButtonText("Load");
            fileChooser.setApproveButtonToolTipText("Load the selected file");


            // This lines of code tell to fileChooser to open the project directory
            String currentDirectory = System.getProperty("user.dir");
            File projectDirectory = new File(currentDirectory);
            fileChooser.setCurrentDirectory(projectDirectory);

            // This line of code tells us which option the user has chosen
            int result = fileChooser.showSaveDialog(fileChooser);

            if (result == JFileChooser.APPROVE_OPTION) {
                File fileToLoad = fileChooser.getSelectedFile();
                _shapes.removeAll();
                _shapes.load(fileToLoad.getAbsolutePath());
            }
        }
        if (_mode.equals("Save")) {
            // This object is used to open a file
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose a file to save");

            // This lines of code tell to fileChooser to open the project directory
            String currentDirectory = System.getProperty("user.dir");
            File projectDirectory = new File(currentDirectory);
            fileChooser.setCurrentDirectory(projectDirectory);

            // This line of code tells us which option the user has chosen
            int result = fileChooser.showSaveDialog(fileChooser);

            if (result == JFileChooser.APPROVE_OPTION) {
                File fileToLoad = fileChooser.getSelectedFile();
                System.out.println("Saving to: " + fileToLoad.getAbsolutePath());
                _shapes.save(fileToLoad.getAbsolutePath());
            }
        }
        // END FILE SECTION

        drawShapes();

    }

    // "first click"

    public void mouseClicked(Point2D p) {
        System.out.println("Mode: " + _mode + "  " + p);
        // SHAPES SECTION
        if (_mode.equals("Circle")) {
            if (_gs == null) {
                _p1 = new Point2D(p);
            } else {
                _gs.setColor(_color);
                _gs.setFilled(_fill);
                _shapes.add(_gs);
                _gs = null;
                _p1 = null;
            }
        }
        // Rectangle
        if (_mode.equals("Rect")) {
            if (_gs == null) {
                _p1 = new Point2D(p);
            } else {
                _gs.setColor(_color);
                _gs.setFilled(_fill);
                _shapes.add(_gs);
                _gs = null;
                _p1 = null;
            }
        }
        // Segment
        if (_mode.equals("Segment")) {
            if (_gs == null) {
                _p1 = new Point2D(p);
            } else {
                _gs.setColor(_color);
                _gs.setFilled(_fill);
                _shapes.add(_gs);
                _gs = null;
                _p1 = null;
            }
        }
        //triangle
        if (_mode.equals("Triangle")) {
            if (_gs == null) {
                _p1 = new Point2D(p);
            } else if (_p2 == null) {
                _p2 = new Point2D(p);
            } else {
                _gs.setColor(_color);
                _gs.setFilled(_fill);
                _shapes.add(_gs);
                _gs = null;
                _p1 = null;
                _p2 = null;
            }
        }

        // polygon
        if (_mode.equals("Polygon")) {
            if (_gs == null) {
                _p1 = new Point2D(p); // I initialize this point because of the function "MouseMoved"
                polyPoints = new ArrayList<>();
                polyPoints.add(_p1);
            } else {

                polyPoints.add(p);
            }
        }
        // END SHAPES


        // SELECT SECTION
        if (_mode.equals("Point")) {
            select(p);
        }
        // END SELECT SECTION

        // EDIT SECTION
        if (_mode.equals("Move")) {
            if (_p1 == null) {
                _p1 = new Point2D(p);
            } else {
                _p1 = new Point2D(p.x() - _p1.x(), p.y() - _p1.y());
                move();
                _p1 = null;
            }
        }
        if (_mode.equals("Copy")) {
            if (_p1 == null) {
                _p1 = new Point2D(p);
            } else {
                _p1 = new Point2D(p.x() - _p1.x(), p.y() - _p1.y());
                copy();
                _p1 = null;
            }
        }
        if (_mode.equals("Rotate")) {
            if (_p1 == null) {
                _p1 = new Point2D(p);
            } else {
                double angleRadians = Math.atan2(p.y() - _p1.y(), p.x() - _p1.x());
                double angleDegrees = Math.toDegrees(angleRadians);
                rotate(angleDegrees);
                _p1 = null;
            }
        }
        if (_mode.equals("Scale_90%")) {
            _p1 = new Point2D(p);
            for (int i = 0; i < _shapes.size(); i++) {
                GUI_Shapeable s = _shapes.get(i);
                GeoShapeable g = s.getShape();
                if (s.isSelected())
                    g.scale(_p1, 0.9);
            }
        }
        if (_mode.equals("Scale_110%")) {
            _p1 = new Point2D(p);
            for (int i = 0; i < _shapes.size(); i++) {
                GUI_Shapeable s = _shapes.get(i);
                GeoShapeable g = s.getShape();
                if (s.isSelected()) {
                    g.scale(_p1, 1.1);
                }
            }
        }
        // END EDIT SECTION


        
        drawShapes();
    }

    public void mouseMoved(MouseEvent e) {
        if (_p1 != null) {
            double x1 = StdDraw_Ex4.mouseX();
            double y1 = StdDraw_Ex4.mouseY();
            GeoShapeable gs = null;
            //	System.out.println("M: "+x1+","+y1);
            Point2D p = new Point2D(x1, y1);
            if (_mode.equals("Circle")) {
                double r = _p1.distance(p);
                gs = new Circle2D(_p1, r);
            }
            // Rectangle
            if (_mode.equals("Rect")) {
                gs = new Rect2D(_p1, p);
            }
            // Segment
            if (_mode.equals("Segment")) {
                gs = new Segment2D(_p1, p);
            }
            //Triangle
            if (_mode.equals("Triangle")) {
                if (_p2 != null) {
                    gs = new Triangle2D(_p1, _p2, p);
                } else {
                    gs = new Segment2D(_p1, p);
                }
            }
            if (_mode.equals("Polygon")) {
                if (_p1 != null) {
                    gs = new Polygon2D(polyPoints, p);
                } else {
                    gs = new Segment2D(_p1, p);
                }
            }


            _gs = new GUIShape(gs, false, Color.pink, 0);
            drawShapes();
        }


    }

    public void mouseRightClicked(Point2D p) {
        System.out.println("right click!");
        if(_shapes.size()!=0){
            System.out.println(_shapes.getBoundingBox());
        }
        //end the polygon when the user pressed right click
        if (_mode.equals("Polygon") && _gs != null && _gs.getShape() != null) {
            _gs.setColor(_color);
            _gs.setFilled(_fill);
            _shapes.add(_gs);
            _gs = null;
            _p1 = null;
            drawShapes();
            polyPoints.clear();
        }
    }


    @Override
    public ShapeCollectionable getShape_Collection() {
        // TODO Auto-generated method stub
        return this._shapes;
    }

    @Override
    public void show() {
        show(Ex4_Const.DIM_SIZE);
    }

    @Override
    public String getInfo() {
        // TODO Auto-generated method stub
        String ans = "";
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shapeable s = _shapes.get(i);
            ans += s.toString() + "\n";
        }
        return ans;
    }


    // ----------------------------- PRIVATE METHODS -----------------------------

    private void rotate(double degrees) {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shapeable s = _shapes.get(i);
            GeoShapeable g = s.getShape();
            if (s.isSelected()) {
                System.out.println("degrees = " + degrees);
                g.rotate(_p1, degrees);
            }
        }
    }

    /**
     * This private method is used to copy shapes and move them by p1
     */
    private void copy() {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shapeable s = _shapes.get(i);
            GeoShapeable g = s.getShape();
            if (s.isSelected() && g != null) {
                _shapes.add(s.copy());
                // get the last shape that copied and move it by _p1
                _shapes.get(_shapes.size() - 1).getShape().move(_p1);
            }
        }
    }

    private void select(Point2D p) {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shapeable s = _shapes.get(i);
            GeoShapeable g = s.getShape();
            if (g != null && g.contains(p)) {
                s.setSelected(!s.isSelected());
            }
        }
    }

    private void move() {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shapeable s = _shapes.get(i);
            GeoShapeable g = s.getShape();
            if (s.isSelected() && g != null) {
                g.move(_p1);
            }
        }
    }

    private void setColor(Color c) {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shapeable s = _shapes.get(i);
            if (s.isSelected()) {
                s.setColor(c);
            }
        }
    }

    private void setFill() {
        for (int i = 0; i < _shapes.size(); i++) {
            GUI_Shapeable s = _shapes.get(i);
            if (s.isSelected()) {
                s.setFilled(_fill);
            }
        }
    }
}