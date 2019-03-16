import java.util.List;

/**
 * Created by rbhoompally on 1/4/18.
 */
public class Runner {
    public static void main(String[] args) {
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
//        reconstructItinerary.findItinerary(new String[][]{
//                {"JFK","SFO"},
//                {"JFK","ATL"},
//                {"SFO","ATL"},
//                {"ATL","JFK"},
//                {"ATL","SFO"}
//        });

//        reconstructItinerary.findItinerary(new String[][]{
//                {"MUC", "LHR"},
//                {"JFK", "MUC"},
//                {"SFO", "SJC"},
//                {"LHR", "SFO"}
//        });

        reconstructItinerary.findItinerary(new String[][]{
                {"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}
        });
    }
}
