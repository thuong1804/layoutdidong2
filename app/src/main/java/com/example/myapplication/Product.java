package com.example.myapplication;

public class Product {
    String id, nameProduct, typeProduct, imgProduct, priceProduct,desProduct ;

    public Product() {
    }

    public Product(String id, String nameProduct, String typeProduct, String imgProduct, String priceProduct, String desProduct) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.typeProduct = typeProduct;
        this.imgProduct = imgProduct;
        this.priceProduct = priceProduct;
        this.desProduct = desProduct;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getImgProduct() {
        return imgProduct;
    }

    public void setImgProduct(String imgProduct) {
        this.imgProduct = imgProduct;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDesProduct() {
        return desProduct;
    }

    public void setDesProduct(String desProduct) {
        this.desProduct = desProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", typeProduct='" + typeProduct + '\'' +
                ", imgProduct='" + imgProduct + '\'' +
                ", priceProduct='" + priceProduct + '\'' +
                ", desProduct='" + desProduct + '\'' +
                '}';
    }
}
