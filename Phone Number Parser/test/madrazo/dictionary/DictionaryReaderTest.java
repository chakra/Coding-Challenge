package madrazo.dictionary;

import static org.junit.Assert.*;

import madrazo.constants.CommonConstants;

import org.junit.Test;

public class DictionaryReaderTest
{

    @Test
    public void testAnalyzeDictionary()
    {
        DictionaryReader oReader = new DictionaryReader( CommonConstants.STR_DEF_DICTIONARY );
        
        assertNotNull( oReader.getDictionary( ) );
    }

}
