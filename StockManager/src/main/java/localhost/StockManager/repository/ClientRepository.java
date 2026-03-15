package localhost.StockManager.repository;

import localhost.StockManager.entity.Client;
import localhost.StockManager.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {

    Optional <Client> findByName(String name);

    Optional <Client> findByEmail (String email);

    @Query(value = "SELECT c FROM Client c WHERE c.deleted_at IS NULL")
    Optional<List<Client>> findAllClients();
}
