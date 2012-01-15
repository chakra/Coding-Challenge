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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import madrazo.constants.CommonConstants;
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
     * @param sLine
     *            The line to analyze.
     * @return The resulting analysis of the number.
     */
    public List<String> analyzeNumber( String sLine )
    {
        String sCleanNumber = cleanNumber( sLine );
        List<String> oResult = new ArrayList<String>( );
        List<String> oChildResult = null;
        List<String> oWordList;
        String sTemp;
        String sRemaining;
        String sResult;
        String sAppend;
        
        try
        {
            // Attempt to parse the number.
            new BigInteger( sCleanNumber );
        }
        catch ( NumberFormatException e )
        {
            // Unable to parse! Invalid number. Clear the string to avoid processing.
            sCleanNumber = CommonConstants.STR_EMPTY;
        }

        for ( int nBegin = 0; nBegin < sCleanNumber.length( ) - 1; nBegin++ )
        {
            if ( nBegin == 1 )
            {
                sAppend = String.valueOf( sCleanNumber.charAt( 0 ) ) + CommonConstants.STR_DASH;
            }
            else if ( nBegin > 1 )
            {
                // No two consecutive digits should remain unchanged.
                break;
            }
            else
            {
                sAppend = CommonConstants.STR_EMPTY;
            }
                
            oWordList = null;
            sTemp = null;
            sRemaining = null;
            sResult = null;

            for ( int nEnd = nBegin + 1; nEnd <= sCleanNumber.length( ); nEnd++ )
            {
                sTemp = sCleanNumber.substring( nBegin, nEnd );
                oWordList = coDictionary.get( sTemp );

                if ( oWordList.isEmpty( ) )
                {
                    continue;
                }
                else
                {
                    if ( nEnd != sCleanNumber.length( ) )
                    {
                        // Not yet at its end.
                        // Analyze the rest of the numbers.
                        sRemaining = sCleanNumber.substring( nEnd );
                        oChildResult = analyzeNumber( sRemaining );

                        if ( !oChildResult.isEmpty( ) )
                        {
                            for ( String sWord : oWordList )
                            {
                                // Loop through the word list result.
                                for ( String sChild : oChildResult )
                                {
                                    // Loop through the child results.
                                    sResult = sAppend + sWord + CommonConstants.STR_DASH + sChild;

                                    oResult.add( sResult );
                                }
                            }
                        }
                        else if ( sRemaining.length( ) == 1 )
                        {
                            for ( String sWord : oWordList )
                            {
                                // Loop through the word list and append the
                                // single number.
                                sResult = sAppend + sWord + CommonConstants.STR_DASH + sRemaining;

                                oResult.add( sResult );
                            }
                        }
                    }
                    else
                    {
                        // Reached the end of the number sequence.
                        for ( String sWord : oWordList )
                        {
                            // Loop through the word list.
                            oResult.add( sAppend + sWord );
                        }
                    }
                }
            }
        }

        return oResult;
    }

    /**
     * Cleans the number of any invalid characters: punctuation and white
     * spaces.
     * 
     * @param sNumber
     *            The number to be cleaned.
     * @return The cleaned number.
     */
    private String cleanNumber( String sNumber )
    {
        // Remove all white spaces.
        sNumber = sNumber.replaceAll( "\\p{Z}", CommonConstants.STR_EMPTY );

        // Remove all punctuation.
        sNumber = sNumber.replaceAll( "\\p{P}", CommonConstants.STR_EMPTY );

        return sNumber;
    }
}
