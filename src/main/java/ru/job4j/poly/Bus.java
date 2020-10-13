package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println("The bus goes from point a to point b");
    }

    @Override
    public void transportPassangers(int passangers) {
        int numberOfSeats = 45;
        numberOfSeats -= passangers;
    }

    @Override
    public int fullUpCar(int fuel) {
        int price = 0;
        price = 40 * fuel;
        return price;
    }
}
