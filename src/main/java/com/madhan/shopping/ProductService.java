package com.madhan.shopping;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    List<ProductResponse> productList = new ArrayList<>();

    public Optional<ProductResponse> getProductByName(String productName) {

        Optional<ProductResponse> optionalProductResponse = productList.stream()
                .filter(product -> product.getName().equalsIgnoreCase(productName))
                .findFirst();

        return optionalProductResponse;
    }

    public List<ProductResponse> getProductsByCategory(String category) {

        List<ProductResponse> productResponses = productList.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());

        return productResponses;

       /* List<ProductResponse> finalOutput = new ArrayList<>();
        for(ProductResponse product: productList) {
            if(product.getCategory().equalsIgnoreCase(category)) {
                finalOutput.add(product);
            }
        }
        return finalOutput;*/
    }

    @PostConstruct
    void prepareProducts() {
        System.out.println("Preparing Products");

        ProductResponse p1 = new ProductResponse();
        p1.setId(1);
        p1.setName("HP 15S");
        p1.setCategory("Laptop");
        p1.setDesc("HPs finest & thinnest laptop ever");
        p1.setPrice(42500d);

        ProductResponse p2 = new ProductResponse();
        p2.setId(2);
        p2.setName("Lenovo Thinkpad");
        p2.setCategory("Laptop");
        p2.setDesc("Lenovos finest & thinnest laptop ever");
        p2.setPrice(53000d);

        ProductResponse p3 = new ProductResponse();
        p3.setId(3);
        p3.setName("Lenovo Thinkpad Pro");
        p3.setCategory("Laptop");
        p3.setDesc("Lenovos finest laptop ever");
        p3.setPrice(65000d);

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);

        System.out.println("Product preparation completed");
    }
}
