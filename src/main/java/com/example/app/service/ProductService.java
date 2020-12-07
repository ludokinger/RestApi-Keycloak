package com.example.app.service;

import com.example.app.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@Service
public class ProductService {

    private static List<Product> list = new ArrayList<Product>(Arrays.asList(
            new Product("1", "DrecksSpringBoot", 1),
            new Product("2", "Baum",555),
            new Product("3", "Stock",2)));

    private static int counter = 0;
    public List<Product> getAllProducts() {
        return list;
    }

    public Product getProductById(String id) {
        Predicate<Product> byId = p -> p.getId().equals(id);
        return filterProducts(byId);
    }

    private Product filterProducts(Predicate<Product> strategy) {
        return getAllProducts().stream().filter(strategy).findFirst().orElse(null);
    }

    public Product addProduct(Product product) {
        list.add(product);
        return product;
    }

    public void deleteProduct(String id) {
        list.remove(getProductById(id));
    }

    public void putProductPrizeToZero(String id) {
        getProductById(id).setPrice(0);
    }

    private boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try
        {
            double d = Double.parseDouble(str);
        }
        catch (NumberFormatException nf)
        {
            return false;
        }
        return true;
    }

//    private String findFreeId() {
//        String result = "1";
//        for (Product product : list) {
//            Integer tmp = 1;
//            if (isNumeric(product.getId())) {
//                if (Integer.parseInt(product.getId()) >= tmp) {
//                    tmp = Integer.parseInt(product.getId());
//                }
//            }
//            result = tmp.toString();
//        }
//        return result;
//    }

}
