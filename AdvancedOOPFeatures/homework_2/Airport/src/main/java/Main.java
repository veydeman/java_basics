import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        findPlanesLeavingInTheNextTwoHours(airport).forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        ArrayList<Terminal> terminals = airport.getTerminals().stream().collect(Collectors.
                toCollection(ArrayList::new));
        Date date = new Date();
        final long HOUR = 3600 * 1000;
        Date dateAfter = new Date(date.getTime() + 2 * HOUR);
        ArrayList<Flight> result = new ArrayList<Flight>();
        for (Terminal terminal : airport.getTerminals()){
            terminal.getFlights().forEach(flight -> result.add(flight));
        }
        ArrayList<Flight> nearestFlights = new ArrayList<Flight>();
        nearestFlights = result.stream().filter(flight -> flight.getDate().after(date) & flight.getDate()
                .before(dateAfter) & flight.getType().equals(Flight.Type.DEPARTURE))
                .collect(Collectors.toCollection(ArrayList::new));
        return nearestFlights;
    }

}