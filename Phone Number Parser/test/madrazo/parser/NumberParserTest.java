package madrazo.parser;

import java.util.List;

import madrazo.constants.CommonConstants;
import madrazo.dictionary.DictionaryReader;
import madrazo.parser.NumberParser;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberParserTest
{

    @Test
    public void testAnalyzeNumber1()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "24247.66" );

        assertEquals( 6, oResult.size( ) );
        int i = 0;
        assertEquals( "CHAIR-NO", oResult.get( i++ ) );
        assertEquals( "CHAIR-ON", oResult.get( i++ ) );
        assertEquals( "2-GAG-7-NO", oResult.get( i++ ) );
        assertEquals( "2-GAG-7-ON", oResult.get( i++ ) );
        assertEquals( "2-HAIR-NO", oResult.get( i++ ) );
        assertEquals( "2-HAIR-ON", oResult.get( i++ ) );
    }

    @Test
    public void testAnalyzeNumber2()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "42472.66" );

        assertEquals( 2, oResult.size( ) );
        assertEquals( "HAIR-2-NO", oResult.get( 0 ) );
        assertEquals( "HAIR-2-ON", oResult.get( 1 ) );
    }
    
    @Test
    public void testAnalyzeNumber3()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "24247.663" );

        assertEquals( 8, oResult.size( ) );
        int i = 0;
        assertEquals( "CHAIR-NO-3", oResult.get( i++ ) );
        assertEquals( "CHAIR-ON-3", oResult.get( i++ ) );
        assertEquals( "CHAIR-6-ME", oResult.get( i++ ) );
        assertEquals( "2-GAG-7-NO-3", oResult.get( i++ ) );
        assertEquals( "2-GAG-7-ON-3", oResult.get( i++ ) );
        assertEquals( "2-HAIR-NO-3", oResult.get( i++ ) );
        assertEquals( "2-HAIR-ON-3", oResult.get( i++ ) );
        assertEquals( "2-HAIR-6-ME", oResult.get( i++ ) );
    }
}
