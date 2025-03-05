package javaspring.crypto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepo extends JpaRepository<CryptoTable, String> {
    CryptoTable findBySymbol(String symbol);
}
