package main.java.product;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import main.java.exception.InvalidProductException;
import main.java.util.Constants;

public class ProductFactory {

    private static final Map<String, Supplier<IProduct>> products = new HashMap<>();

    static {
        products.put(Constants.COLA, Cola::new);
        products.put(Constants.CANDY, Candy::new);
        products.put(Constants.CHIPS, Chips::new);
    }

    public static IProduct getProduct(String productType) throws InvalidProductException {
        Supplier<IProduct> product = products.get(productType);

        if (product != null) {
            return product.get();
        }

        throw new InvalidProductException("Unknown product type.");
    }
}
