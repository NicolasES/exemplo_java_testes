package Models.Contracts;

/**
 *
 * @author nicolas
 */
public interface PersonContract 
{
    public String getName();
    
    public void setName(String name);
    
    public double getHeight();
    
    public void setHeight(double height);
    
    public double getWeight();
    
    public void setWeight(double wheight);
    
    public char getGender();
    
    public void setGender(char gender);
    
    public int getAge();
    
    public void setAge(int age);
}