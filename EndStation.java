public class EndStation extends Station{
    public EndStation (String color, String name) {
        super (color, name);
    }

    public void makeEnd () {
        if (previous == null && next != null) {
            previous = next;
        }
        else {
            next = previous;
        }
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
        return "ENDSTATION " + name + ": " + color + " line, in service: " + inService + ", previous station: " + previousStation + ", next station: " + nextStation;
    }


}