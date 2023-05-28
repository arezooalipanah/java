package questionone.productservice;

public class ProductService {
    public static void checkProductWeight(long weight) throws InvalidProductException {
        if (weight < 100){
            throw new InvalidProductException();
        }
        System.out.println("weight is: " + weight);
    }
}
