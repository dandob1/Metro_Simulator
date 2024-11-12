import javax.swing.JOptionPane;
import java.util.ArrayList;

public class MetroSimulator {
    
    //Orange Line
    public static EndStation vienna;
    public static Station dunn_loring;
    public static Station west_falls_church;
    public static Station east_falls_church;
    public static Station ballston;
    public static Station virginia_square;
    public static Station clarendon;
    public static Station court_house;
    public static Station rosslyn;
    public static Station foggy_bottom;
    public static Station farragut_west;
    public static Station mcpherson_square;
    public static TransferStation metro_center;
    public static Station federal_triangle;
    public static Station smithsonian;
	public static TransferStation l_enfant_plaza;
    public static Station capitol_south;
    public static Station eastern_market;
    public static EndStation new_carrollton;

    //Red Line
    public static EndStation shady_grove;
    public static Station rockville;
    public static Station twinbrook;
    public static Station white_flint;
    public static Station grosvenor_strathmore;
    public static Station bethesda;
    public static Station medical_center;
    public static Station friendship_heights;
    public static Station tenleytown_au;
    public static Station van_ness_udc;
    public static Station cleveland_park;
    public static Station woodley_park;
    public static Station dupont_circle;
    public static Station farragut_north;
    //Metro Center above
    public static Station gallery_place;
    public static Station judiciary_square;
    public static Station union_station;
    public static Station rhode_island_ave;
    public static Station brookland_cua;
    public static Station fort_totten;
    public static Station takoma;
    public static Station silver_spring;
    public static EndStation glenmont;

    //Blue Line
    public static EndStation franconia_springfield;
    public static Station van_dorn_street;
    public static Station king_street;
    public static Station braddock_road;
    public static Station national_airport;
    public static Station crystal_city;
    public static Station pentagon_city;
    public static Station pentagon;
    //L'Enfant Plaza above
    public static Station federal_center_sw;
    public static Station capitol_south_blue;
    public static Station eastern_market_blue;
    public static EndStation largo_town_center;

    //list to hold all stations for easy access
    public static ArrayList<Station> allStations = new ArrayList<>();

    public static void main(String[] args){
        initialize();
        makeOrangeLine();
        makeRedLine();
        makeBlueLine();

        //collect all station names and create an array to store the names of all the stations
        String[] stationNames = new String[allStations.size()];

        //loop through the list of all stations and add their names to the array
        for (int i = 0; i < allStations.size(); i++) {
            stationNames[i] = allStations.get(i).name;
        }

        //ask user to select the start station
        String startName = (String) JOptionPane.showInputDialog(
            null,
            "Select Start Station:",
            "Start Station Selection",
            JOptionPane.QUESTION_MESSAGE,
            null,
            stationNames,
            stationNames[0]
        );

		//close out of pop up
        if (startName == null) {
            System.exit(0);
        }

        //ask user to select the end station
        String endName = (String) JOptionPane.showInputDialog(
            null,
            "Select End Station:",
            "End Station Selection",
            JOptionPane.QUESTION_MESSAGE,
            null,
            stationNames,
            stationNames[0]
        );

		//close out of pop up
		if (endName == null) {
            System.exit(0);
        }

        //retrieve the station based on names
        Station startStation = getStationByName(startName);
        Station endStation = getStationByName(endName);

        //calculate the number of stops
        int stops = startStation.tripLength(endStation);

        //display the result to the user
        if (stops != -1) {
            JOptionPane.showMessageDialog(
                null,
                "There are " + stops + " stops between " + startName + " and " + endName + ".",
                "Trip Information",
                JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                null,
                "No route found between " + startName + " and " + endName + ".",
                "Trip Information",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    //initialize all stations and add them to the allStations list
    public static void initialize(){
        //orange line stations
        vienna = new EndStation("orange", "Vienna");
        dunn_loring = new Station("orange", "Dunn Loring");
        west_falls_church = new Station("orange", "West Falls Church");
        east_falls_church = new Station("orange", "East Falls Church");
        ballston = new Station("orange", "Ballston");
        virginia_square = new Station("orange", "Virginia Square");
        clarendon = new Station("orange", "Clarendon");
        court_house = new Station("orange", "Court House");
        rosslyn = new Station("orange", "Rosslyn");
        foggy_bottom = new Station("orange", "Foggy Bottom");
        farragut_west = new Station("orange", "Farragut West");
        mcpherson_square = new Station("orange", "McPherson Square");
        metro_center = new TransferStation("orange/red/blue", "Metro Center");
        federal_triangle = new Station("orange", "Federal Triangle");
        smithsonian = new Station("orange", "Smithsonian");
		l_enfant_plaza = new TransferStation("orange/blue", "L'Enfant Plaza");
        capitol_south = new Station("orange", "Capitol South");
        eastern_market = new Station("orange", "Eastern Market");
        new_carrollton = new EndStation("orange", "New Carrollton");

        //red line stations
        shady_grove = new EndStation("red", "Shady Grove");
        rockville = new Station("red", "Rockville");
        twinbrook = new Station("red", "Twinbrook");
        white_flint = new Station("red", "White Flint");
        grosvenor_strathmore = new Station("red", "Grosvenor-Strathmore");
        bethesda = new Station("red", "Bethesda");
        medical_center = new Station("red", "Medical Center");
        friendship_heights = new Station("red", "Friendship Heights");
        tenleytown_au = new Station("red", "Tenleytown-AU");
        van_ness_udc = new Station("red", "Van Ness-UDC");
        cleveland_park = new Station("red", "Cleveland Park");
        woodley_park = new Station("red", "Woodley Park");
        dupont_circle = new Station("red", "Dupont Circle");
        farragut_north = new Station("red", "Farragut North");
        //Metro Center above
        gallery_place = new TransferStation("red/green", "Gallery Place");
        judiciary_square = new Station("red", "Judiciary Square");
        union_station = new Station("red", "Union Station");
        rhode_island_ave = new Station("red", "Rhode Island Ave");
        brookland_cua = new Station("red", "Brookland-CUA");
        fort_totten = new Station("red", "Fort Totten");
        takoma = new Station("red", "Takoma");
        silver_spring = new Station("red", "Silver Spring");
        glenmont = new EndStation("red", "Glenmont");

        //blue Line stations
        franconia_springfield = new EndStation("blue", "Franconia-Springfield");
        van_dorn_street = new Station("blue", "Van Dorn Street");
        king_street = new Station("blue", "King Street");
        braddock_road = new Station("blue", "Braddock Road");
        national_airport = new Station("blue", "National Airport");
        crystal_city = new Station("blue", "Crystal City");
        pentagon_city = new Station("blue", "Pentagon City");
        pentagon = new Station("blue", "Pentagon");
        //L'Enfant Plaza above
        federal_center_sw = new Station("blue", "Federal Center SW");
        capitol_south_blue = new Station("blue", "Capitol South");
        eastern_market_blue = new Station("blue", "Eastern Market");
        largo_town_center = new EndStation("blue", "Largo Town Center");

        //orange Line
        allStations.add(vienna);
        allStations.add(dunn_loring);
        allStations.add(west_falls_church);
        allStations.add(east_falls_church);
        allStations.add(ballston);
        allStations.add(virginia_square);
        allStations.add(clarendon);
        allStations.add(court_house);
        allStations.add(rosslyn);
        allStations.add(foggy_bottom);
        allStations.add(farragut_west);
        allStations.add(mcpherson_square);
        allStations.add(metro_center);
        allStations.add(federal_triangle);
        allStations.add(smithsonian);
        allStations.add(l_enfant_plaza);
        allStations.add(capitol_south);
        allStations.add(eastern_market);
        allStations.add(new_carrollton);

        //red Line
        allStations.add(shady_grove);
        allStations.add(rockville);
        allStations.add(twinbrook);
        allStations.add(white_flint);
        allStations.add(grosvenor_strathmore);
        allStations.add(bethesda);
        allStations.add(medical_center);
        allStations.add(friendship_heights);
        allStations.add(tenleytown_au);
        allStations.add(van_ness_udc);
        allStations.add(cleveland_park);
        allStations.add(woodley_park);
        allStations.add(dupont_circle);
        allStations.add(farragut_north);
        allStations.add(gallery_place);
        allStations.add(judiciary_square);
        allStations.add(union_station);
        allStations.add(rhode_island_ave);
        allStations.add(brookland_cua);
        allStations.add(fort_totten);
        allStations.add(takoma);
        allStations.add(silver_spring);
        allStations.add(glenmont);

        //blue Line
        allStations.add(franconia_springfield);
        allStations.add(van_dorn_street);
        allStations.add(king_street);
        allStations.add(braddock_road);
        allStations.add(national_airport);
        allStations.add(crystal_city);
        allStations.add(pentagon_city);
        allStations.add(pentagon);
        allStations.add(federal_center_sw);
        allStations.add(capitol_south_blue);
        allStations.add(eastern_market_blue);
        allStations.add(largo_town_center);
    }

    //connect the orange line stations
    public static EndStation makeOrangeLine(){
        vienna.connect(dunn_loring);
        dunn_loring.connect(west_falls_church);
        west_falls_church.connect(east_falls_church);
        east_falls_church.connect(ballston);
        ballston.connect(virginia_square);
        virginia_square.connect(clarendon);
        clarendon.connect(court_house);
        court_house.connect(rosslyn);
        rosslyn.connect(foggy_bottom);
        foggy_bottom.connect(farragut_west);
        farragut_west.connect(mcpherson_square);
        mcpherson_square.connect(metro_center);
        metro_center.connect(federal_triangle);
        federal_triangle.connect(smithsonian);
        smithsonian.connect(l_enfant_plaza);
        l_enfant_plaza.connect(capitol_south);
        capitol_south.connect(eastern_market);
        eastern_market.connect(new_carrollton);

        vienna.makeEnd();
        new_carrollton.makeEnd();

        return vienna;
    }

    //connect the red line stations
    public static EndStation makeRedLine(){
        shady_grove.connect(rockville);
        rockville.connect(twinbrook);
        twinbrook.connect(white_flint);
        white_flint.connect(grosvenor_strathmore);
        grosvenor_strathmore.connect(bethesda);
        bethesda.connect(medical_center);
        medical_center.connect(friendship_heights);
        friendship_heights.connect(tenleytown_au);
        tenleytown_au.connect(van_ness_udc);
        van_ness_udc.connect(cleveland_park);
        cleveland_park.connect(woodley_park);
        woodley_park.connect(dupont_circle);
        dupont_circle.connect(farragut_north);
        farragut_north.connect(metro_center);
        metro_center.connect(gallery_place);
        gallery_place.connect(judiciary_square);
        judiciary_square.connect(union_station);
        union_station.connect(rhode_island_ave);
        rhode_island_ave.connect(brookland_cua);
        brookland_cua.connect(fort_totten);
        fort_totten.connect(takoma);
        takoma.connect(silver_spring);
        silver_spring.connect(glenmont);

        shady_grove.makeEnd();
        glenmont.makeEnd();

        return shady_grove;
    }

    //connect the blue line stations
    public static EndStation makeBlueLine(){
        franconia_springfield.connect(van_dorn_street);
        van_dorn_street.connect(king_street);
        king_street.connect(braddock_road);
        braddock_road.connect(national_airport);
        national_airport.connect(crystal_city);
        crystal_city.connect(pentagon_city);
        pentagon_city.connect(pentagon);
        pentagon.connect(l_enfant_plaza);
        l_enfant_plaza.connect(federal_center_sw);
        federal_center_sw.connect(capitol_south_blue);
        capitol_south_blue.connect(eastern_market_blue);
        eastern_market_blue.connect(largo_town_center);

        franconia_springfield.makeEnd();
        largo_town_center.makeEnd();

        //transfer stations
        l_enfant_plaza.addTransferStationNext(smithsonian);
        metro_center.addTransferStationPrev(farragut_west);
        metro_center.addTransferStationPrev(farragut_north);

        return franconia_springfield;
    }

    //helper to retrieve a station by its name
    public static Station getStationByName(String name) {
		for (int i = 0; i < allStations.size(); i++) {
			Station station = allStations.get(i);
			
			if (station.name.equals(name)) {
				return station;
			}
		}
		
		return null;
	}
}
