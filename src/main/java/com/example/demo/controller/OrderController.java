package com.example.demo.controller;

import com.example.demo.model.Items;
import com.example.demo.model.Orders;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class OrderController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(value = "/items")
    public List<Items> getItems() {
        return (List<Items>)itemRepository.findAll();
    }

    @GetMapping(value = "/orders")
    public List<Orders> getOrders() {
        return (List<Orders>)orderRepository.findAll();
    }

    @PostMapping(value = "/new/item")
    public ResponseEntity<?> newItem(@RequestBody Items item) {
        itemRepository.save(item);
        return ResponseEntity.ok("Saved item");
    }

    @PostMapping(value = "/new/order")
    public ResponseEntity<?> newItem(@RequestBody List<Orders> orders) {
        orders.forEach(order -> {
            orderRepository.save(order);
        });
        return ResponseEntity.ok("Saved order");
    }

    @DeleteMapping(value = "/remove/order/{id}")
    public ResponseEntity<?> newItem(@PathVariable int id) {
        orderRepository.deleteById(id);
        return ResponseEntity.ok("Deleted order");
    }
}