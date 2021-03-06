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
package fr.cls.atoll.motu.web.bll.request.model.metadata;

/**
 * Paremeter's category. Parameters are grouped by category and discipline.
 * 
 * (C) Copyright 2009-2010, by CLS (Collecte Localisation Satellites)
 * 
 * @version $Revision: 1.1 $ - $Date: 2009-03-18 12:18:22 $
 * @author <a href="mailto:dearith@cls.fr">Didier Earith</a>
 */
public class ParameterCategory {

    /**
     * Default constructor.
     */
    public ParameterCategory() {

    }

    /**
     * @uml.property name="code"
     */
    private String code = "";

    /**
     * Getter of the property <tt>code</tt>.
     * 
     * @return Returns the code.
     * @uml.property name="code"
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter of the property <tt>code</tt>.
     * 
     * @param code The code to set.
     * @uml.property name="code"
     */
    public void setCode(String code) {
        this.code = code;
    }

    // CSOFF: StrictDuplicateCode : normal duplication code.

    /**
     * @uml.property name="label"
     */
    private String label = "";

    /**
     * Getter of the property <tt>label</tt>.
     * 
     * @return Returns the label.
     * @uml.property name="label"
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter of the property <tt>label</tt>.
     * 
     * @param label The label to set.
     * @uml.property name="label"
     */
    public void setLabel(String label) {
        this.label = label;
    }

    // CSON: StrictDuplicateCode

    /**
     * @uml.property name="discipline"
     */
    private String discipline = "";

    /**
     * Getter of the property <tt>discipline</tt>.
     * 
     * @return Returns the discipline.
     * @uml.property name="discipline"
     */
    public String getDiscipline() {
        return this.discipline;
    }

    /**
     * Setter of the property <tt>discipline</tt>.
     * 
     * @param discipline The discipline to set.
     * @uml.property name="discipline"
     */
    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

}
