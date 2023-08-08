/*
 * Bike
 * Using Comparable and Comparator
 * Author:       Michael Muehlberger
 * Last Change:  23.03.2023
 */

import java.util.ArrayList;
import java.util.Collections;

public class Application {

    public static void printList(ArrayList<Bike> list){

        int entries = list.size();
        String brand = "";
        int horsePower = 0;
        int constructionYear = 0;
        BikeType.Type type = BikeType.Type.Dirt;
        String color = "";

        for(int i = 0; i < entries; i++){

            brand = list.get(i).getBrand();
            horsePower = list.get(i).getHorsePower();
            constructionYear = list.get(i).getContructionYear();
            type = list.get(i).getType();
            color = list.get(i).getColor();

            System.out.printf("Brand: " + brand + " | Horse Power: " + horsePower +
                    " | Contstruction Year: " + constructionYear +
                    " | Type: " + type + " | Color: " + color + "\n");

        }

    }

    public static void printSeparatorLine(){

        System.out.println();

        for(int i = 0; i < 55; i++){
            System.out.print("-");
        }

        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {

        ArrayList<Bike> bikeList = new ArrayList<Bike>();
        BikeBrandCompare bikeBrandCompare = new BikeBrandCompare();
        BikeColorCompare bikeColorCompare = new BikeColorCompare();
        BikeHorsePowerCompare bikeHorsePowerCompare = new BikeHorsePowerCompare();
        BikeTypeCompare bikeTypeCompare = new BikeTypeCompare();

        Bike bike1 = new Bike("KTM 1290 Duke R", 175, "orange", 2023, BikeType.Type.SMoto);
        Bike bike2 = new Bike("Yamaha MT07", 75, "blue", 2016, BikeType.Type.Street);
        Bike bike3 = new Bike("Susuki SV 650", 68, "white", 2021, BikeType.Type.Street);
        Bike bike4 = new Bike("Husqvarna 701", 48, "green", 2019, BikeType.Type.Dirt);
        Bike bike5 = new Bike("Harley Sportster S", 86, "black", 2015, BikeType.Type.Chopper);

        //adding Objects to List
        bikeList.add(bike1);
        bikeList.add(bike2);
        bikeList.add(bike3);
        bikeList.add(bike4);
        bikeList.add(bike5);

        //printing and sorting specific attributes
        System.out.println("Default bike list (not sorted)");
        printList(bikeList);
        printSeparatorLine();

        System.out.println("Sorted bike list by construction year");
        Collections.sort(bikeList);
        printList(bikeList);
        printSeparatorLine();

        System.out.println("Sorted bike list by name");
        Collections.sort(bikeList, bikeBrandCompare);
        printList(bikeList);
        printSeparatorLine();

        System.out.println("Sorted bike list by color");
        Collections.sort(bikeList, bikeColorCompare);
        printList(bikeList);
        printSeparatorLine();

        System.out.println("Sorted bike list by horsepower");
        Collections.sort(bikeList, bikeHorsePowerCompare);
        printList(bikeList);
        printSeparatorLine();

        System.out.println("Sorted bike list by type");
        Collections.sort(bikeList, bikeTypeCompare);
        printList(bikeList);
    }
}
