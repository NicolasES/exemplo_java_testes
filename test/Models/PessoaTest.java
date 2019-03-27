package Models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolas
 */
public class PessoaTest 
{
    @Test
    public void testSetNameAndGetName()
    {
        Person pessoa = new Person("João",'M');
        pessoa.setName("Fulano");
        assertEquals("Fulano", pessoa.getName());
    }
    
    @Test
    public void testSetHeightAndGetHeight()
    {
        Person pessoa = new Person("Fulano",'M');
        pessoa.setHeight(1.80);
        assertEquals(1.80, pessoa.getHeight(), 0);
    }
    
    @Test
    public void testSetHeightAndGetWeight()
    {
        Person pessoa = new Person("Fulano",'M');
        pessoa.setWeight(76.4);
        assertEquals(76.4, pessoa.getWeight(), 0);
    }
    
    @Test
    public void testSetGenderAndGetGender()
    {
        Person pessoa = new Person("Fulano",'M');
        pessoa.setGender('F');
        assertEquals('F', pessoa.getGender());
    }
    
    @Test(expected = RuntimeException.class)
    public void testFailSetGender()
    {
        Person pessoa = new Person("Fulano",'M');
        pessoa.setGender('N');
    }
    
    @Test
    public void testSetAgeAndGetAge()
    {
        Person pessoa = new Person("Fulano",'M');
        pessoa.setAge(18);
        assertEquals(18, pessoa.getAge());
    }
    
    @Test(expected = RuntimeException.class)
    public void testFailSetAge()
    {
        Person pessoa = new Person("Fulano",'M');
        pessoa.setAge(-18);
    }
}
