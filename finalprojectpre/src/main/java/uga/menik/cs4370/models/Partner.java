package uga.menik.cs4370.models;

public class Partner {

    private String partnerId;
    private String partnerName;

    public Partner(String partnerId, String partnerName) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
    
}
