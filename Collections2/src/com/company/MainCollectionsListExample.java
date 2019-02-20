package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainCollectionsListExample {
    //the following MainCollectionsListExample
    // was created to show examples of
    //lists in Collections
    //Additionally, for example's sake,
    //the private list and the private class seats
    //need to be made public for the following
    //to work
    public static void main(String[] args) {

        Theater theater = new Theater("Olympian", 8, 12);
        List<Theater.Seat> seatCopy = new ArrayList<>(theater.seats);
        printList(seatCopy);
        //These aren't copied, hence the term "shallow copy"
        //Shallow copies refer to the same elements
        //but don't copy the same elements like a
        //"deep copy"

        seatCopy.get(1).reserve();
        if(theater.reserveSeat("A02")) {
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already reserved");
        }


        //Following created to show that yes, indeed,
        //seatCopy is a shallow copy
        //Also, the reverse can be swapped
        //with shuffle, which makes elements
        //pseudorandom
        Collections.reverse(seatCopy);
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printng theater.seat");
        printList(theater.seats);

        //More examples of Collections lists
        //Min and Max
        Theater.Seat minSeat = Collections.min(seatCopy);
        Theater.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        //for sortList(modified bubble sort)
        sortList(seatCopy);
        System.out.println("printng sorted seatCopy");
        printList(seatCopy);

    }

    public static void printList(List<Theater.Seat> list) {
        for(Theater.Seat seat: list) {
            System.out.println(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("===============================================================================================================================");
}

    //this (a modified bubble sort)
    // is much slower than Java's built-in
    //merge sort
    //but merge sort requires far more memory
    //than a bubble sort
    //rare to use your own sort method vs.
    //built-in Java sort methods in the
    //collections framework
    //Also, sortList method uses a generic
    //so that it can sort any kind of list of
    //theater seats so long as they implement
    //the comparable interface


    public static void sortList(List<? extends Theater.Seat> list) {
        for(int i=0; i<list.size(); i++) {
            for(int j=i+1; j<list.size(); j++) {
                if(list.get(i).compareTo(list.get(j)) > 0 {
                    Collections.swap(list, i, j);
                }
            }
        }
    }






}
