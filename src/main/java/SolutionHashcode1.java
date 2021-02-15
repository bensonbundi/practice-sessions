import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class SolutionHashcode1 {
    class Pizza {
        private Set<String> ingredients = new HashSet<>();

        public Set<String> getIngredients() {
            return ingredients;
        }

        public void addIngredient(String ingredient) {
            this.ingredients.add(ingredient);
        }
    }
    static String inputFilesDirectory = "resources/"; // Location of input files
    static String outputFilesDirectory = "resources/"; // Location of output files


    public static void main(String[] args) {
        String[] inputs = new String[] {"resources/inputs/a_example.in",
                "resources/inputs/b_little_bit_of_everything.in",
                "resources/inputs/c_many_ingredients.in",
                "resources/inputs/d_many_pizzas.in",
                "resources/inputs/e_many_teams.in"};
//        for (int i = 0; i < inputs.length; ++i) {
//            pizzaDeliverer(inputs[i]);
//            break;
//        }

      //  pizzaDeliverer(args[1]);
        var result = new SolutionHashcode1();
        result.pizzaDeliverer("resources/inputs/a_example.in");
    }

    private void pizzaDeliverer(String fileName){
        // Read the input file by name
       // BufferedReader fr = new BufferedReader(new FileReader(inputFilesDirectory + fileName + ".in"));
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilesDirectory + fileName + ".in"))) {
            // read the first line from input file
            String[] firstLine = br.readLine().split(" ");

            int numOfPizza = Integer.parseInt(firstLine[0]);
            Pizza[] pizzas = new Pizza[numOfPizza];
            Arrays.fill(pizzas, new Pizza());

            int[] teamsCount = new int[]{
                    Integer.parseInt(firstLine[1]), // the num of team of 2
                    Integer.parseInt(firstLine[2]), // the num of team of 3
                    Integer.parseInt(firstLine[3])  // the num of team of 4
            };

            // save the ingredients of pizzas
            for (int i = 0; i < numOfPizza; ++i) {
                String[] pizzaLine = br.readLine().split(" ");
                for (int j = 0; j < Integer.parseInt(pizzaLine[0]); ++j) {
                    pizzas[i].addIngredient(pizzaLine[j+1]);
                }
            }

/*            // determine the size of delivered teams
            int smallestTeam = -1;
            for (int i = 0; i < 2; ++i) {
                if (teamsCount[i] > 0){
                    smallestTeam = i+2;
                    break;
                }
            }
            Queue<Team> deliveredTeams = new PriorityQueue<>();
            if (numOfPizza % 2 == 1 && teamsCount[1] > 0) {
                deliveredTeams.add(new Team(3));
                numOfPizza -= 3;
            }
            for (int i = 0; i < 3; ++i) {
                if (numOfPizza == 0) break;
                while (teamsCount[i] > 0 && numOfPizza - (i+2) >= 0)  {
                    deliveredTeams.add(new Team(i+2));
                    teamsCount[i]--;
                    numOfPizza -= (i+2);
                    System.out.println(numOfPizza);
                }
            }
            while (!deliveredTeams.isEmpty()) {
                System.out.println(deliveredTeams.poll().getSize());
            }*/

            // Print output data and create output file
//            try (PrintWriter output = new PrintWriter(outputFilesDirectory + fileName + ".out", "UTF-8")) {
//                output.println(outputList.size());
//                System.out.println(outputList.size());
//                for (Integer outputLine : outputList) {
//                    output.print(outputLine + " ");
//                    System.out.print(outputLine + " ");
//                }
//            }
//
//            System.out.println("");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
