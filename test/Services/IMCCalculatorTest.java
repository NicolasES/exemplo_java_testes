
package Services;

import org.junit.Test;
import static org.junit.Assert.*;
import Models.Person;

/**
 *
 * @author nicolas
 */
public class IMCCalculatorTest 
{
    @Test
    public void testGetIMCValue() 
    {
        Person person = new Person("Fulano",'M');
        person.setHeight(1.81);
        person.setWeight(81);
        
        IMCCalculator imc = new IMCCalculator();
        
        assertEquals(24.72, imc.getIMCValue(person), 0.009);
    }
    
    @Test (expected = RuntimeException.class)
    public void testFailGetIMCValueWithoutHeight() 
    {
        Person person = new Person("Fulano",'M');
        person.setWeight(81);
        
        IMCCalculator imc = new IMCCalculator();
        imc.getIMCValue(person);
    }
    
    @Test (expected = RuntimeException.class)
    public void testFailGetIMCValueWithoutWeight() 
    {
        Person person = new Person("Fulano",'M');
        person.setHeight(1.81);
        
        IMCCalculator imc = new IMCCalculator();
        imc.getIMCValue(person);
    }
    
    @Test
    public void testIMCIdeal() 
    {
        Person person = new Person("Fulano",'M');
        person.setHeight(1.81);
        person.setWeight(81);
        
        IMCCalculator imc = new IMCCalculator();
        
        assertEquals("Ideal", imc.getIMCText(person));
        
        person.setGender('F');
        assertEquals("Ideal", imc.getIMCText(person));
    }
    
    @Test
    public void testIMCLow() 
    {
        Person person = new Person("Fulano",'M');
        person.setHeight(1.81);
        person.setWeight(50);
        
        IMCCalculator imc = new IMCCalculator();
        
        assertEquals("Abaixo do peso", imc.getIMCText(person));
        
        person.setGender('F');
        assertEquals("Abaixo do peso", imc.getIMCText(person));
    }
    
    @Test
    public void testIMCHight() 
    {
        Person person = new Person("Fulano",'M');
        person.setHeight(1.81);
        person.setWeight(110);
        
        IMCCalculator imc = new IMCCalculator();
        
        assertEquals("Obeso", imc.getIMCText(person));
        
        person.setGender('F');
        assertEquals("Obeso", imc.getIMCText(person));
    }
}
