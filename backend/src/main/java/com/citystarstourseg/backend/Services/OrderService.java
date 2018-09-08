package com.citystarstourseg.backend.Services;

import com.citystarstourseg.backend.DAOs.Order;
import com.citystarstourseg.backend.Database.OrderCRUD;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private OrderCRUD orderCRUD;

    // constructor for order retrieval
    public OrderService() {
        orderCRUD = new OrderCRUD();
    }

    public Order createOrder(Order order) throws SQLException{
        return orderCRUD.createRecords(order);
    }

    /**
     * Returns a list of orders in the database, or details of a specific order if orderID is provided
     * @param orderID if orderID == -1, method will return all orders in the database
     * @return
     */
    public List<Order> getOrders(String orderID) {
        try {
            if(orderID.equals("-1"))
                return orderCRUD.readRecords("");
            return orderCRUD.readRecords(orderID);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>(null);
        }
    }

    public int approveOrder(String orderID) {
        // todo
        return -1;
    }

}
