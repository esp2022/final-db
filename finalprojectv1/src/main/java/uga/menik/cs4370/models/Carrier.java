package uga.menik.cs4370.models;

public class Carrier {

    private String carrierId;
    private String carrierName;

    public Carrier(String carrierId, String carrierName) {
        this.carrierId = carrierId;
        this.carrierName = carrierName;
    }

    public String getCarrierId() {
        return carrierId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierId(String carrierId) {
        this.carrierId = carrierId;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }
    
}
