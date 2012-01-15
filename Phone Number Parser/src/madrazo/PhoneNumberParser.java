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

package madrazo;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import madrazo.constants.CommonConstants;
import madrazo.dictionary.Dictionary;
import madrazo.dictionary.DictionaryReader;
import madrazo.parser.CmdLineParser;
import madrazo.parser.FileParser;
import madrazo.parser.NumberParser;

/**
 * This class will hold the main class of the PhoneNumberParser.
 * 
 * @author Andrew
 */
public class PhoneNumberParser
{
    /**
     * 
     * 
     * @param args
     */
    public static void main( String[ ] args )
    {
        DictionaryReader oDictionaryReader = null;
        Dictionary oDict = null;
        CmdLineParser oCmdLine = null;
        NumberParser oNumParser = null;
        FileParser oFileParser = null;

        Map<String, List<String>> oResults = null;
        List<String> oValues = null;

        String sDictionaryName = null;
        String sCurrent = null;

        int nArgsLength = 0;
        int i = 0;

        if ( args.length > 0 )
        {
            if ( args[ i ].equals( CommonConstants.STR_DICT_OPTION ) )
            {
                i++;
                sDictionaryName = args[ i++ ];
            }

            nArgsLength = args.length - i;
            oDictionaryReader = new DictionaryReader( sDictionaryName );
            oDict = oDictionaryReader.getDictionary( );

            if ( nArgsLength > 0 )
            {
                // Remaining arguments could either be a series of numbers, a
                // series of filenames, or both.
                oNumParser = new NumberParser( oDict );
                oFileParser = new FileParser( oDict );

                for ( ; i < args.length; i++ )
                {
                    sCurrent = args[ i ];

                    try
                    {
                        oResults = oFileParser.analyzeFile( sCurrent );

                        displayResults( oResults );
                    }
                    catch ( FileNotFoundException e )
                    {
                        // It's not a filename. It might be a number sequence.
                        oValues = oNumParser.analyzeNumber( sCurrent );

                        displayResults( sCurrent, oValues );
                    }
                }
            }
            else
            {
                // Invoke command line to gather inputs from the user.
                oCmdLine = new CmdLineParser( oDict );

                oCmdLine.analyzeNumbers( );
            }
        }
        else
        {
            // Invoke command line to gather inputs from the user.
            oDictionaryReader = new DictionaryReader( );
            oCmdLine = new CmdLineParser( oDictionaryReader.getDictionary( ) );

            oCmdLine.analyzeNumbers( );
        }
    }

    /**
     * Displays the results.
     * 
     * @param sSequence
     *            The number sequence in string format.
     * @param oValues
     *            The resulting words of the number sequence.
     */
    public static void displayResults( String sSequence, List<String> oValues )
    {
        Map<String, List<String>> oResults = new HashMap<String, List<String>>( );
        oResults.put( sSequence, oValues );

        displayResults( oResults );
    }

    /**
     * Displays the results. Traverses through the map and displays all
     * information.
     * 
     * @param oResults
     *            The map of the results.
     */
    public static void displayResults( Map<String, List<String>> oResults )
    {
        Set<String> oKeys = oResults.keySet( );
        List<String> oValues = null;
        int i;

        for ( String sKey : oKeys )
        {
            i = 1;

            oValues = oResults.get( sKey );
            if ( oValues.size( ) > 1 )
            {
                System.out.println( "Results for " + sKey + " are: " );
                for ( String sValue : oValues )
                {
                    System.out.println( ( i++ ) + ". " + sValue );
                }
            }
            else if ( oValues.size( ) == 1 )
            {
                System.out.println( "The result for " + sKey + " is: " + oValues.get( 0 ) );
            }
            else
            {
                System.out.println( "No words were found in the sequence: " + sKey );
            }
            
            // Insert a line for separation and readability.
            System.out.println( );
        }
    }
}
