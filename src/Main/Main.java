
package Main;

import Application.UI.ConsoleUI;
import Application.ApplicationFactory;
import java.util.Scanner;

/**
 *
 * @author nicolas
 */
public class Main 
{
    public static void main(String[] args) 
    {
        ConsoleUI ui = new ConsoleUI(ApplicationFactory.newApplicationFacade());
        ui.showPrincipalMenu();
        
//        Scanner s = new Scanner(System.in);
//        char c = s.next().charAt(0);
//        System.out.println(c);
//        int i = s.nextInt();
//        System.out.println(i);
//        c = s.next().charAt(0);
//        System.out.println(c);
    }
}
