/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

/**
 *
 * @author Moya
 */
public class Product {
    
    private Integer id;
    private String name;
    private Double price;
    private String category;
    
    public Product(Integer id, String name, Double price, String category) {
        this.id = id;
        this.name = name;        
        this.price = price;
        this.category = category;
    }
    
    public Integer getID() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public Double getPrice(){
        return price;
    }
    
    public String getCategory(){
        return category;
    }

    public void setID(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public String toString(){
       return id + " - " + name + " - " + category + " | " + price + "zł"; 
    }
}
