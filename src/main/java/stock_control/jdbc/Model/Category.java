package stock_control.jdbc.Model;

public class Category {
    private Integer CategoryId;
    private String CategoryName;

    public Category(int CategoryId, String CategoryName) {
        this.CategoryId = CategoryId;
        this.CategoryName = CategoryName;
    }
}
