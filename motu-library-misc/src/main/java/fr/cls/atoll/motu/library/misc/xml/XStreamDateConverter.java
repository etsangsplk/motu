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
package fr.cls.atoll.motu.library.misc.xml;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 
 * (C) Copyright 2009-2010, by CLS (Collecte Localisation Satellites)
 * 
 * @version $Revision: 1.1 $ - $Date: 2009-03-18 12:18:22 $
 * @author <a href="mailto:dearith@cls.fr">Didier Earith</a>
 */
public class XStreamDateConverter implements Converter {

    /** The locale. */
    private Locale locale = Locale.getDefault();

    /** The date format style. */
    private int dateFormatStyle = DateFormat.FULL;

    /**
     * The Constructor.
     */
    public XStreamDateConverter() {
        super();
    }

    /**
     * The Constructor.
     * 
     * @param dateFormatStyle the date format style
     */
    public XStreamDateConverter(int dateFormatStyle) {
        super();
        this.dateFormatStyle = dateFormatStyle;
    }

    /**
     * The Constructor.
     * 
     * @param locale the locale
     */
    public XStreamDateConverter(Locale locale) {
        super();
        this.locale = locale;
    }

    /**
     * The Constructor.
     * 
     * @param dateFormatStyle the date format style
     * @param locale the locale
     */
    public XStreamDateConverter(Locale locale, int dateFormatStyle) {
        super();
        this.locale = locale;
        this.dateFormatStyle = dateFormatStyle;
    }

    /**
     * Can convert.
     * 
     * @param clazz the clazz
     * 
     * @return true, if can convert
     */
    @SuppressWarnings("unchecked")
    public boolean canConvert(Class clazz) {
        boolean canConvert = Calendar.class.isAssignableFrom(clazz);
        canConvert |= Date.class.isAssignableFrom(clazz);

        return canConvert;
    }

    /**
     * Marshal.
     * 
     * @param context the context
     * @param value the value
     * @param writer the writer
     */
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        Calendar calendar = null;
        Date date = null;

        if (value instanceof Calendar) {
            calendar = (Calendar) value;
            date = calendar.getTime();
        } else if (value instanceof Date) {
            date = (Date) value;
        } else {
            return;
        }
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL, this.locale);
        writer.setValue(formatter.format(date));
    }

    /**
     * Unmarshal.
     * 
     * @param reader the reader
     * @param context the context
     * 
     * @return the object
     */
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        GregorianCalendar calendar = new GregorianCalendar();
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL, this.locale);
        try {
            calendar.setTime(formatter.parse(reader.getValue()));
        } catch (ParseException e) {
            throw new ConversionException(e.getMessage(), e);
        }
        return calendar;
    }

}