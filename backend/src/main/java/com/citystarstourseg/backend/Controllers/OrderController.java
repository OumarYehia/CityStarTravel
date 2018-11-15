package com.citystarstourseg.backend.Controllers;

import com.citystarstourseg.backend.DAOs.Order;
import com.citystarstourseg.backend.Services.OrderService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    @RequestMapping("/createOrder")
    public Order createOrder(@RequestBody Order order)  throws SQLException, NoSuchAlgorithmException {
        orderService = new OrderService();
        return orderService.createOrder(order);
    }

    @RequestMapping("/getOrders")
    public List<Order> getOrders(@RequestParam(value="orderID", defaultValue="-1") String orderID)  {
        orderService = new OrderService();
        return orderService.getOrders(orderID);
    }

    @RequestMapping("/approveOrder")
    public int approveOrder(@RequestParam(value="orderID", defaultValue="-1") String orderID) {
        orderService = new OrderService();
        return orderService.approveOrder(orderID);
    }
}
