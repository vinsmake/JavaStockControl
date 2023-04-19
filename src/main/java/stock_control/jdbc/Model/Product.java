package stock_control.jdbc.Model;

public class Product {
    private Integer ProductId;
    private String ProductName;
    private String ProductDescription;
    private Integer ProductAmount;

    public Product (String name, String description, Integer Amount) {
        this.ProductName = name;
        this.ProductDescription = description;
        this.ProductAmount = Amount;
    }


    public Integer getProductId() {
        return this.ProductId;
    }

    public void setProductId(Integer ProductId) {
        this.ProductId = ProductId;
    }

    public String getProductName() {
        return this.ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductDescription() {
        return this.ProductDescription;
    }

    public void setProductDescription(String ProductDescriptiom) {
        this.ProductDescription = ProductDescriptiom;
    }

    public Integer getProductAmount() {
        return this.ProductAmount;
    }

    public void setProductAmount(Integer ProductAmount) {
        this.ProductAmount = ProductAmount;
    }

    public Product (int id, String name, String description, int Amount) {
        this.ProductId = id;
        this.ProductName = name;
        this.ProductDescription = description;
        this.ProductAmount = Amount;
    }
    
    
}
