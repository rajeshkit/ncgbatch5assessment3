package org.eventbooking.main;

import org.eventbooking.exception.InvalidInputException;
import org.eventbooking.model.Event;
import org.eventbooking.service.EventService;
import java.util.*;

public class Main {
    public static void main(String [] args) throws InvalidInputException {
        Scanner sc = new Scanner(System.in);
        while(true) {
            clearScreen();
            printHeading();

            System.out.println("1. Start Booking");
            System.out.println("2. Exit");
            System.out.println("Your Choice:");

            int choice = sc.nextInt();
            if (choice == 1) {
                startBooking(sc);
                retryAgain(sc);
            } else if (choice == 2) {
                System.exit(0);
            } else {
                throw new InvalidInputException("Invalid input for starting the booking.");
            }
        }
    }

    public static void startBooking(Scanner sc) throws InvalidInputException {
        System.out.println("Available Events:");
        List<Event> events = printAndGetAllAvailableEvents();

        System.out.println("Enter Event Sno:");
        int userEventChoice = sc.nextInt();
        validateUserEventChoice(userEventChoice, events.size());

        System.out.println("Enter no.of tickets to book:");
        int noOfTicketsToBook = sc.nextInt();
        validateNoOfTicketsToBook(noOfTicketsToBook, events.get(userEventChoice - 1).getNoOfTicketsAvailable());

        printTotalCost(noOfTicketsToBook, events.get(userEventChoice - 1).getCostPerTicket());
        System.out.println("Proceed for the booking ?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        int bookingChoice = sc.nextInt();
        if (bookingChoice == 1) {
            bookEvent(events.get(userEventChoice - 1), noOfTicketsToBook);
        } else if(bookingChoice == 2) {
            System.out.println("Opting out from booking, Thanks !!!");
        } else {
            throw new InvalidInputException("Invalid choice for booking.");
        }
    }

    public static List<Event> printAndGetAllAvailableEvents() {
        EventService service = new EventService();
        List<Event> events = service.listAllEvents();
        for(int i = 0; i<events.size(); i++) {
            System.out.println((i + 1) + "." + events.get(i).toString());
        }
        return events;
    }

    public static void printTotalCost(int noOfTicketsToBook, int pricePerTicket) {
        System.out.println("Total price to book tickets: " + (noOfTicketsToBook * pricePerTicket));
    }

    public static void bookEvent(Event event, int noOfTicketsToBook) {
        EventService service = new EventService();
        int res = service.updateTicketCountInEvent(event, noOfTicketsToBook);
        if (res == 1) {
            System.out.println("Event Booking Successful !!!");
        } else {
            System.out.println("Event Booking Unsuccessful, please try again :(");
        }
    }

    public static void validateUserEventChoice(int choice, int actualSize) throws InvalidInputException {
        if (choice < 1 || choice > actualSize) {
            System.out.println("choice: " + choice + " size: " + actualSize);
            throw new InvalidInputException("Invalid Event Sno.");
        }
    }

    public static void validateNoOfTicketsToBook(int noOfTicketsToBook, int ticketsAvailable) throws InvalidInputException {
        if (noOfTicketsToBook < 1) {
            throw new InvalidInputException("No. of tickets to book must be greater than zero.");
        } else if (noOfTicketsToBook > ticketsAvailable) {
            throw new InvalidInputException("No.of tickets to book is greater than tickets available count.");
        }
    }

    public static void retryAgain(Scanner sc) {
        System.out.println("Enter any character to continue again: ");
        sc.next().charAt(0);
    }

    public static void clearScreen() {
        for(int i = 0; i<10; i++) {
            System.out.println();
        }
    }

    public static void printHeading() {
        System.out.println("  EventBookingSystem");
        System.out.println("-----------------------");
    }
}
