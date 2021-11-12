package app.model;

import app.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
    private static Model instance = new Model();

    private List<Product> model;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        model = new ArrayList<>();
    }

    public void add(Product product) {
        model.add(product);
    }

    public List<String> list() {
        return model.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

}
