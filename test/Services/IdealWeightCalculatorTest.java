package Services;

import Models.Person;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nicolas
 */
public class IdealWeightCalculatorTest 
{
    @Test
    public void testGetIdealWheightMale()
    {
        Person person = new Person("Fulano", 'M');
        person.setHeight(1.80);
        IdealWeightCalculator iwc = new IdealWeightCalculator();
        double result = iwc.getIdealWeight(person);
        assertEquals(72.5, result, 0.009);
    }
    
    @Test
    public void testGetIdealWheightFemale()
    {
        Person person = new Person("Fulano", 'F');
        person.setHeight(1.57);
        IdealWeightCalculator iwc = new IdealWeightCalculator();
        double result = iwc.getIdealWeight(person);
        assertEquals(53.5, result, 0.009);
    }
    
    @Test (expected = RuntimeException.class)
    public void testFailGetIdealWheightWithoutHeight() 
    {
        Person person = new Person("Fulano", 'M');
        IdealWeightCalculator iwc = new IdealWeightCalculator();
        iwc.getIdealWeight(person);
    }
}
