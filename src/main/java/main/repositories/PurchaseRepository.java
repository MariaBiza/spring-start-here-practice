package main.repositories;

import main.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {
    private final JdbcTemplate jdbc;

    public PurchaseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase (product, price) VALUES (?, ?)";
        jdbc.update(sql, purchase.getProduct(), purchase.getPrice());
    }

    public List<Purchase> findAllPurchase() {
        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> purchaseRowMapper = (r, i) -> {
            Purchase rawPurchase = new Purchase();
            rawPurchase.setId(r.getInt("id"));
            rawPurchase.setProduct(r.getString("product"));
            rawPurchase.setPrice(r.getBigDecimal("price"));
            return rawPurchase;
        };
        return jdbc.query(sql, purchaseRowMapper);
    }
}
