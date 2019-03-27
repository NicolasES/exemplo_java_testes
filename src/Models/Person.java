package Models;

import Models.Contracts.PersonContract;

/**
 *
 * @author nicolas
 */
public class Person implements PersonContract
{
    private String name;
    private double height;
    private double weight;
    private char gender;
    private int age;
        
    public Person(String name, char gender)
    {
        this.setName(name);
        this.setGender(gender);
    }

    @Override
    public String getName() 
    {
        return this.name;
    }

    @Override
    public void setName(String name) 
    {
        this.name = name;
    }

    @Override
    public double getHeight() 
    {
        return this.height;
    }

    @Override
    public void setHeight(double height) 
    {
        this.height = height;
    }

    @Override
    public double getWeight()
    {
        return this.weight;
    }

    @Override
    public void setWeight(double wheight) 
    {
        this.weight = wheight;
    }

    @Override
    public char getGender() 
    {
        return this.gender;
    }

    @Override
    public void setGender(char gender) 
    {
        if (gender != 'M' && gender != 'F') {
            throw new RuntimeException("O gênero da pessoa deve M ou F.");
        }
        this.gender = gender;
    }

    @Override
    public int getAge() 
    {
        return this.age;
    }

    @Override
    public void setAge(int age) 
    {
        if (age < 0) {
            throw new RuntimeException("A idade não pode ser inferiro a 0.");
        }
        this.age = age;
    }
    
}
