import java.util.ArrayList;

public class Station {

    public String color;
    public String name;
    public Station previous = null;
    public Station next = null;
    public boolean inService = true;

    public Station (String color, String name ) {
        this.color = color;
        this.name = name;
    }

    public void addNext (Station newNext) {
        this.next = newNext;
        newNext.previous = this;
    }

    public void addPrev (Station newPrevious) {
        this.previous = newPrevious;
        newPrevious.next = this;
    }

    public void switchAvailable () {
        inService = !inService;
    }
    
    public boolean isAvailable () {
        return inService;
    }

    public void connect(Station nextStation) {
        this.next = nextStation;
        nextStation.previous = this;
    }

    public int tripLength(Station destination) {
        int distance = 0;
        Station start = this;
        ArrayList<Station> visitedStations = new ArrayList<>();

        return tripLengthRecursive(distance, start, destination, visitedStations);
    }

    private int tripLengthRecursive(int count, Station current, Station destination, ArrayList<Station> visitedStations) {
        if (current == null) {
            return -1;
        } else if (current.equals(destination)) {
            return count;
        } else if (visitedStations.contains(current)) {
            return -1;
        }
        visitedStations.add(current);

        int transferDistance = -1;

        if (current.next != null) {
            int distance = tripLengthRecursive(count + 1, current.next, destination, visitedStations);
            if (distance != -1) {
                transferDistance = distance;
            }
        }

        if (current instanceof TransferStation) {
            TransferStation transferRoute = (TransferStation) current;
            for (int i = 0; i < transferRoute.transferOptions.size(); i++) {
                Station transfer = transferRoute.transferOptions.get(i);
                int distance = tripLengthRecursive(count + 1, transfer, destination, visitedStations);
                if (distance != -1) {
                    transferDistance = distance;
                }
            }
        }

        return transferDistance;
    }

    public String toString () {
        String previousName = "none";
        if (previous != null) {
            previousName = previous.name;
        }
    
        String nextName = "none";
        if (next != null) {
            nextName = next.name;
        }
        return "STATION " + name + ": " + color + " line, in service: " + inService + ", previous station: " + previousName + ", next station: " + nextName;
    }

    public boolean equals(Station compare) {
        if (this.color.equals(compare.color) && this.name.equals(compare.name)) {
            return true;
        } else {
            return false;
        }
    }

}