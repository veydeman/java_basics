import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();
        findPlanesLeavingInTheNextTwoHours(airport).forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {

        Calendar time = Calendar.getInstance();
        time.setTime(new Date());
        Calendar timeAfter = Calendar.getInstance();
        timeAfter.setTime(new Date());
        timeAfter.add(Calendar.HOUR_OF_DAY, 2);
        ArrayList<Terminal> terminals = airport.getTerminals().stream().collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Flight> result = terminals.stream().flatMap(terminal -> terminal.getFlights().stream())
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Flight> nearestFlights = result.stream().filter(flight -> flight.getDate()
                        .after(time.getTime()) & flight.getDate().before(timeAfter.getTime())
                        & flight.getType().equals(Flight.Type.DEPARTURE))
                .collect(Collectors.toCollection(ArrayList::new));
        return nearestFlights;
    }
}