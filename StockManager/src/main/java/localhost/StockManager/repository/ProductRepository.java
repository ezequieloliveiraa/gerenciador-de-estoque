package localhost.StockManager.repository;

import localhost.StockManager.dto.ProductDto;
import localhost.StockManager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<ProductDto> findByName(String name);

    @Query(value = "SELECT p FROM Product p WHERE p.deleted_at IS NULL")
    Optional<List<Product>> findAllProducts();

}
