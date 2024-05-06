package uga.menik.cs4370.models;

import java.util.ArrayList;

public class Snapshot {
    
    private ArrayList<Carrier> carriers;
    private ArrayList<Partner> partners;
    private ArrayList<Supplier> suppliers;
    private ArrayList<Stock> stocks;

    public Snapshot(ArrayList<Carrier> carriers, ArrayList<Partner> partners, ArrayList<Supplier> suppliers, ArrayList<Stock> stocks) {
        this.carriers = carriers;
        this.partners = partners;
        this.suppliers = suppliers;
        this.stocks = stocks;
    }

    public ArrayList<Carrier> getCarriers() {
        return carriers;
    }

    public ArrayList<Partner> getPartners() {
        return partners;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public void setCarriers(ArrayList<Carrier> carriers) {
        this.carriers = carriers;
    }

    public void setPartners(ArrayList<Partner> partners) {
        this.partners = partners;
    }

    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public void setStocks(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }

    public void addCarrier(Carrier carrier) {
        this.carriers.add(carrier);
    }

    public void addPartner(Partner partner) {
        this.partners.add(partner);
    }

    public void addSupplier(Supplier supplier) {
        this.suppliers.add(supplier);
    }

    public void addStock(Stock stock) {
        this.stocks.add(stock);
    }

    public void removeCarrier(Carrier carrier) {
        this.carriers.remove(carrier);
    }

    public void removePartner(Partner partner) {
        this.partners.remove(partner);
    }

    public void removeSupplier(Supplier supplier) {
        this.suppliers.remove(supplier);
    }

    public void removeStock(Stock stock) {
        this.stocks.remove(stock);
    }

}
