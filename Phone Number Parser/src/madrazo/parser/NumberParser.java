/*
 * This program is made in response to ACONEX's Coding Challenge #1.
 * By: Andrew Madrazo
 */

/*
 * Revision History
 * 
 * Version  Date        Author  Description
 * 00.01    2012/01/11  Andrew  Draft.
 */

package madrazo.parser;

import java.util.List;

import madrazo.dictionary.Dictionary;

/**
 * This class parses number sequences and determine words based on the
 * dictionary provided.
 * 
 * @author Andrew
 * @version 00.01
 */
public class NumberParser
{
    /**
     * The dictionary instance for this parser.
     */
    private Dictionary coDictionary;

    /**
     * The constructor of the NumberParser class.
     * 
     * @param oDictionary
     *            The dictionary to be used to analyze the numbers.
     */
    public NumberParser( Dictionary oDictionary )
    {
        coDictionary = oDictionary;
    }

    /**
     * This will analyze the string sequence if it is a valid number.
     * 
     * @param sNumber
     *            The number to in scrutiny.
     * @return The resulting analysis of the number.
     */
    public List<String> analyzeNumber( String sNumber )
    {
        int nCleanNumber = cleanNumber( sNumber );
        List<String> oResult = coDictionary.get( nCleanNumber );

        return oResult;
    }

    /**
     * Cleans the number of any invalid characters: punctuation and white
     * spaces.
     * 
     * @param sNumber
     *            The number to be cleaned.
     * @return The cleaned number as an integer value.
     */
    private int cleanNumber( String sNumber )
    {
        int nResult = 0;
        char cChar;
        
        for ( int i = 0; i < sNumber.length( ); )
        {
            cChar = sNumber.charAt( i );
            
            // Check if the character is not a digit.
            if ( !Character.isDigit( sNumber.charAt( i ) ) )
            {
                // Not a digit. Remove the character, and any other instance of it.
                sNumber = sNumber.replace( cChar, '\0' );
            }
            else
            {
                // A digit. Move to the next character.
                i++;
            }
        }

        // Convert resulting number into an integer.
        nResult = Integer.parseInt( sNumber );
        
        return nResult;
    }
}
