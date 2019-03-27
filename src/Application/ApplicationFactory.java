
package Application;

import Application.ApplicationFacade;
import Application.ApplicationFacade;
import Services.IMCCalculator;
import Services.IdealWeightCalculator;
import Services.TGCCalculator;

/**
 *
 * @author nicolas
 */
public class ApplicationFactory 
{
    public static ApplicationFacade newApplicationFacade()
    {
        IMCCalculator imcCalculator = new IMCCalculator();
        TGCCalculator tgcCalculator = new TGCCalculator(imcCalculator);
        IdealWeightCalculator idealWeightCalculator = new IdealWeightCalculator();
        return new ApplicationFacade(imcCalculator, tgcCalculator, idealWeightCalculator);
    }
}
