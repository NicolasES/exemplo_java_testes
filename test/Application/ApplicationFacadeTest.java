
package Application;

import Application.ApplicationFacade;
import org.junit.Test;
import static org.junit.Assert.*;
import Models.Contracts.PersonContract;
import Models.Person;

/**
 *
 * @author nicolas
 */
public class ApplicationFacadeTest 
{
    private static ApplicationFacade application = ApplicationFactory.newApplicationFacade();
    private static PersonContract joao;
    private static PersonContract maria;
    
    public ApplicationFacadeTest()
    {
        Person personJoao = new Person("joao", 'M');
        personJoao.setAge(26);
        personJoao.setHeight(1.81);
        personJoao.setWeight(81);
        
        Person personMaria = new Person("Maria", 'F');
        personMaria.setAge(38);
        personMaria.setHeight(1.65);
        personMaria.setWeight(77);
        
        ApplicationFacadeTest.joao = personJoao;
        ApplicationFacadeTest.maria = personMaria;
    }
    
    @Test
    public void testAddPersonAndGetPeople()
    {
        ApplicationFacadeTest.application.addPerson(ApplicationFacadeTest.joao);
        ApplicationFacadeTest.application.addPerson(ApplicationFacadeTest.maria);
        
        assertTrue(ApplicationFacadeTest.application.getPeople().contains(ApplicationFacadeTest.joao));
        assertTrue(ApplicationFacadeTest.application.getPeople().contains(ApplicationFacadeTest.maria));
    }
    
    @Test
    public void testGetIMC()
    {
        double imc = ApplicationFacadeTest.application.getIMC(ApplicationFacadeTest.joao);
        assertEquals(24.72, imc, 0.009);
        
        imc = ApplicationFacadeTest.application.getIMC(ApplicationFacadeTest.maria);
        assertEquals(28.28, imc, 0.009);
    }
    
    @Test
    public void testGetIMCText()
    {
        String txt = ApplicationFacadeTest.application.getIMCText(ApplicationFacadeTest.joao);
        assertEquals("Ideal", txt);
        
        txt = ApplicationFacadeTest.application.getIMCText(ApplicationFacadeTest.maria);
        assertEquals("Obeso", txt);
    }
    
    @Test
    public void testGetTGC()
    {
        double tgc = ApplicationFacadeTest.application.getTGC(ApplicationFacadeTest.joao);
        assertEquals(19.44, tgc, 0.01);
        
        tgc = ApplicationFacadeTest.application.getTGC(ApplicationFacadeTest.maria);
        assertEquals(37.27, tgc, 0.01);
    }
    
    @Test
    public void testGetIdealWeight()
    {
        double idealWeight = ApplicationFacadeTest.application.getIdealWeight(ApplicationFacadeTest.joao);
        assertEquals(73.25, idealWeight, 0.01);
        
        idealWeight = ApplicationFacadeTest.application.getIdealWeight(ApplicationFacadeTest.maria);
        assertEquals(57.5, idealWeight, 0.01);
    }
}
