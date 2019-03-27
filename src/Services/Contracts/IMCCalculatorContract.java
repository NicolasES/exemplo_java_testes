package Services.Contracts;

import Models.Contracts.PersonContract;
/**
 *
 * @author nicolas
 */
public interface IMCCalculatorContract 
{
    public static String LOW_WEIGHT_TEXT = "Abaixo do peso";
    public static String IDEAL_WEIGHT_TEXT = "Ideal";
    public static String HIGH_WEIGHT_TEXT = "Obeso";
    
    public double getIMCValue(PersonContract person);
    
    public String getIMCText(PersonContract person);
}
