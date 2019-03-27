
package Services;

import Services.Contracts.IMCCalculatorContract;
import Models.Contracts.PersonContract;

/**
 *
 * @author nicolas
 */
public class IMCCalculator implements IMCCalculatorContract
{
    @Override
    public double getIMCValue(PersonContract person) 
    {
        if (person.getWeight() <= 0 || person.getHeight() <= 0) {
            throw new RuntimeException("A person passada não possui peso ou altura definida.");
        }
        return person.getWeight() / (person.getHeight() * person.getHeight());
    }

    @Override
    public String getIMCText(PersonContract person) 
    {
        double value = this.getIMCValue(person);
        if (person.getGender() == 'M') {
            return this.getIMCTextMale(value);
        }
        return this.getIMCTextFemale(value);
    }
    
    private String getIMCTextMale(double value)
    {
        if (value < 20.7 ) {
            return IMCCalculator.LOW_WEIGHT_TEXT;
        }
        
        if (value <= 26.4 ) {
            return IMCCalculator.IDEAL_WEIGHT_TEXT;
        }
        return IMCCalculator.HIGH_WEIGHT_TEXT;
    }
    
    private String getIMCTextFemale(double value)
    {
        if (value < 19.1 ) {
            return IMCCalculator.LOW_WEIGHT_TEXT;
        }
        
        if (value <= 25.8 ) {
            return IMCCalculator.IDEAL_WEIGHT_TEXT;
        }
        return IMCCalculator.HIGH_WEIGHT_TEXT;
    }
    
}
