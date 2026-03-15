package localhost.StockManager.dto;
import java.util.List;

public record SalesDTO( Long clientId, Double price, List<SalesItemsDTO> salesItems) {
}
