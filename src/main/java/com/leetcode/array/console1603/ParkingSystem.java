package com.leetcode.array.console1603;

public class ParkingSystem {

    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big=big;
        this.medium=medium;
        this.small=small;
    }

    public boolean addCar(int carType) {
        switch (carType){
            case 1:
                if (big>0){
                    big--;
                    return true;
                }
                break;
            case 2:
                if (medium>0){
                    medium--;
                    return true;
                }
                break;
            case 3:
                if (small>0){
                    small--;
                    return true;
                }
                break;
        }
        return false;
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }
}
