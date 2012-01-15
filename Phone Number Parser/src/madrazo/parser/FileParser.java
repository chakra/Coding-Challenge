/*
 * This program is made in response to ACONEX's Coding Challenge #1.
 * By: Andrew Madrazo
 */

/*
 * Revision History
 * 
 * Version  Date        Author  Description
 * 00.01    2012/01/13  Andrew  Draft.
 */

package madrazo.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import madrazo.constants.CommonConstants;
import madrazo.dictionary.Dictionary;

/**
 * This is the class that will analyze the numbers found in a file.
 * 
 * @author Andrew
 * @version 00.01
 */
public class FileParser extends NumberParser
{
    /**
     * Constructor for FileParser.
     * 
     * @param dictionary
     *            The dictionary to user for parsing.
     */
    public FileParser( Dictionary dictionary )
    {
        super( dictionary );
    }

    /**
     * Analyzes the numbers found in the filename.
     * 
     * @param sFileName
     *            The filename of the input file.
     */
    public Map<String, List<String>> analyzeFile( String sFileName ) throws FileNotFoundException
    {
        File oFile = new File( CommonConstants.STR_DEF_INPUT_DIR + sFileName );
        BufferedReader oReader = null;
        FileReader oFileReader = null;
        String sLine = null;
        Map<String, List<String>> oResult = new HashMap<String, List<String>>( );

        try
        {
            // Check if the file is readable.
            oFileReader = new FileReader( oFile );

            // Wrap FileReader into a BufferedReader for easier line reading.
            oReader = new BufferedReader( oFileReader );

            while ( ( sLine = oReader.readLine( ) ) != null )
            {
                if ( !sLine.equals( CommonConstants.STR_EMPTY ) )
                {
                    oResult.put( sLine, analyzeNumber( sLine ) );
                }
            }
        }
        catch ( FileNotFoundException e )
        {
            throw e;
        }
        catch ( IOException e )
        {
            System.err.println( "Error occurred while reading the file: " + sFileName );
            e.printStackTrace( );
        }
        
        return oResult;
    }
}
