package org.wcci.entities.PetClasses;

public class OrganicCat extends OrganicPet implements Cat{
    
    public OrganicCat(String name){
     super(name);
    }

    boolean isClean = false;
        
    public void cleanLitterBox(){
        isClean = true;
    } 
    
    public boolean isClean(){
        return isClean;
    }
        
    public void chaseMouse(){
        isThirsty = true;
    }

        


}



    