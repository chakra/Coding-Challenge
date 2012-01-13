/*
 * This program is made in response to ACONEX's Coding Challenge #1.
 * By: Andrew Madrazo
 */

/*
 * Revision History
 * 
 * Version  Date        Author  Description
 * 00.01    2012/01/12  Andrew  Draft.
 */

package madrazo.parser;

import java.util.List;
import java.util.Scanner;

import madrazo.PhoneNumberParser;
import madrazo.constants.CommonConstants;
import madrazo.dictionary.Dictionary;

/**
 * This is the class that will analyze inputs from the command line.
 * 
 * @author Andrew
 * @version 00.01
 */
public class CmdLineParser extends NumberParser
{
    /**
     * Constructor for CmdLineParser.
     * 
     * @param dictionary
     *            The dictionary to user for parsing.
     */
    public CmdLineParser( Dictionary dictionary )
    {
        super( dictionary );
    }

    /**
     * Starts up the STDIN to receive input.
     */
    public void analyzeNumbers()
    {
        Scanner oScanner = new Scanner( System.in );
        List<String> oResult;
        String sLine = null;

        System.out.println( "PHONE NUMBER ANALYZER" );
        System.out.println( "\"Looks for words in your phone number!\"" );
        System.out.println( "(Type \"" + CommonConstants.STR_EXIT + "\" if you want to end.)\n" );

        while ( true )
        {
            System.out.print( "Input number: " );
            sLine = oScanner.nextLine( ).trim( );

            if ( CommonConstants.STR_EXIT.startsWith( sLine ) )
            {
                // End the application.
                System.out.println( "Exiting Phone Number Parser." );
                break;
            }
            else
            {
                // Analyze the line.
                oResult = analyzeNumber( sLine );

                // Display the results.
                PhoneNumberParser.displayResults( sLine, oResult );
            }
        }
    }
}
