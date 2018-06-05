package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Simulation {
    private ArrayList<Item> listOfItems = new ArrayList<>();

    private void loadItems(int i){
        File file = new File("C:/Users/David/IdeaProjects/Space Simulator/src/data/phase-" + i + ".txt");
        Scanner scanner;
        String[] currentLine;
        String itemName;
        int itemWeight;
        Item currentItem;

        {
            try {
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    currentLine = scanner.nextLine().split("[=]");
                    itemName = currentLine[0];
                    itemWeight = Integer.parseInt(currentLine[1]);
                    currentItem = new Item(itemName,itemWeight);
                    listOfItems.add(currentItem);
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private ArrayList<Rocket> loadU1(){
        ArrayList<Rocket> U1List = new ArrayList<>();
        U1 u1 = new U1();
        for (Item item : listOfItems) {
            if (u1.canCarry(item)){
                u1.carry(item);
            } else {
                U1List.add(u1);
                u1 = new U1();
                u1.carry(item);
            }

        }
        U1List.add(u1);
        return U1List;
    }
    private ArrayList<Rocket> loadU2(){
        ArrayList<Rocket> U2List = new ArrayList<>();
        U2 u2 = new U2();
        for (Item item : listOfItems) {
            if (u2.canCarry(item)){
                u2.carry(item);
            } else {
                U2List.add(u2);
                u2 = new U2();
                u2.carry(item);
            }

        }
        U2List.add(u2);
        return U2List;
    }

    String runSimulation(int phaseNumber){
        String rocketName;
        String returnString = "Phase " + phaseNumber + "\n";
        long rocketCost;
        this.loadItems(phaseNumber);
        ArrayList<Rocket> rocketList;

        for (int i = 0; i < 2; i++) {
            rocketCost = 0;
            if (i == 0) {
                rocketName = "U1";
                rocketList = this.loadU1();
            } else {
                rocketName = "U2";
                rocketList = this.loadU2();
            }
            for (Rocket rocket : rocketList) {
                while (rocket.launch()){
                    System.out.println("Crash!");
                    rocketCost += rocket.getCost();
                }
                while (rocket.land()){
                    System.out.println("Crash!");
                    rocketCost += rocket.getCost();
                }
                System.out.println("Success!");
                rocketCost += rocket.getCost();
            }
            returnString += rocketName + " " + rocketCost + "\n";
        }
        return returnString;
    }
}
