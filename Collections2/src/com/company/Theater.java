package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theater {
    //final variables don't go away
    // until they are intiialized with
    // a constructor
    private final String theaterName;
    private List<Seat> seats = new ArrayList<>();
    //remember that the List interface allows us
    //to use LinkedList or even ArrayList when
    //initializing
    //List can also be changed to Collection without
    //problems as shown above.
    //With Collection, now we can use any of the collection
    //classes to hold our seats
    //for more information on Collection
    //https://docs.oracle.com/javase/tutorial/collections/interfaces/index.html
    //based on the hierarchy in the link, you could change
    //LinkedList to HashSet, and it'll still work, though
    //the seats will be shown in a different order
    //if you want the same order, you can use LinkedHashSet
    //Now, something like TreeSet won't work because it's
    //below SortedSet in the hierarchy

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;
        //characters (or char) need single quotes
        // '  '
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                //%02d means "format the integer with 2 digits,
                //left padding it with zeroes"
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheaterName() {
        return theaterName;
    }

    public boolean reserveSeat(String seatNumber) {
        //Seat requestedSeat = null; - This was used
        //until we implemented Comparable, for which
        //case, we will now do the following code
        int low = 0;
        int high = seats.size() - 1;

        while (low <= high) {
            System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp<0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }

        System.out.println("There is no seat " + seatNumber);
        return false;

    }

    //The following block-commented and represents
    //the brute-force method
      /* Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        for(Seat seat : seats) {
            System.out.print(".");
            notice we did print instead of println
            otherwise, you'll have a lot of periods
            going down vertically!
            Now, what this is doing is essentially
            a brute force search
            it'll keep on adding periods, until
            the following if statement becomes true
            if(seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
               break;
            }
        }

      if(requestedSeat == null) {
           System.out.println("There is no seat " + seatNumber);
           return false;
       }
        return requestedSeat.reserve();
    }*/


    // for testing
    public void getSeats() {
        for(Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }
    //now, we're going to implement Comparable
    //so that instead of doing a brute force search
    //we can do a binary search, which is
    // exponentially quicker. EXPONENTIALLY
    //Cuts data in half by going to middle numbers
    //If one is greater, than the other half is
    //automatically thrown away. It continues in this way
    //Currently, you don't know much about algorithms
    //So, continue learning from MIT 6.042J and then eventually
    //MIT 6.006 Introduction to Algorithms
    //Java also has its own binary search code
    //(in the source code), which better illustrates
    //how binary searches work
    private class Seat implements Comparable<Seat> {
        //Remember, the lesson about generics
        //ctrl click comparable and you'll
        //notice Comparable<T>
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }
        //remember that you won't be able to implement
        //Comparable without overriding the compareTo Method
        @Override
        public int compareTo(Seat seat) {
            //the compareTo method is built into
            //the String class
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
            //the above line is a mouthful and kind of confusing at first glance
            //, but it's not. The only new thing here is the compareToIgnoreCase
            //but that function is obvious in the name.
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }






    }
















}
