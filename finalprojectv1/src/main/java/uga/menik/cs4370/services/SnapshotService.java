package uga.menik.cs4370.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uga.menik.cs4370.models.Snapshot;
import uga.menik.cs4370.models.Supplier;
import uga.menik.cs4370.models.Carrier;
import uga.menik.cs4370.models.Partner;
import uga.menik.cs4370.models.Stock;

@Service
public class SnapshotService {

    private final DataSource dataSource;

    @Autowired
    public SnapshotService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Snapshot getSnapshot() throws SQLException {
        

        // Carrier Table
        ArrayList<Carrier> carriers = new ArrayList<Carrier>();
        final String sql = "select * from Carrier";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Carrier carrier = new Carrier(rs.getString("Carrierid"), rs.getString("name"));
                carriers.add(carrier);
            }  
        }

        // Supplier Table
        ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
        final String sql2 = "select * from Supplier";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Supplier supplier = new Supplier(rs.getString("Vendorid"), rs.getString("company"));
                suppliers.add(supplier);
            }
        }

        // Partner Table
        ArrayList<Partner> partners = new ArrayList<Partner>();
        final String sql3 = "select * from Partner";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql3)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Partner partner = new Partner(rs.getString("Partnerid"), rs.getString("Partnername"));
                partners.add(partner);
            }
        }

        // Stock Table
        ArrayList<Stock> stocks = new ArrayList<Stock>();
        final String sql4 = "select * from Stock";
        try (Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql4)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Stock stock = new Stock(rs.getString("Itemid"), rs.getString("PartNumber"));
                stocks.add(stock);
            }
        }

        Snapshot snapshot = new Snapshot(carriers, partners, suppliers, stocks);   
        return snapshot;
    }

}
