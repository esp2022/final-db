package uga.menik.cs4370.models;

public class Supplier {

    private String supplierId;
    private String supplierName;
    
    public Supplier(String supplierId, String supplierName) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }
    
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

}
