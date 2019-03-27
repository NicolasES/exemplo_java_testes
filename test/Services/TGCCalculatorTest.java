
package Services;

import org.junit.Test;
import static org.junit.Assert.*;
import Models.Person;

/**
 *
 * @author nicolas
 */
public class TGCCalculatorTest 
{
    @Test
    public void testGetTGCValueMale()
    {
        IMCCalculator imc = new IMCCalculator();
        TGCCalculator tgc = new TGCCalculator(imc);
        Person person = new Person("Fulano", 'M');
        person.setAge(25);
        person.setHeight(1.81);
        person.setWeight(82);
        
        assertEquals(19.58, tgc.getTGCValue(person), 0.009);
    }
    
    @Test
    public void testGetTGCValueFemale()
    {
        IMCCalculator imc = new IMCCalculator();
        TGCCalculator tgc = new TGCCalculator(imc);
        Person person = new Person("Fulano", 'F');
        person.setAge(47);
        person.setHeight(1.67);
        person.setWeight(90);
        
        assertEquals(44.13, tgc.getTGCValue(person), 0.009);
    }
}
