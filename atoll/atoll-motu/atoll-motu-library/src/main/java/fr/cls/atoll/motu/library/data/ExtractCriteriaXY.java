/**
 * 
 */
package fr.cls.atoll.motu.library.data;

import java.util.List;

import ucar.unidata.geoloc.ProjectionRect;

/**
 * This class introduces geographical coverage criterias as X and Y coordinates to be apply on data (for
 * extraction/selection and research).
 * 
 * @author $Author: ccamel $
 * @version $Revision: 1.1 $ - $Date: 2009-03-18 12:18:21 $
 * 
 */
public class ExtractCriteriaXY extends ExtractCriteriaGeo {

    /**
     * Default constructor.
     */
    public ExtractCriteriaXY() {
        // set a ProjectionRect with Default value.
        setProjectionRect(new ProjectionRect());
    }

    /**
     * Constructor.
     * 
     * @param projectionRect X/Y bounding box
     */
    public ExtractCriteriaXY(ProjectionRect projectionRect) {
        setProjectionRect(projectionRect);
    }

    /**
     * Constructor.
     * 
     * @param x1 x coord of any corner of the bounding box
     * @param y1 y coord of the same corner as x1
     * @param x2 x coord of opposite corner from x1,y1
     * @param y2 y coord of same corner as x2
     */
    public ExtractCriteriaXY(double x1, double y1, double x2, double y2) {
        setProjectionRect(x1, y1, x2, y2);
    }

    /**
     * Constructor.
     * 
     * @param x1 x coord of any corner of the bounding box
     * @param y1 y coord of the same corner as x1
     * @param x2 x coord of opposite corner from x1,y1
     * @param y2 y coord of same corner as x2
     */
    public ExtractCriteriaXY(String x1, String y1, String x2, String y2) {
        setProjectionRect(x1, y1, x2, y2);
    }

    /**
     * Constructor from a list that contains low x value, low y value, high x value, high y value.
     * 
     * @param list to be converted
     */
    public ExtractCriteriaXY(List<String> list) {

        switch (list.size()) {
        case 4:
            setProjectionRect(list.get(0), list.get(1), list.get(2), list.get(3));
            break;
        case 3:
            setProjectionRect(list.get(0), list.get(1), list.get(2), list.get(2));
            break;
        case 2:
            setProjectionRect(list.get(0), list.get(1), list.get(0), list.get(1));
            break;
        case 1:
            setProjectionRect(list.get(0), list.get(0), list.get(0), list.get(0));
            break;
        default:
            // set a ProjectionRect with Default value.
            setProjectionRect(new ProjectionRect());
            break;
        }
    }

    /**
     * @uml.property name="projectionRect"
     */
    private ProjectionRect projectionRect;

    /**
     * Getter of the property <tt>projectionRect</tt>.
     * 
     * @return Returns the projectionRect.
     * @uml.property name="projectionRect"
     */
    public ProjectionRect getProjectionRect() {
        return this.projectionRect;
    }

    /**
     * Setter of the property <tt>projectionRect</tt>.
     * 
     * @param projectionRect The projectionRect to set.
     * @uml.property name="projectionRect"
     */
    public void setProjectionRect(ProjectionRect projectionRect) {
        this.projectionRect = projectionRect;
    }

    /**
     * Setter of the property <tt>projectionRect</tt>.
     * 
     * @param x1 x coord of any corner of the bounding box
     * @param y1 y coord of the same corner as x1
     * @param x2 x coord of opposite corner from x1,y1
     * @param y2 y coord of same corner as x2
     * @uml.property name="projectionRect"
     */
    public void setProjectionRect(double x1, double y1, double x2, double y2) {
        this.projectionRect = new ProjectionRect(x1, y1, x2, y2);
    }

    /**
     * Setter of the property <tt>projectionRect</tt>.
     * 
     * @param x1 x coord of any corner of the bounding box
     * @param y1 y coord of the same corner as x1
     * @param x2 x coord of opposite corner from x1,y1
     * @param y2 y coord of same corner as x2
     * @uml.property name="projectionRect"
     */
    public void setProjectionRect(String x1, String y1, String x2, String y2) {
        setProjectionRect(Double.parseDouble(x1), Double.parseDouble(y1), Double.parseDouble(x2), Double.parseDouble(y2));
    }

    /**
     * @return lower left X of the X/Y box, Double.MAX_VALUE if not set.
     */
    public double getLowerLeftX() {
        if (projectionRect == null) {
            return Double.MAX_VALUE;
        }
        return projectionRect.getLowerLeftPoint().getX();
    }

    /**
     * @return upper left X of the X/Y box, Double.MAX_VALUE if not set.
     */
    public double getUpperLeftX() {
        if (projectionRect == null) {
            return Double.MAX_VALUE;
        }
        return projectionRect.getUpperLeftPoint().getX();
    }

    /**
     * @return lower right X of the X/Y box, Double.MAX_VALUE if not set.
     */
    public double getLowerRightX() {
        if (projectionRect == null) {
            return Double.MAX_VALUE;
        }
        return projectionRect.getLowerRightPoint().getX();
    }

    /**
     * @return upper right X of the X/Y box, Double.MAX_VALUE if not set.
     */
    public double getUpperRightX() {
        if (projectionRect == null) {
            return Double.MAX_VALUE;
        }
        return projectionRect.getUpperRightPoint().getX();
    }

    /**
     * @return lower left Y of the X/Y box, Double.MAX_VALUE if not set.
     */
    public double getLowerLeftY() {
        if (projectionRect == null) {
            return Double.MAX_VALUE;
        }
        return projectionRect.getLowerLeftPoint().getY();
    }

    /**
     * @return upper left Y of the X/Y box, Double.MAX_VALUE if not set.
     */
    public double getUpperLeftY() {
        if (projectionRect == null) {
            return Double.MAX_VALUE;
        }
        return projectionRect.getUpperLeftPoint().getY();
    }

    /**
     * @return lower right Y of the X/Y box, Double.MAX_VALUE if not set.
     */
    public double getLowerRightY() {
        if (projectionRect == null) {
            return Double.MAX_VALUE;
        }
        return projectionRect.getLowerRightPoint().getY();
    }

    /**
     * @return upper right Y of the X/Y box, Double.MAX_VALUE if not set.
     */
    public double getUpperRightY() {
        if (projectionRect == null) {
            return Double.MAX_VALUE;
        }
        return projectionRect.getUpperRightPoint().getY();
    }

}
