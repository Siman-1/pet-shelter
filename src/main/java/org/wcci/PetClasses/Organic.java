package org.wcci.PetClasses;

public interface Organic {

    //feed
    public int getHunger();

    public boolean isHungry();

    public boolean isStarving();

    public boolean isOverfed();

    public void feed(int food);

   
    public int getThirst();

    public boolean isDehydrated();

    // doff
    public boolean isOverwatered();

    public boolean isThirsty();
        

    public void water(int water);

    public Integer ageInYears();
    }








