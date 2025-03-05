package javaspring.crypto;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/crypto")
@AllArgsConstructor
public class CryptoController {

    @Autowired
    private CryptoRepo cryptoRepo;


    @GetMapping
    public List<CryptoTable> getCryptoPrices() {
        return cryptoRepo.findAll();
    }
}
