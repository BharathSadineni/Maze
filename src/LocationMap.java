import java.io.*;
import java.util.*;

//class that behaves like a map
public class LocationMap implements Map<Integer, Location> {

    private static final String LOCATIONS_FILE_NAME =  "locations.txt";
    private static final String DIRECTIONS_FILE_NAME =  "directions.txt";

    /** TODO
     * create a static locations HashMap
     */
    static HashMap<Integer, Location> locations_Map = new HashMap<Integer, Location>();
    {
        /** TODO
         * create a FileLogger object
         */FileLogger FL = new FileLogger();

        /** TODO
         * create a ConsoleLogger object
         */ ConsoleLogger CL = new ConsoleLogger();

        /** TODO
         * Read from LOCATIONS_FILE_NAME so that a user can navigate from one location to another
         * use try-with-resources/catch block for the FileReader
         * extract the location and the description on each line
         * print all locations and descriptions to both console and file
         * check the ExpectedOutput files
         * put the location and a new Location object in the locations HashMap, using temporary empty hashmaps for exits
         */
        String message_1 = "Available locations:";
        FL.log(message_1);
        System.out.println(message_1);
        String str;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(LOCATIONS_FILE_NAME));
            while ((str = reader.readLine()) != null){
                {String str_2 = str.replaceFirst("," ,": ");
                    String [] array_2 = str_2.split(": ",2);
                    if(array_2.length>=2) {
                        int key = Integer.parseInt(array_2[0]);
                        String value = array_2[1];
                        CL.log(str_2);
                        FL.log(str_2);
                        Location create = new Location(key,value, new HashMap<String, Integer>());
                        locations_Map.put(key,create);
                    }}}
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
        /**TODO
         * Read from DIRECTIONS_FILE_NAME so that a user can move from A to B, i.e. current location to next location
         * use try-with-resources/catch block for the FileReader
         * extract the 3 elements  on each line: location, direction, destination
         * print all locations, directions and destinations to both console and file
         * check the ExpectedOutput files
         * add the exits for each location
         */
        String message_2 = "Available directions:";
        FL.log(message_2);
        System.out.println(message_2);
        String newline;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(DIRECTIONS_FILE_NAME));
            while ((newline = reader.readLine()) != null){
                String [] array_3 = newline.split(",", 3);
                if(array_3.length >= 2)
                {String newline_2= newline.replace("," ,": ");
                    String [] array_4 = newline_2.split(": ",-2);
                    int key_2 = Integer.parseInt(array_4[0]);
                    String value_2 = array_4[1];
                    int key_3 = Integer.parseInt(array_4[2]);
                    CL.log(newline_2);
                    FL.log(newline_2);
                    locations_Map.get(key_2).addExit(value_2,key_3);
                }
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**TODO
     * implement all methods for Map
     * @return
     */
    @Override
    public int size() {
        //TODO
        return LocationMap.locations_Map.size();
    }

    @Override
    public boolean isEmpty() {
        //TODO
        return LocationMap.locations_Map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        //TODO
        return LocationMap.locations_Map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //TODO
        return LocationMap.locations_Map.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        //TODO
        return LocationMap.locations_Map.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        //TODO
        return LocationMap.locations_Map.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        //TODO
        return LocationMap.locations_Map.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {
        //TODO
    }

    @Override
    public void clear() {
        //TODO
    }

    @Override
    public Set<Integer> keySet() {
        //TODO
        return LocationMap.locations_Map.keySet();
    }

    @Override
    public Collection<Location> values() {
        //TODO
        return LocationMap.locations_Map.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        //TODO
        return LocationMap.locations_Map.entrySet();
    }
}
