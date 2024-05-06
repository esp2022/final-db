package uga.menik.cs4370.services;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InboundOrderService {

    private final DataSource dataSource;
    private final UserService userService;

    @Autowired
    public InboundOrderService(DataSource dataSource, UserService userService) {
        this.dataSource = dataSource;
        this.userService = userService;
    }

    public String insertInboundOrder(String supplierId, String partnerId, String carrierId, String stockId,
            String stockQuantity, String etaDate, String awbTrackingnumber) throws SQLException {
        String orderNumber = "";

        // Get the user id
        String operatorId = this.userService.getLoggedInUser().getUserId();

        // Insert inbound order into the database
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO ReplenishmentOrder (ReceivedByid,CreatedByid, 3PLPartnerid, InboundCarrierid, ASNItemid, Quantity, ETADate, AirWayBillNumber, Status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, operatorId);
            pstmt.setString(2, supplierId);
            pstmt.setString(3, partnerId);
            pstmt.setString(4, carrierId);
            pstmt.setString(5, stockId);
            pstmt.setString(6, stockQuantity);
            pstmt.setString(7, etaDate);
            pstmt.setString(8, awbTrackingnumber);
            pstmt.setString(9, "OnOrder");
            pstmt.executeUpdate();

            // Get the order number
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                orderNumber = rs.getString(1);
            }

        }

        // Return the order number

        return orderNumber;
    }

    public String getReplenOrderStatus(String orderNumber) throws SQLException {

        String status = "";
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT Status FROM ReplenishmentOrder WHERE ASNorderid = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, orderNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                status = rs.getString("Status");
            }
        }

        return status;
    }

    public String updateReplenOrderStatusReceving(String orderNumber) throws SQLException {

        String status = "";
        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE ReplenishmentOrder SET Status = ? WHERE ASNorderid = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "ReceivedOk");
            pstmt.setString(2, orderNumber);
            pstmt.executeUpdate();
        }
        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT Status FROM ReplenishmentOrder WHERE ASNorderid = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, orderNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                status = rs.getString("Status");
            }
        }
        return status;
    }

    public String updateReplenOrderStatusPutAway(String orderNumber, String PutAwayAisle, String PutAwayBin)
            throws SQLException {

        String status = "";
        try (Connection connection = dataSource.getConnection()) {
            String sql = "UPDATE ReplenishmentOrder SET Status = ?, PutAwayAisle = ?, PutAwayBin = ? WHERE ASNorderid = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, "PutAway");
            pstmt.setString(2, PutAwayAisle);
            pstmt.setString(3, PutAwayBin);
            pstmt.setString(4, orderNumber);
            pstmt.executeUpdate();

        }

        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT Status FROM ReplenishmentOrder WHERE ASNorderid = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, orderNumber);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                status = rs.getString("Status");
            }
        }

        return status;
    }

}
