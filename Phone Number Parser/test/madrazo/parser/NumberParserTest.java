package madrazo.parser;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import madrazo.constants.CommonConstants;
import madrazo.dictionary.DictionaryReader;

import org.junit.Test;

public class NumberParserTest
{

    @Test
    public void testAnalyzeNumber1()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "24247.66" );
        List<String> oExpected = new ArrayList<String>( );

        oExpected.add( "CHAIR-NO" );
        oExpected.add( "CHAIR-ON" );
        oExpected.add( "2-GAG-7-NO" );
        oExpected.add( "2-GAG-7-ON" );
        oExpected.add( "2-HAIR-NO" );
        oExpected.add( "2-HAIR-ON" );
        
        assertEquals( oExpected.size( ), oResult.size( ) );

        for ( String sExpected : oExpected )
        {
            if ( oResult.contains( sExpected ) )
            {
                // Remove the item from the result list.
                oResult.remove( sExpected );
            }
        }

        assertEquals( 0, oResult.size( ) );
    }

    @Test
    public void testAnalyzeNumber2()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "42472.66" );
        List<String> oExpected = new ArrayList<String>( );

        oExpected.add( "HAIR-2-ON" );
        oExpected.add( "HAIR-2-NO" );
        oExpected.add( "4-AIR-2-ON" );
        oExpected.add( "4-AIR-2-NO" );
        oExpected.add( "HAIR-AN-6" );
        oExpected.add( "GAG-7-AN-6" );
        oExpected.add( "4-AIR-AN-6" );

        assertEquals( oExpected.size( ), oResult.size( ) );

        for ( String sExpected : oExpected )
        {
            if ( oResult.contains( sExpected ) )
            {
                oResult.remove( sExpected );
            }
        }

        assertEquals( 0, oResult.size( ) );
    }

    @Test
    public void testAnalyzeNumber3()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "24247.663" );
        List<String> oExpected = new ArrayList<String>( );

        oExpected.add( "CHAIR-NO-3" );
        oExpected.add( "CHAIR-ON-3" );
        oExpected.add( "CHAIR-6-ME" );
        oExpected.add( "2-GAG-7-NO-3" );
        oExpected.add( "2-GAG-7-ON-3" );
        oExpected.add( "2-HAIR-NO-3" );
        oExpected.add( "2-HAIR-ON-3" );
        oExpected.add( "2-HAIR-6-ME" );
        
        assertEquals( oExpected.size( ), oResult.size( ) );
        
        for ( String sExpected : oExpected )
        {
            if ( oResult.contains( sExpected ) )
            {
                // Remove the item from the result list.
                oResult.remove( sExpected );
            }
        }

        assertEquals( 0, oResult.size( ) );
    }
    
    @Test
    public void testAnalyzeNumber4()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "263-464-242-5.53-643" );
        List<String> oExpected = new ArrayList<String>( );
        
        oExpected.add( "CODING-CHALLENGE" );
        
        assertEquals( oExpected.size( ), oResult.size( ) );
        
        for ( String sExpected : oExpected )
        {
            if ( oResult.contains( sExpected ) )
            {
                // Remove the item from the result list.
                oResult.remove( sExpected );
            }
        }

        assertEquals( 0, oResult.size( ) );
    }
    
    @Test
    public void testAnalyzeNumber5()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "89-663" );
        List<String> oExpected = new ArrayList<String>( );
        
        oExpected.add( "TWO-ME" );
        oExpected.add( "8-ZONE" );
        
        assertEquals( oExpected.size( ), oResult.size( ) );
        
        for ( String sExpected : oExpected )
        {
            if ( oResult.contains( sExpected ) )
            {
                // Remove the item from the result list.
                oResult.remove( sExpected );
            }
        }

        assertEquals( 0, oResult.size( ) );
    }
    
    @Test
    public void testAnalyzeNumber6()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "77/3!7#36%82%84&6*6(6)6_3" );
        List<String> oExpected = new ArrayList<String>( );
        
        oExpected.add( "PRESENTATION-NO-3" );
        oExpected.add( "PRESENTATION-ON-3" );
        oExpected.add( "PRESENTATION-6-ME" );
        
        assertEquals( oExpected.size( ), oResult.size( ) );
        
        for ( String sExpected : oExpected )
        {
            if ( oResult.contains( sExpected ) )
            {
                // Remove the item from the result list.
                oResult.remove( sExpected );
            }
        }

        assertEquals( 0, oResult.size( ) );
    }
    
    @Test
    public void testAnalyzeNumberInvalid1()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "a5483728873" );

        assertEquals( 0, oResult.size( ) );
    }
    
    @Test
    public void testAnalyzeNumberInvalid2()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "54837a28873" );

        assertEquals( 0, oResult.size( ) );
    }
    
    @Test
    public void testAnalyzeNumberInvalid3()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "548$3728873" );

        assertEquals( 0, oResult.size( ) );
    }
    
    @Test
    public void testAnalyzeNumberInvalid4()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "5483728873+" );

        assertEquals( 0, oResult.size( ) );
    }

    @Test
    public void testAnalyzeNumberInvalid5()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "54831728128373" );

        assertEquals( 0, oResult.size( ) );
    }
    
    @Test
    public void testAnalyzeNumberInvalid6()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        NumberParser oNumParse = new NumberParser( oReader.getDictionary( ) );
        List<String> oResult = oNumParse.analyzeNumber( "^5483728873" );

        assertEquals( 0, oResult.size( ) );
    }
}
