
package Services;

import Services.Contracts.IMCCalculatorContract;
import Services.Contracts.TGCCalculatorContract;
import Models.Contracts.PersonContract;

/**
 *
 * @author nicolas
 */
public class TGCCalculator implements TGCCalculatorContract
{
    private IMCCalculatorContract imcCAlculator;
    
    public TGCCalculator(IMCCalculatorContract imcCAlculator)
    {
        this.imcCAlculator = imcCAlculator;
    }
    
    @Override
    public double getTGCValue(PersonContract person) 
    {
        double imc = this.imcCAlculator.getIMCValue(person);
        int s = (person.getGender() == 'M')? 1 : 0;
        
        return (1.2 * imc) - (10.8 * s) + (0.23 * person.getAge()) - 5.4;
    }
    
}
