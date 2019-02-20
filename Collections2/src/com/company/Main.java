package com.company;

public class Main {

    public static void main(String[] args) {

        Theater theater = new Theater("Olympian", 8, 12);
        //theater.getSeats();
        //if you copy and past the following if-else statement
        //and run it, you'll get a message that the seat is taken
        if(theater.reserveSeat("H11")) {
            System.out.println("Please Pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

    }
}
