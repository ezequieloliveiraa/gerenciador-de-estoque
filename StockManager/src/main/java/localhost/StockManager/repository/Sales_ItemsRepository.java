package localhost.StockManager.repository;

import localhost.StockManager.entity.Sales_items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Sales_ItemsRepository extends JpaRepository<Sales_items, Long> {
}
