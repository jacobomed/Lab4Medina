import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Pizza {
    private String size;
    private String id;
    private String toppings;
    private String price;

    // Default constructor (required for Jackson)

    public Pizza(String size, String id, String toppings, String price) {
        this.size = size;
        this.id = id;
        this.toppings = toppings;
        this.price = price;
    }

    // Getters and setters
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String  getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price){
        this.price = price;
    }

}