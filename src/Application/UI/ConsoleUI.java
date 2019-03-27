
package Application.UI;

import Application.ApplicationFacade;
import Models.Contracts.PersonContract;
import Models.Person;
import java.util.Scanner;

/**
 *
 * @author nicolas
 */
public class ConsoleUI 
{
    private ApplicationFacade app;
    private Scanner scan;
    
    public ConsoleUI(ApplicationFacade app)
    {
        this.app = app;
        this.scan = new Scanner(System.in);
    }
    
    public void showPrincipalMenu()
    {
        try {
            System.out.println("\n\n--------------------------------------------------------");
            System.out.println("Selecione um paciente ou adicione um novo: ");
            this.showPeopleList();
            System.out.println("\n\t(a) Adicionar novo paciente");
            System.out.println("\t(d) Deletar paciente");
            System.out.println("\t(s) Sair");


            String option = this.scan.nextLine();

            if (option.equals("a")) {
                this.addPerson();
                return;
            }
            
            if (option.equals("d")) {
                this.deletePerson();
                return;
            }

            if (option.equals("s")) {
                System.exit(0);
            }
            this.personSelected(this.app.getPeople().get(Integer.parseInt(option)- 1));
        } catch (RuntimeException e) {
            System.out.println("\n\n--------------------------------------------------------");
            System.out.println("Erro...");
            System.out.println("--------------------------------------------------------");
            
            this.showPrincipalMenu();
        }
    }

    private void showPeopleList() 
    {
        if (this.app.getPeople().size() > 0) {
            for (PersonContract person : this.app.getPeople() ) {
                int cod = this.app.getPeople().indexOf(person) + 1;
                System.out.println("\t("+cod+")"+person.getName());
            }
            return;
        }
        System.out.println("\n\tNenhum paciente cadastrado\n");
    }

    private void addPerson() 
    {
        System.out.println("\n\n--------------------------------------------------------");
        System.out.print("Nome: ");
        String name = this.scan.nextLine();
        System.out.print("Gênero (M/F): ");
        char gender = this.scan.nextLine().charAt(0);
        System.out.print("Idade: ");
        int age = Integer.parseInt(this.scan.nextLine());
        System.out.print("Altura (ex:1.76): ");
        double height =  Double.parseDouble(this.scan.nextLine());
        System.out.print("Peso (ex:70.5): ");
        double weight = Double.parseDouble(this.scan.nextLine());
        
        Person person = new Person(name, gender);
        person.setAge(age);
        person.setHeight(height);
        person.setWeight(weight);
        
        this.app.addPerson(person);
        this.showPrincipalMenu();
    }
    
    public void deletePerson()
    {
        System.out.println("\n\n--------------------------------------------------------");
        System.out.println("Selecione um paciente para excluir: ");
        this.showPeopleList();
        System.out.println("\n\t(0) Voltar");
        String option = this.scan.nextLine();
        if (option.equals("0")) {
            this.showPrincipalMenu();
            return;
        }
        
        if ((Integer.parseInt(option) - 1) > (this.app.getPeople().size() -1) || (Integer.parseInt(option) - 1) < 0) {
            System.out.println("\n--------------------------------------------------------");
            System.out.println("Opção inválida");
            System.out.println("--------------------------------------------------------");
            this.deletePerson();
            return;
        }
        
        this.app.getPeople().remove(Integer.parseInt(option) - 1);
        this.deletePerson();
    }

    private void personSelected(PersonContract person) 
    {
        System.out.println("\n\n--------------------------------------------------------");
        System.out.println("Nome: "+person.getName());
        System.out.println("Gênero: "+person.getGender());
        System.out.println("Idade: "+person.getAge());
        System.out.println("Altura: "+person.getHeight());
        System.out.println("Peso: "+person.getWeight());
        System.out.println("--------------------------------------------------------\n");
        System.out.println("(1) Descubra o IMC - Índice de Massa Corporal:");
        System.out.println("(2) Descubra o TGC - Taxa de Gordura Corporal:");
        System.out.println("(3) Descubra o peso ideal:");
        System.out.println("\n(0) Voltar");
        String option = this.scan.nextLine();
        
        switch (Integer.parseInt(option)) {
            case 1: this.imcSelected(person); break;
            case 2: this.tgcSelected(person); break;
            case 3: this.idealWeightSelected(person); break;
            default: this.showPrincipalMenu();
        }
    }

    private void imcSelected(PersonContract person) 
    {
        String result = String.format("%.2f", this.app.getIMC(person));
        System.out.println("\n\n--------------------------------------------------------");
        System.out.println("O IMC é "+result+", "+this.app.getIMCText(person));
        System.out.println("--------------------------------------------------------");
        this.scan.nextLine();
        this.personSelected(person);
    }

    private void tgcSelected(PersonContract person) 
    {
        String result = String.format("%.2f", this.app.getTGC(person));
        System.out.println("\n\n--------------------------------------------------------");
        System.out.println("O TGC é "+result);
        System.out.println("--------------------------------------------------------");
        this.scan.nextLine();
        this.personSelected(person);
    }

    private void idealWeightSelected(PersonContract person) 
    {
        String result = String.format("%.2f", this.app.getIdealWeight(person));
        System.out.println("\n\n--------------------------------------------------------");
        System.out.println("O peso ideal é "+result);
        System.out.println("--------------------------------------------------------");
        this.scan.nextLine();
        this.personSelected(person);
    }
}
