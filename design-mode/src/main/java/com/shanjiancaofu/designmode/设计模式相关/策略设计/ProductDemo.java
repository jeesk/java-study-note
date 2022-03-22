package com.shanjiancaofu.designmode.设计模式相关.策略设计;



import java.util.ArrayList;
import java.util.List;

public class ProductDemo {

    public void test() {

        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1000, "苹果手机"));
        productList.add(new Product(500, "小米手机"));
        // 赛选出大于600的手机
        //  策略模式就是根据不同的性质自定义不同的策略
        find(productList, product -> {
            return product.getPrice() > 600;
        });

    }

    public List<Product> find(List<Product> list, MyPridicate pridicate) {
        List<Product> productList = new ArrayList<>();
        productList.forEach(product -> {
            if (pridicate.test(product)) {
                productList.add(product);
            }
        });
        return productList;
    }

}

interface MyPridicate {
    boolean test(Product t);

}

class Product { // 商品类

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int price;
    String name;

    public Product(int price, String name) {
        this.price = price;
        this.name = name;
    }
}
