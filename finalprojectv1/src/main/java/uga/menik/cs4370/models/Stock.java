package uga.menik.cs4370.models;

public class Stock {

    private String itemId;
    private String partNumber;

    public Stock(String itemId, String partNumber) {
        this.itemId = itemId;
        this.partNumber = partNumber;
    }

    public String getItemId() {
        return itemId;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }
}
