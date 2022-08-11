package sample.vegetable;

import java.sql.Date;

public class VegetableError {

    private String productIDError;
    private String productNameError;
    private String imageError;
    private Float priceError;
    private int quantityError;
    private String categoryIDError;
    private Date importDateError;
    private Date usingDateError;

    public VegetableError() {
        this.productIDError = "";
        this.productNameError = "";
        this.imageError = "";
        this.categoryIDError = "";
    }

    public VegetableError(String productIDError, String productNameError, String imageError, Float priceError, int quantityError, String categoryIDError, Date importDateError, Date usingDateError) {
        this.productIDError = productIDError;
        this.productNameError = productNameError;
        this.imageError = imageError;
        this.priceError = priceError;
        this.quantityError = quantityError;
        this.categoryIDError = categoryIDError;
        this.importDateError = importDateError;
        this.usingDateError = usingDateError;
    }

    public String getProductIDError() {
        return productIDError;
    }

    public void setProductIDError(String productIDError) {
        this.productIDError = productIDError;
    }

    public String getProductNameError() {
        return productNameError;
    }

    public void setProductNameError(String productNameError) {
        this.productNameError = productNameError;
    }

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    public Float getPriceError() {
        return priceError;
    }

    public void setPriceError(Float priceError) {
        this.priceError = priceError;
    }

    public int getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(int quantityError) {
        this.quantityError = quantityError;
    }

    public String getCategoryIDError() {
        return categoryIDError;
    }

    public void setCategoryIDError(String categoryIDError) {
        this.categoryIDError = categoryIDError;
    }

    public Date getImportDateError() {
        return importDateError;
    }

    public void setImportDateError(Date importDateError) {
        this.importDateError = importDateError;
    }

    public Date getUsingDateError() {
        return usingDateError;
    }

    public void setUsingDateError(Date usingDateError) {
        this.usingDateError = usingDateError;
    }
    
    
}
