package guru.springframework.springrestclient;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class RestTemplateExampleTests {

    public static final String API_ROOT = "https://api.predic8.de:443/shop";

    @Test
    public void getCategories() {
        String apiUrl = API_ROOT + "/categories/";
        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNode = restTemplate.getForObject(apiUrl, JsonNode.class);

        System.out.println("*** Categories ***");
        System.out.println(jsonNode + "\n");
    }

    @Test
    public void getProducts() {
        String apiUrl = API_ROOT + "/products/";
        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNode = restTemplate.getForObject(apiUrl, JsonNode.class);

        System.out.println("*** Products ***");
        System.out.println(jsonNode + "\n");
    }

    @Test
    public void getCustomers() {
        String apiUrl = API_ROOT + "/customers/";
        RestTemplate restTemplate = new RestTemplate();
        JsonNode jsonNode = restTemplate.getForObject(apiUrl, JsonNode.class);

        System.out.println("*** Customers ***");
        System.out.println(jsonNode + "\n");
    }

    @Test
    public void createCustomers() {
        String apiUrl = API_ROOT + "/customers/";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> customer = new HashMap<>();
        customer.put("firstname", "First Name Example");
        customer.put("lastname", "Last Name Example");

        JsonNode jsonNode = restTemplate.postForObject(apiUrl, customer, JsonNode.class);

        System.out.println("*** New Customer ***");
        System.out.println(jsonNode + "\n");
    }

    @Test
    public void updateCustomer() {
        String apiUrl = API_ROOT + "/customers/";
        RestTemplate restTemplate = new RestTemplate();

        Map<String , Object> customerData = new HashMap<>();
        customerData.put("firstname", "First Name Before Update");
        customerData.put("lastname", "Last Name Before Update");

        JsonNode jsonNode = restTemplate.postForObject(apiUrl, customerData, JsonNode.class);

        System.out.println("*** Update Customer ***");
        System.out.println("created customer");
        System.out.println(jsonNode);

        String customerUrl = jsonNode.get("customer_url").asText();
        String customerId = customerUrl.split("/")[3];
        String urlToUpdate = API_ROOT + "/customers/" + customerId;

        customerData.put("firstname", "First Name After Update");
        customerData.put("lastname", "Last Name After Update");

        restTemplate.put(urlToUpdate, customerData);
        jsonNode = restTemplate.getForObject(urlToUpdate, JsonNode.class);

        System.out.println("updated customer");
        System.out.println(jsonNode);
    }

    @Test(expected = HttpClientErrorException.class)
    public void deleteCustomer() {
        String apiUrl = API_ROOT + "/customers/";
        RestTemplate restTemplate = new RestTemplate();

        Map<String, Object> customerData = new HashMap<>();
        customerData.put("firstname", "first name to delete");
        customerData.put("lastname", "last name to delete");

        JsonNode jsonNode = restTemplate.postForObject(apiUrl, customerData, JsonNode.class);

        System.out.println("*** Delete Customer ***");
        System.out.println("created customer");
        System.out.println(jsonNode);

        String customerUrl = jsonNode.get("customer_url").asText();
        String customerId = customerUrl.split("/")[3];

        restTemplate.delete(apiUrl + customerId);

        jsonNode = restTemplate.getForObject(apiUrl + customerId, JsonNode.class);
        System.out.println(jsonNode);

    }
}
