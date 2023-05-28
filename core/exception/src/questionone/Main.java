
package questionone;
import questionone.productservice.ProductService;
import questionone.productservice.InvalidProductException;

public class Main {
    public static void main(String[] args){
        try {
            ProductService.checkProductWeight(150L);
            ProductService.checkProductWeight(200L);
            ProductService.checkProductWeight(50L);
            ProductService.checkProductWeight(500L);
        } catch(InvalidProductException e){
            e.printStackTrace();
        }
    }
}