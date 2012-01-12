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

    
}
