package model;

public class Article {
    private int id;
    private String name, imgName, price;

    public Article() {
        this("", "", "0.0");
    }

    public Article(String name, String imgName, String price) {
        this.name = name;
        this.imgName = imgName;
        this.price = price;
    }

    public String toString() {
        return name + "........" + price + " €";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
