package main.exception;

import main.model.Product;

public class NotEnoughInStockException extends  Exception {

    private static final String message = "Not enough in stock";

    public NotEnoughInStockException(){
        super(message);
    }

    public NotEnoughInStockException(Product product) {
        super(String.format("Not enough %s in stock . %s left.",product.getName(),product.getQuantity()));
    }
}

