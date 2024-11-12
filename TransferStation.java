import java.util.ArrayList;

public class TransferStation extends Station {
    ArrayList<Station> transferOptions = new ArrayList<>();
    ArrayList<Station> otherStations = new ArrayList<>();



    public TransferStation (String color, String name) {
        super (color, name);
    }

    public void addTransferStationNext (Station addStation) {
        addStation.previous = this;
        transferOptions.add(addStation);
        otherStations.add(addStation);
    }

    public void addTransferStationPrev (Station addStation) {
        addStation.next = this;
        transferOptions.add(addStation);
        otherStations.add(addStation);
    }

    public String toString () {

        String previousStation = "none";
        if (previous != null) {
            previousStation = previous.name;
        }

        String nextStation = "none";
        if (next != null) {
            nextStation = next.name;
        }
        String finalString = "TRANSFERSTATION " + name + ": " + color + " line, in service: " + inService + ", previous station: " + previousStation + ", next station: " + nextStation + "\n\tTransfers: \n"  ;

        for (int i = 0; i < transferOptions.size(); i++) {
            Station transfer = transferOptions.get(i);
            finalString += "\t" + transfer.toString() + "\n";
        }        


        return finalString;
    }

}