package javaspring.crypto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@Service
public class CryptoService {

    @Value("${CRYPTO_API_KEY}")
    private String apiUrl;

    @Autowired
    private CryptoRepo cryptoRepo;

    public void fetchAndSaveCryptoPrices() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(apiUrl, String.class);


        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootNode = objectMapper.readTree(response);

            Iterator<Map.Entry<String, JsonNode>> fields = rootNode.fields();
            while (fields.hasNext()) {
                Entry<String, JsonNode> field = fields.next();
                String symbol = field.getKey(); // Symbol of the cryptocurrency (e.g., bitcoin, ethereum)
                String name = symbol.substring(0, 1).toUpperCase() + symbol.substring(1); // Capitalize name
                double price = field.getValue().path("usd").asDouble(); // Extract USD price

                // Create and save the data for this cryptocurrency
                saveCryptoData(symbol.toUpperCase(), name, price);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper method to save crypto data
    private void saveCryptoData(String symbol, String name, double currentPrice) {
        CryptoTable crypto = new CryptoTable();
        crypto.setSymbol(symbol);
        crypto.setName(name);
        crypto.setCurrentPrice(currentPrice);

        // Save the data to the repository (which will store it in PostgreSQL)
        cryptoRepo.save(crypto);
    }

    // Method to print all crypto data saved in the DB
    public void printAllCryptoPrices() {
        Iterable<CryptoTable> cryptos = cryptoRepo.findAll();
        cryptos.forEach(crypto -> {
            System.out.println(crypto);
        });
    }
}
