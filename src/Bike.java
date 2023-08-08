/*
 * Bike
 * Using Comparable and Comparator
 * Author:       Michael Muehlberger
 * Last Change:  23.03.2023
 */

import java.util.Comparator;
import java.lang.Comparable;

public class Bike implements Comparable<Bike> {

    private String brand;
    private int horsePower;
    private String color;
    private int contructionYear;

    private BikeType.Type type;

    //constructor
    public Bike(String brand, int horsePower, String color, int constructionYear, BikeType.Type type){
        this.brand = brand;
        this.color = color;
        this.horsePower = horsePower;
        this.contructionYear = constructionYear;
        this.type = type;
    }

    public Bike() {}

    //setters
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setContructionYear(int contructionYear) {
        this.contructionYear = contructionYear;
    }
    public void setType(BikeType.Type type) {
        this.type = type;
    }

    //getters

    public String getBrand() {
        return this.brand;
    }

    public int getHorsePower() {
        return this.horsePower;
    }

    public String getColor() {
        return this.color;
    }

    public int getContructionYear() {
        return this.contructionYear;
    }

    public BikeType.Type getType() {
        return type;
    }

    @Override
    public int compareTo(Bike o) {
        return this.contructionYear - o.contructionYear;
    }

}

//Alphabetische Sortierung nach dem Herstelle
class BikeBrandCompare implements Comparator<Bike> {
    @Override
    public int compare(Bike o1, Bike o2){

        String s1 = o1.getBrand();
        String s2 = o2.getBrand();
        int maxLength = 0;

        //checks length of strings
        if (s1.length() > s2.length()){
            maxLength = s2.length();
        }
        else {
            maxLength = s1.length();
        }

        //in for loop until chars aren't equal anymore
        for(int i = 0; i < maxLength; i++){

            if(s1.charAt(i) > s2.charAt(i)){
                return 1;
            }

            if(s1.charAt(i) < s2.charAt(i)){
                return -1;
            }

            if (s1.equals(s2)){
                return 0;
            }
        }

        //when both words are equal but s1 is longer than s2 -> s1 is bigger
        if (s1.length() > s2.length()){
            return 1;
        }
        else {
            return -1;
        }
    }
}

//Alphabetische Sortierung nach der Farbe
class BikeColorCompare implements Comparator<Bike>{
    @Override
    public int compare(Bike o1, Bike o2){
        return o1.getColor().compareTo(o2.getColor());
    }
}

//Absteigende Sortierung nach der Leistung des Motorrades
 class BikeHorsePowerCompare implements Comparator<Bike>{
    @Override
    public int compare(Bike o1, Bike o2){

        if (o1.getHorsePower() > o2.getHorsePower()){
            return -1;
        } else if (o1.getHorsePower() < o2.getHorsePower()) {
            return 1;
        }

        return 0;
    }
}

//Sortierung nach dem Typ (Reihenfolge: Street, Dirt, SMoto, Chopper)
class BikeTypeCompare implements Comparator<Bike> {
    @Override
    public int compare(Bike o1, Bike o2) {

        return o1.getType().compareTo(o2.getType());
    }
}



