package com.citystarstourseg.backend.Database;

import com.citystarstourseg.backend.DAOs.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderCRUD extends EntityCRUD<Order> {

    @Autowired
    private DatabaseConnection databaseConnection;
    @Override
    public Order createRecords(Order order) throws SQLException {

        String dataIntoBuses = "INSERT INTO ORDERS"
                + "(orderSerialNumber, requesterID, orderDate) VALUES"
                + "(?,?,?)";
        PreparedStatement preparedStatement = DatabaseConnection.connectToDatabase(dataIntoBuses);
        preparedStatement.setString(1, order.getSerialNumber());
        preparedStatement.setString(2, order.getRequesterID());
        preparedStatement.setDate(3, Date.valueOf(order.getOrderDate()));

        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating order failed, no rows affected.");
        }
        try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                order.setId(generatedKeys.getString(1));
            }
            else {
                throw new SQLException("Creating order failed, no ID obtained.");
            }
        }
        return order;
    }

    @Override
    public List<Order> readRecords(String orderID) throws SQLException {
        CRUDServices crudServices = new CRUDServices();
        ResultSet resultSet = crudServices.readDataFromDatabase(orderID, "orders", "orderID");
        resultSet.beforeFirst();
        List<Order> orders = new ArrayList<>();
        while(resultSet.next()){
            orders.add(new Order(resultSet.getString("orderID"),
                              resultSet.getString("orderSerialNumber"),
                              resultSet.getString("requesterID"),
                              resultSet.getString("requesterName"),
                              resultSet.getString("approverID"),
                              resultSet.getString("approverName"),
                              resultSet.getDate("orderDate").toLocalDate(),
                              resultSet.getBoolean("isApproved")

            ));
        }
        return orders;
    }

    @Override
    public int updateRecords(Order order) {
        // TODO: to be implemented
        return -1000;
    }

    @Override
    public int deleteRecords(Order order) {
        // TODO: to be implemented
        return -1000;
    }
}
