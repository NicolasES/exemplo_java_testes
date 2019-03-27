
package Application;

import java.util.ArrayList;
import java.util.List;
import Models.Contracts.PersonContract;
import Services.Contracts.IMCCalculatorContract;
import Services.Contracts.TGCCalculatorContract;
import Services.Contracts.IdealWeightCalculatorContract;

/**
 *
 * @author nicolas
 */
public class ApplicationFacade 
{
    private List<PersonContract> people = new ArrayList<PersonContract>();
    private IMCCalculatorContract imcCalculator;
    private TGCCalculatorContract tgcCalculator;
    private IdealWeightCalculatorContract idealWeightCalculator;
    
    
    public ApplicationFacade(
        IMCCalculatorContract imcCalculator,
        TGCCalculatorContract tgcCalculator,
        IdealWeightCalculatorContract idealWeightCalculator
    ) 
    {
        this.imcCalculator = imcCalculator;
        this.tgcCalculator = tgcCalculator;
        this.idealWeightCalculator = idealWeightCalculator;
    }
    
    public void addPerson(PersonContract person)
    {
        this.people.add(person);
    }
    
    public List<PersonContract> getPeople()
    {
        return this.people;
    }
    
    public double getIMC(PersonContract person)
    {
        return this.imcCalculator.getIMCValue(person);
    }

    public double getTGC(PersonContract person) 
    {
        return this.tgcCalculator.getTGCValue(person);
    }

    public double getIdealWeight(PersonContract person) 
    {
        return this.idealWeightCalculator.getIdealWeight(person);
    }

    public String getIMCText(PersonContract person) 
    {
        return this.imcCalculator.getIMCText(person);
    }

}
