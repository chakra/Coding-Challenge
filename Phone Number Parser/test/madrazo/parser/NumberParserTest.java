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
        assertEquals( "CHAIR-MO", oResult.get( i++ ) );
        assertEquals( "CHAIR-OM", oResult.get( i++ ) );
        assertEquals( "2-GAG-7-MO", oResult.get( i++ ) );
        assertEquals( "2-GAG-7-OM", oResult.get( i++ ) );
        assertEquals( "2-HAIR-MO", oResult.get( i++ ) );
        assertEquals( "2-HAIR-OM", oResult.get( i++ ) );
    }

    @Test
    public void testAnalyzeNumber2()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "42472.66" );

        assertEquals( 2, oResult.size( ) );
        assertEquals( "HAIR-2-MO", oResult.get( 0 ) );
        assertEquals( "HAIR-2-OM", oResult.get( 1 ) );
    }
    
    @Test
    public void testAnalyzeNumber3()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "24247.663" );

        assertEquals( 8, oResult.size( ) );
        int i = 0;
        assertEquals( "CHAIR-MO-3", oResult.get( i++ ) );
        assertEquals( "CHAIR-OM-3", oResult.get( i++ ) );
        assertEquals( "CHAIR-6-ME", oResult.get( i++ ) );
        assertEquals( "2-GAG-7-MO-3", oResult.get( i++ ) );
        assertEquals( "2-GAG-7-OM-3", oResult.get( i++ ) );
        assertEquals( "2-HAIR-MO-3", oResult.get( i++ ) );
        assertEquals( "2-HAIR-OM-3", oResult.get( i++ ) );
        assertEquals( "2-HAIR-6-ME", oResult.get( i++ ) );
    }
}
