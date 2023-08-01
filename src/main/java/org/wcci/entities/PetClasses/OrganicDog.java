package org.wcci.entities.PetClasses;

import java.util.ArrayList;
import java.util.List;

public class OrganicDog extends OrganicPet implements Organic{
    // constructor
    public OrganicDog(String name) {
        super(name);
    }



    public void commandSit() {
        if (chance >= 70) {
            isSitting = true;
        } else {
            isSitting = false;
        }
    }

    public void train(String trick) {

        if (trick.equals("sitting")) {
            sitTraining++;
            tiredness += 4;
            thirstLevel += 20;

        } else if (trick.equals("rollover")) {
            rollOverTraining++;
            thirstLevel += 10;
            tiredness++;

        } else if (trick.equals("fetching")) {
            fetchTraining++;
            thirstLevel += 10;
            tiredness++;
        }
    }

    public double chanceOfSitting() {

        if (sitTraining == 5 && age >= 1) {
            chance = 80;
        } else if (sitTraining >= 2 && sitTraining <= 4 && age >= 1) {
            chance = 50;
        } else if (sitTraining < 2 && age >= 1) {
            chance = 20;
        } else if (age < 1) {
            chance = 0;
        }
        return chance;
    }

    List<Integer> walkingtimes = new ArrayList<>();

    public void setWalkingSchedule(String schedule) {

        this.walkingtimes = parseSchedule(schedule);

    }

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

    public void removeWalkingSchedule() {
        this.walkingtimes.clear();
    }


    public void walk() {
        thirstLevel++;
        tiredness++;

    }
    
}
