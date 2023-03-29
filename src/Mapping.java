import java.util.*;

public class Mapping {

    public static final int INITIAL_LOCATION = 95;

    /**
     * TODO
     * create a static LocationMap object
     */
    static LocationMap LM = new LocationMap();

    /**
     * TODO
     * create a vocabulary HashMap to store all directions a user can go
     */
    HashMap<String, String> vocabulary = new HashMap<String, String>();


    /**
     * TODO
     * create a FileLogger object
     */
    FileLogger FL = new FileLogger();

    /**
     * TODO
     * create a ConsoleLogger object
     */
    ConsoleLogger CL = new ConsoleLogger();


    public Mapping() {
        //vocabulary.put("QUIT", "Q"); //example
        /** TODO
         * complete the vocabulary HashMap <Key, Value> with all directions.
         * use the directions.txt file and crosscheck with the ExpectedInput and ExpectedOutput files to find the keys and the values
         */
        vocabulary.put("QUIT", "Q");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("NORTH", "N");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("UP", "U");
        vocabulary.put("DOWN", "D");
        vocabulary.put("SOUTHEAST", "SE");
        vocabulary.put("SOUTHWEST", "SW");
        vocabulary.put("NORTHEAST", "NE");
        vocabulary.put("NORTHWEST", "NW");
    }

    public void mapping() {

        /** TODO
         *create a Scanner object
         */
        Scanner sc = new Scanner(System.in);
        /**
         * initialise a location variable with the INITIAL_LOCATION
         */
        int where = INITIAL_LOCATION;


        while (true) {
            /** TODO
             * get the location and print its description to both console and file
             * use the FileLogger and ConsoleLogger objects
             */
            String getting = LM.get(where).getDescription();
            FL.log(getting);
            CL.log(getting);
            /** TODO
             * verify if the location is exit
             */
            if (where == 0) {
                break;
            }

            /** TODO
             * get a map of the exits for the location
             */
            Map<String, Integer> exit_map = LM.get(where).getExits();


            /** TODO
             * print the available exits (to both console and file)
             * crosscheck with the ExpectedOutput files
             * Hint: you can use a StringBuilder to append the exits
             */
            for (int i = 0; i < 1; i++) {
                StringBuilder sb = new StringBuilder();
                sb = sb.append(exit_map.keySet());
                String a = String.valueOf(sb.append(", "));
                a = a.replaceAll("\\[", "").replaceAll("\\]", "");
                FL.log("Available exits are " + a);
                CL.log("Available exits are " + a);
            }

            /** TODO
             * input a direction
             * ensure that the input is converted to uppercase
             */
            String input = sc.nextLine();
            input = input.toUpperCase();


            /** TODO
             * are we dealing with a letter / word for the direction to go to?
             * available inputs are: a letter(the HashMap value), a word (the HashMap key), a string of words that contains the key
             * crosscheck with the ExpectedInput and ExpectedOutput files for examples of inputs
             * if the input contains multiple words, extract each word
             * find the direction to go to using the vocabulary mapping
             * if multiple viable directions are specified in the input, choose the last one
             */
            String b = "";
            boolean f = true;
            if (vocabulary.containsKey(input)) {
                b = vocabulary.get(input);
                f = false;
            } else if (vocabulary.containsValue(input)) {
                b = input;
                f = false;
            } else {
                String[] s = input.split(" ");
                String c = "read";
                for (int i = 0; i < s.length; i++) {
                    if (vocabulary.containsKey(s[i])) {
                        c = s[i];
                    }
                }
                if (!Objects.equals(c, "read")) {
                    f = false;
                    b = vocabulary.get(c);
                }
            }
            if (f) {
                FL.log("You cannot go in that direction");
                CL.log("You cannot go in that direction");
            }
            /** TODO
             * if user can go in that direction, then set the location to that direction
             * otherwise print an error message (to both console and file)
             * check the ExpectedOutput files
             */
            else if (exit_map.containsKey(b)) {
                where = exit_map.get(b);
            } else {
                FL.log("You cannot go in that direction");
                CL.log("You cannot go in that direction");
            }
        }
    }

    public static void main(String[] args) {
        /**TODO
         * run the program from here
         * create a Mapping object
         * start the game
         */
        Mapping start = new Mapping();
        start.mapping();
    }

}
