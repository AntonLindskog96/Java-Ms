package javaspring.crypto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CryptoApplication implements CommandLineRunner {

    @Autowired
    private CryptoService cryptoService;

    public static void main(String[] args) {
        SpringApplication.run(CryptoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Fetch and save cryptocurrency prices
        cryptoService.fetchAndSaveCryptoPrices();

    }
}
