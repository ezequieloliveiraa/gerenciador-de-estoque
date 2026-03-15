package localhost.StockManager.controller;

import jakarta.transaction.Transactional;
import localhost.StockManager.dto.ClientDto;
import localhost.StockManager.dto.ProductDto;
import localhost.StockManager.entity.Client;
import localhost.StockManager.entity.Product;
import localhost.StockManager.repository.ClientRepository;
import localhost.StockManager.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfAuthenticationStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ClientController {

    private final ClientRepository clientRepository;
    private final ProductRepository produtctRepository;

    public ClientController(ClientRepository clientRepository, ProductRepository produtctRepository) {
        this.clientRepository = clientRepository;
        this.produtctRepository = produtctRepository;
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> ListClients () {
        return ResponseEntity.ok(clientRepository.findAllClients().get());
    }

    @PostMapping("/clients")
    public ResponseEntity<Void> newClient (@RequestBody ClientDto clientDto) {

        var client = new Client();

        client.setName(clientDto.name());
        client.setEmail(clientDto.email());
        client.setPhone(clientDto.phone());
        client.setSpending(clientDto.spending());

        clientRepository.save(client);

        return ResponseEntity.ok().build();

    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Void> updateClient (@PathVariable Long id, @RequestBody ClientDto clientDto) {

        var client = clientRepository.findById(id);

        if (client.isEmpty() || client.get().getStatus() == Client.Status.DELETED) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }

        var newClient = new Client();
        newClient.setClientId(id);
        newClient.setName(clientDto.name());
        newClient.setEmail(clientDto.email());
        newClient.setPhone(clientDto.phone());
        newClient.setSpending(clientDto.spending());
        clientRepository.save(newClient);


        return ResponseEntity.ok().build();
    }

    @DeleteMapping("clients/{id}")
    public ResponseEntity<Void> deleteClient (@PathVariable Long id) {
        var client = clientRepository.findById(id);

        if (client.isEmpty() || client.get().getStatus() == Client.Status.DELETED) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }

        var deletedClient = client.get();
        deletedClient.setDeleted_at(Instant.now());
        deletedClient.setStatus(Client.Status.DELETED);
        clientRepository.save(deletedClient);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> ListProducts () {
        var products = produtctRepository.findAllProducts().get();

        return ResponseEntity.ok(products);
    }

    @PostMapping("/products")
    public ResponseEntity<Void> NewProduct (@RequestBody ProductDto productDto) {

        var product = new Product();

        product.setName(productDto.name());
        product.setPrice(productDto.price());
        product.setMinStock(productDto.minStock());
        product.setStock(productDto.stock());

        produtctRepository.save(product);

        return ResponseEntity.ok().build();

    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Void> updateProduct (@PathVariable Long id, @RequestBody ProductDto productDto) {

        var product = produtctRepository.findById(id);
        var newProduct = new Product();

        if (product.isEmpty() || product.get().getDeleted_at() != null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }

        newProduct.setProductId(id);
        newProduct.setName(productDto.name());
        newProduct.setPrice(productDto.price());
        newProduct.setMinStock(productDto.minStock());
        newProduct.setStock(productDto.stock());
        produtctRepository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct (@PathVariable Long id) {
        var product = produtctRepository.findById(id);

        if (product.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }

        var deletedProduct = product.get();
        deletedProduct.setDeleted_at(Instant.now());

        produtctRepository.save(deletedProduct);
        return ResponseEntity.ok().build();
    }
}
