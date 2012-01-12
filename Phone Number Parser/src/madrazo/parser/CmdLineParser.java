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
        System.out.println( "(Type \"quit\" if you want to end.)\n" );

        while ( true )
        {
            System.out.print( "Input number: " );
            sLine = oScanner.nextLine( ).trim( );

            if ( CommonConstants.STR_QUIT.startsWith( sLine ) )
            {
                // End the application.
                break;
            }
            else
            {
                // Analyze the line.
                oResult = analyzeNumber( sLine );

                if ( oResult.size( ) > 1 )
                {
                    System.out.println( "The results are: " );
                    for ( int i = 1; i <= oResult.size( ); i++ )
                    {
                        System.out.println( i + ". " + oResult.get( i - 1 ) );
                    }
                }
                else if ( oResult.size( ) > 0 )
                {
                    System.out.println( " The result is: " + oResult.get( 0 ) );
                }
                else
                {
                    System.out.println( "No words were found in the number: " + sLine );
                }
            }
        }
    }
}
