/*
 * This program is made in response to ACONEX's Coding Challenge #1.
 * By: Andrew Madrazo
 */

/*
 * Revision History
 * 
 * Version  Date        Author  Description
 * 00.01    2012/01/11  Andrew  Draft.
 * 00.02    2012/01/12  Andrew  Changed the templates of the Hashmap.
 */

package madrazo.dictionary;

import java.util.HashMap;
import java.util.List;

import madrazo.constants.CommonConstants;

/**
 * This is a hashmap with a String Key and an Integer Value. The String is the
 * word, and the Integer is its phone number value.
 * 
 * @author Andrew
 * 
 */
public class Dictionary extends HashMap<String, List<String>>
{
    /**
     * Default generated serial version UID.
     */
    private static final long serialVersionUID = -1238162830653779531L;

    /**
     * Returns the value to which the specified key is mapped in this identity
     * hash map, or <i>an empty list</i> if the map contains no mapping for this
     * key.
     * 
     * @param key
     *            the key whose associated value is to be returned.
     * @return the value to which this map maps the specified key, or <i>an
     *         empty list</i> if the map contains no mapping for this key.
     */
    public List<String> get( Object key )
    {
        List<String> oValue = super.get( key );

        if ( oValue == null )
        {
            oValue = CommonConstants.EMPTY_LIST;
        }

        return oValue;
    }
}
