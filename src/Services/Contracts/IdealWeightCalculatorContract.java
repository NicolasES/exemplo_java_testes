package Services.Contracts;

import Models.Contracts.PersonContract;

/**
 *
 * @author nicolas
 */
public interface IdealWeightCalculatorContract 
{
    public double getIdealWeight(PersonContract person);
}
