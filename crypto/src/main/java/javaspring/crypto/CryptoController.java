package javaspring.crypto;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/crypto")
@AllArgsConstructor
public class CryptoController {

    private final CryptoService cryptoService;

    @GetMapping
    public String getCryptoPrices() {
        return cryptoService.getCryptoPrices();
    }
}
