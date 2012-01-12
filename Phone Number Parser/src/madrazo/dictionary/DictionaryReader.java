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

package madrazo.dictionary;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import madrazo.constants.CommonConstants;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * This class reads the dictionary and determines every words' number sequences.
 * 
 * @author Andrew
 * @version 00.01
 */
public class DictionaryReader
{
    /**
     * This will hold the number sequences and their corresponding words based
     * on the dictionary.
     */
    private Dictionary coDictionary;

    /**
     * Initializes the DictionaryReader class with the default dictionary.
     */
    public DictionaryReader( )
    {
        this( null );
    }

    /**
     * Initializes the DictionaryReader class based on the filename provided.
     * The dictionary file should be located inside the <strong>dict</strong>
     * folder.
     * 
     * @param sDictionaryName
     *            The dictionary's filename.
     */
    public DictionaryReader( String sDictionaryName )
    {
        if ( sDictionaryName != null && sDictionaryName.equals( CommonConstants.STR_EMPTY ) )
        {
            sDictionaryName = CommonConstants.STR_DEF_DICTIONARY;
        }

        File oFile = new File( CommonConstants.STR_DEF_DIRECTORY + sDictionaryName );
        BufferedReader oReader = null;
        FileReader oFileReader = null;
        try
        {
            // Check if the file is readable.
            oFileReader = new FileReader( oFile );

            // Wrap FileReader into a BufferedReader for easier line reading.
            oReader = new BufferedReader( oFileReader );
            analyzeDictionary( oReader );
        }
        catch ( FileNotFoundException e )
        {
            System.err.println( "Error occurred while accessing the file: " + sDictionaryName );
            System.err.println( e.getStackTrace( ) );
        }
        catch ( IOException e )
        {
            System.err.println( "Error occurred while reading the file: " + sDictionaryName );
            System.err.println( e.getStackTrace( ) );
        }

    }

    /**
     * This will analyze the dictionary and populate the dictionary map.
     * 
     * @param oReader
     *            The BufferedReader reading the dictionary.
     */
    public void analyzeDictionary( BufferedReader oReader ) throws IOException
    {
        // Initialize the dictionary to be populated.
        coDictionary = new Dictionary( );

        String sWord = null;

        if ( oReader != null )
        {
            sWord = oReader.readLine( );
            while ( sWord != null )
            {
                // Trim the line of leading and trailing white spaces.
                sWord = StringUtils.capitalize( sWord.trim( ) );

                if ( !sWord.equals( CommonConstants.STR_EMPTY ) )
                {
                    continue;
                }
                else
                {
                    addWord( sWord );
                }
            }
        }
    }

    /**
     * Retrieves the dictionary generated from initialization.
     * 
     * @return The dictionary generated.
     */
    public Dictionary getDictionary()
    {
        return coDictionary;
    }

    /**
     * Adds the word into the dictionary with its number sequence as its value.
     * 
     * @param sWord
     *            The word to be added.
     */
    private void addWord( String sWord )
    {
        String sCurrentChar = null;
        int nValue = 0;

        // Initialize the integer string buffer.
        StringBuffer oInteger = new StringBuffer( );

        // Traverse through the line to
        for ( int i = 0; i < sWord.length( ); i++ )
        {
            sCurrentChar = String.valueOf( sWord.charAt( i ) );

            if ( CommonConstants.STR_2.contains( sCurrentChar ) )
            {
                oInteger.append( 2 );
            }
            else if ( CommonConstants.STR_3.contains( sCurrentChar ) )
            {
                oInteger.append( 3 );
            }
            else if ( CommonConstants.STR_4.contains( sCurrentChar ) )
            {
                oInteger.append( 4 );
            }
            else if ( CommonConstants.STR_5.contains( sCurrentChar ) )
            {
                oInteger.append( 5 );
            }
            else if ( CommonConstants.STR_6.contains( sCurrentChar ) )
            {
                oInteger.append( 6 );
            }
            else if ( CommonConstants.STR_7.contains( sCurrentChar ) )
            {
                oInteger.append( 7 );
            }
            else if ( CommonConstants.STR_8.contains( sCurrentChar ) )
            {
                oInteger.append( 8 );
            }
            else if ( CommonConstants.STR_9.contains( sCurrentChar ) )
            {
                oInteger.append( 9 );
            }
        }

        // Convert the number sequence into an integer and add them
        // into the dictionary.
        nValue = Integer.parseInt( oInteger.toString( ) );
        System.out.println( "Adding: " + sWord + " = " + nValue );
        coDictionary.put( sWord, nValue );
    }
}
