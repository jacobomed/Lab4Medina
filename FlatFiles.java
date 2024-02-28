import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FlatFiles {

    public static class Pizza {
        private String size;
        private String id;
        private String toppings;

        private String price;

        public Pizza(String size, String id, String toppings, String price) {
            this.size = size;
            this.id = id;
            this.toppings = toppings;
            this.price = price;
        }

        public String toFixedFormatString() {
            return String.format("%-10s%-10s%-20s", size, id, toppings, price);
        }

        public static Pizza fromFixedFormatString(String line) {
            String size = line.substring(0, 10).trim();
            String id = line.substring(10, 20).trim();
            String toppings = line.substring(20, 40).trim();
            String price = line.substring(40, 60);
            return new Pizza(size, id, toppings, price);
        }
    }

    public static void main(String[] args) {
        // Example data
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Medium", "1001", "Plain", "8.99"));
        pizzas.add(new Pizza("Large", "1002", "Pepperoni", "10.99"));

        // Write students to a flat file
        try (PrintWriter writer = new PrintWriter(new FileWriter("pizzas.txt"))) {
            for (Pizza pizza : pizzas) {
                writer.println(pizza.toFixedFormatString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read students from the flat file
        List<Pizza> loadedPizzas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("pizzas.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                loadedPizzas.add(Pizza.fromFixedFormatString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display loaded students
        for (Pizza pizza : loadedPizzas) {
            System.out.println("Size: " + pizza.size + ", ID: " + pizza.id + ", Toppings: " + pizza.toppings + ", Price" + pizza.price);
        }
    }
}