/* 
 * Motu, a high efficient, robust and Standard compliant Web Server for Geographic
 * Data Dissemination.
 *
 * http://cls-motu.sourceforge.net/
 *
 * (C) Copyright 2009-2010, by CLS (Collecte Localisation Satellites) - 
 * http://www.cls.fr - and  Contributors
 *
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */
package fr.cls.atoll.motu.web.bll.exception;

import ucar.unidata.geoloc.LatLonRect;

// CSOFF: MultipleStringLiterals : avoid message in constants declaration and trace log.

/**
 * Depth range exception class of Motu.
 * 
 * (C) Copyright 2009-2010, by CLS (Collecte Localisation Satellites)
 * 
 * @version $Revision: 1.1 $ - $Date: 2009-03-18 12:18:22 $
 * @author <a href="mailto:dearith@cls.fr">Didier Earith</a>
 */
public class MotuInvalidLatLonRangeException extends MotuExceptionBase {

    private static final long serialVersionUID = -1L;

    /**
     * Depth range representation which causes the exception.
     */
    final private LatLonRect invalidRect;

    /**
     * Valid Depth range representation.
     */
    final private LatLonRect validRect;

    /**
     * @param invalidRect invalid lat/lon bounding box representation which causes the exception
     * @param validRect valid lat/lon bounding representation
     */
    public MotuInvalidLatLonRangeException(LatLonRect invalidRect, LatLonRect validRect) {
        this(invalidRect, validRect, null);
    }

    /**
     * @param invalidRect invalid lat/lon bounding box representation which causes the exception
     * @param validRect valid lat/lon bounding representation
     * @param cause native exception.
     */
    public MotuInvalidLatLonRangeException(LatLonRect invalidRect, LatLonRect validRect, Throwable cause) {
        super(getErrorMessage(invalidRect, validRect), cause);

        this.invalidRect = new LatLonRect(invalidRect);
        this.validRect = new LatLonRect(validRect);
    }

    public static String getErrorMessage(LatLonRect invalidRect, LatLonRect validRect) {
        StringBuffer stringBuffer = new StringBuffer("Invalid latitude/longitude bounding box point. ");

        if (invalidRect != null) {
            stringBuffer.append("Invalid bounding box: ");
            stringBuffer.append(getInvalidRectAsString(invalidRect));
        }
        if (validRect != null) {
            stringBuffer.append("\nValid bounding box: lower/left point [");
            stringBuffer.append(getValidRectAsString(validRect));
        }

        stringBuffer.append("\n1) Either Latitude/Longitude bounding box doesn't intersect: ");

        if (validRect != null) {
            stringBuffer.append(getValidRectAsString(validRect));
        } else {
            stringBuffer.append("null");
        }

        stringBuffer.append("\n2) Or intersection is not empty, but there is no data for the requested bounding box: ");

        if (invalidRect != null) {
            stringBuffer.append(getInvalidRectAsString(invalidRect));
        } else {
            stringBuffer.append("null");
        }

        return stringBuffer.toString();
    }

    /**
     * @return the invalidRect
     */
    public LatLonRect getInvalidRect() {
        return this.invalidRect;
    }

    /**
     * @return the validRect as a string interval representation
     */
    public static String getInvalidRectAsString(LatLonRect invalidRect) {
        if (invalidRect == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Lower/left point [");
        stringBuffer.append(invalidRect.getLowerLeftPoint().toString());
        stringBuffer.append("] Upper/right point [");
        stringBuffer.append(invalidRect.getUpperRightPoint().toString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /**
     * @return the validRect
     */
    public LatLonRect getValidRect() {
        return this.validRect;
    }

    /**
     * @return the validRect as a string interval representation
     */
    public static String getValidRectAsString(LatLonRect validRect) {
        if (validRect == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Lower/left point [");
        stringBuffer.append(validRect.getLowerLeftPoint().toString());
        stringBuffer.append("] Upper/right point [");
        stringBuffer.append(validRect.getUpperRightPoint().toString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

}
// CSON: MultipleStringLiterals
