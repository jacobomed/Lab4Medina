import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import main.Pizza;

public class Send {
    private final static String QUEUE_NAME = "pizza";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost"); // Specify the hostname or IP address of the RabbitMQ server
        factory.setPort(5672); // Specify the port number of the RabbitMQ server (default is 5672)

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            // Creating an instance of Pizza
            Pizza pizza = new Pizza("Medium", "1001", "Plain", "8.99");

            // Serialization: Converting the pizza object to JSON string
            ObjectMapper objectMapper = new ObjectMapper();
            String pizzaJson = objectMapper.writeValueAsString(pizza);

            // Send the JSON string over RabbitMQ
            channel.basicPublish("", QUEUE_NAME, null, pizzaJson.getBytes());
            System.out.println(" [x] Sent '" + pizzaJson + "'");
        }
    }
}
