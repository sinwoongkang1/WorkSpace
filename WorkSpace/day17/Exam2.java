package day17;

import java.util.Arrays;
import java.util.List;

public class Exam2 {
    public static void main(String[] args) {
        System.out.println("====================");
        System.out.println("실습 문제 5: 제품 카테고리별 평균 가격 계산");
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.00),
                new Product("Smartphone", "Electronics", 700.00),
                new Product("Desk", "Furniture", 300.00),
                new Product("Chair", "Furniture", 150.00)
        );
        //// 1. 반복문과 조건문을 이용한 풀이
        double priceSum1 = 0;
        double priceSum2 = 0;
        int productType1 = 0;
        int productType2 = 0;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getCategory()=="Electronics") {
               priceSum1= priceSum1+ products.get(i).getPrice();
                productType1++;
            }
            if (products.get(i).getCategory()=="Furniture") {
                priceSum2= priceSum2+ products.get(i).getPrice();
                productType2++;
            }
        }
        System.out.println("Electronics : " + priceSum1/productType1);
        System.out.println("Furniture : " + priceSum2/productType2);

        //2.스트림과 람다를 이용한 풀이
        double priceOfElectronics = products.stream().
                filter(category->category.getCategory().equals("Electronics")).
                mapToDouble(Product::getPrice).
                average().
                orElse(0.0);
        double priceOfFurniture = products.stream().
                filter(category->category.getCategory().equals("Furniture")).
                mapToDouble(Product::getPrice).
                average().
                orElse(0.0);
        System.out.println("Electronics : " + priceOfElectronics);
        System.out.println("Furniture : " + priceOfFurniture);


    }
}
class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}
