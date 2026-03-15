package localhost.StockManager.controller;

import localhost.StockManager.dto.SalesDTO;
import localhost.StockManager.dto.SalesItemsDTO;
import localhost.StockManager.entity.Sales;
import localhost.StockManager.entity.Sales_items;
import localhost.StockManager.repository.ClientRepository;
import localhost.StockManager.repository.ProductRepository;
import localhost.StockManager.repository.SalesRepository;
import localhost.StockManager.repository.Sales_ItemsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SalesController {

    SalesRepository salesRepository;
    Sales_ItemsRepository sales_ItemsRepository;
    ClientRepository clientRepository;
    ProductRepository productRepository;


    public SalesController(SalesRepository salesRepository, Sales_ItemsRepository sales_ItemsRepository,  ClientRepository clientRepository,  ProductRepository productRepository) {
        this.salesRepository = salesRepository;
        this.sales_ItemsRepository = sales_ItemsRepository;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/sales")
    private ResponseEntity<List <Sales>> getSales() {

        return ResponseEntity.ok(salesRepository.findAll());
    }

    @PostMapping("/sales")
    private ResponseEntity<Sales> createSale(@RequestBody SalesDTO sale) {

        var client = clientRepository.findById(sale.clientId()).get();

        if (client == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }

        List <Sales_items> items = new ArrayList <>();
        var sales = new Sales();

        for (SalesItemsDTO salesItemsDTO : sale.salesItems()) {

            var product = productRepository.findById(salesItemsDTO.productId()).orElseThrow(
                    () -> new IllegalArgumentException("One of the products are inexistent!"));

            var item = new Sales_items();
            item.setPrice(salesItemsDTO.price());
            item.setQuantity(salesItemsDTO.quantity());
            item.setProduct_id(product);
            item.setSales_id(sales);

            items.add(item);
        }



        sales.setTotal_price(sale.price());
        sales.setClient(client);
        sales.setSales_items(items);

        salesRepository.save(sales);
        return ResponseEntity.ok().build();

    }

}
