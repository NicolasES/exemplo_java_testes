
package Services;

import Services.Contracts.IdealWeightCalculatorContract;
import Models.Contracts.PersonContract;

/**
 *
 * @author nicolas
 */
public class IdealWeightCalculator implements IdealWeightCalculatorContract
{

    @Override
    public double getIdealWeight(PersonContract person) 
    {
        if (person.getHeight() <= 0) {
            throw new RuntimeException("A person passada não possui altura definida.");
        }
        double h = person.getHeight() * 100;
        int k = (person.getGender() == 'M') ? 4 : 2;
        return (h - 100) - ((h-150) / k);
    }
    
}
