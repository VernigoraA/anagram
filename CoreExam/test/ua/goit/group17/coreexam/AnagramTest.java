package ua.goit.group17.coreexam;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Andre on 30.01.2016.
 */
public class AnagramTest {
    LinkedList wordList;

    @Before
    public void setUp() throws Exception {
        wordList = new LinkedList(Arrays.asList(new String[] {
                "Спаниель", "Апельсин", "error", "read", "dear"
        }));
    }

    @Test
    public void testIsAnagram() throws Exception {
        Assert.assertTrue(Anagram.isAnagram("Апельсин","Спаниель"));
        Assert.assertTrue(Anagram.isAnagram("А роза упала на лапу азора","Ароза упал ан алапу азор а"));
        Assert.assertFalse(Anagram.isAnagram("Апельсин","Спниель"));

    }

    @Test
    public void testGetAnagramsFromList() throws Exception {
        LinkedList resultList=Anagram.getAnagramsFromList(wordList);
        Assert.assertTrue(resultList.contains("Спаниель, Апельсин"));
        Assert.assertTrue(resultList.contains("Апельсин, Спаниель"));
        Assert.assertTrue(resultList.contains("read, dear"));
        Assert.assertTrue(resultList.contains("dear, read"));
        Assert.assertFalse(resultList.contains("error"));
    }

    @Test
    public void testGetAnagramInList() throws Exception {
        Assert.assertEquals(Anagram.getAnagramInList(wordList,"dear"),"read");
        Assert.assertEquals(Anagram.getAnagramInList(wordList,"Апельсин"),"Спаниель");
        Assert.assertEquals(Anagram.getAnagramInList(wordList,"Чейто"),"");
    }
}