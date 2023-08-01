package org.wcci.PetClasses;

import java.util.ArrayList;
import java.util.List;

public abstract class OrganicPet implements Organic {

    /**
     *
     */

    boolean isSitting = false;
    int sitTraining = 0;
    int fetchTraining = 0;
    int rollOverTraining = 0;

    int age = 0;

    int chance = 0;
    int thirstLevel = 15;
    boolean isThirsty = false;
    boolean isDehydrated = false;
    boolean isOverwatered = false;

    int hungerLevel = 50;
    boolean isHungry = false;
    boolean isStarving = false;
    boolean isOverfed = false;
    boolean isTired = false;
    int tiredness = 0;

    String name;

    // split up methods. Dog and cat same leave here, cat nums different//move to
    // cat
    // and deal with seperately

    public OrganicPet(String name) {
        this.name = name;
    }

    // same
    public int getHunger() {
        return hungerLevel;
    };

    // same
    public void timePassed(int hours) {

        hungerLevel += hours;
        thirstLevel += hours;
        if (hours >= 24) {
            if (feedingtimes.size() == 2) {
                isOverfed = false;
                isHungry = false;
                isStarving = false;
            }
        }
    }

    // same
    public void hourPassed() {
        hungerLevel++;
        thirstLevel++;
    }

    // same
    public int getThirst() {
        return thirstLevel;
    }

    // different
    public boolean isHungry(){
        // if between 50 - 75 hungry
        if (hungerLevel >= 50 && hungerLevel <= 75) {//
            isHungry = true;
        }
        return isHungry;
    
    }

    // diff
    public boolean isStarving(){
        if (hungerLevel > 75) {
            isStarving = true;
        }
        return isStarving;
    }
    

    // diff
    public boolean isOverfed(){
        if (hungerLevel < 49) {// 48
            isOverfed = true;
        }
        return isOverfed;
    }


    // same
    public void giveSnack() {
        hungerLevel -= 10;
    }

    // same
    public void setFeedingSchedule(String schedule) {
        this.feedingtimes = parseSchedule(schedule);
        if (feedingtimes.size() >= 2) {
            hungerLevel -= 30;// 30
            isOverfed = true;
        } else {
            hungerLevel -= 50;// was 50
        }
    }

    // same
    public void setAgeMonths(int months) {
        age = months;
    }

    // same
    public void feed(int food) {
        hungerLevel -= (10 * food);

    }

    // diff
    public boolean isDehydrated(){
        if (thirstLevel > 75) {
            isDehydrated = true;
        }
        return isDehydrated;
    }

    // doff
    public boolean isOverwatered(){
        if (thirstLevel < 10) {
            isOverwatered = false;
        }
        return isOverwatered;
    }
    

    // 50-75 thirsty
    public boolean isThirsty(){
        if(thirstLevel > 20){
            isThirsty = true;
        } else {
            isThirsty = false;
        }
        return isThirsty;
    }
    

    // same
    public void water(int water) {
        thirstLevel -= 10;
    }

    // same
    public Integer ageInYears() {
        return this.age / 12;
    }

    // same
    List<Integer> feedingtimes = new ArrayList<>();

    // returns a list of integers//name of method is parse feeding takes in a string
    // called schedule

    public static List<Integer> parseSchedule(String string) {
        List<Integer> result = new ArrayList<>();
        // We want to go character-by-character through string
        // parseFeeding("6, 9, 17, 21");

        String timeMemory = "";
        String quantityMemory = "";
        boolean quantityMode = false;

        string += ' '; // so we always get the last number
        for (char c : string.toCharArray()) {
            if (c == ' ' || c == ',' || c == ';') {
                if (quantityMode) {
                    if (timeMemory.length() > 0 && Integer.parseInt(quantityMemory) > 0)
                        result.add(Integer.parseInt(timeMemory));
                } else {
                    if (timeMemory.length() > 0)
                        result.add(Integer.parseInt(timeMemory));
                }

                timeMemory = ""; // blank memory after we've used it
                quantityMemory = ""; // blank memory after we've used it
                quantityMode = false;
            } else if (c == ':') {
                quantityMode = true;
            } else {
                if (quantityMode)
                    quantityMemory += c;
                else
                    timeMemory += c;
            }
        }

        return result;
    }

    // same
    public boolean isFedAt(int hour) {
        return feedingtimes.contains(hour);

    }

    // same
    public String getName() {
        return this.name;
    }

    // same
    public void removeFeedingSchedule() {
        this.feedingtimes.clear();
    }

    // diff
    public boolean isTired(){
        if (tiredness > 10) {
            isTired = true;
        }
        return isTired;
    }
    

}
