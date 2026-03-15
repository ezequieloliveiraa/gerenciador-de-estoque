package localhost.StockManager.dto;

public record ProductDto(String name, Long stock, Long minStock, Double price) {
}
