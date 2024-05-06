package uga.menik.cs4370.controllers;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import uga.menik.cs4370.services.InboundOrderService;

@Controller
@RequestMapping("/replenordercreate")
public class ReplenOrderCreateController {
    private final ResourceLoader resourceLoader;
    private final InboundOrderService inboundOrderService;

    @Autowired
    public ReplenOrderCreateController(ResourceLoader resourceLoader, InboundOrderService inboundOrderService) {
        this.resourceLoader = resourceLoader;
        this.inboundOrderService = inboundOrderService;
    }

    @GetMapping
    public ResponseEntity<Resource> getOrderCreatePage(@RequestParam(name = "error", required = false) String error) {
        Resource resource = resourceLoader.getResource("classpath:/static/replenordercreate_page.html");
        return ResponseEntity.ok()
                .header("Content-Type", "text/html")
                .body(resource);

    }

    @PostMapping
    @ResponseBody
    public String createOrder(@RequestParam("supplier") String supplierId,
            @RequestParam("partner") String partnerId,
            @RequestParam("carrier") String carrierId,
            @RequestParam("item") String stockId,
            @RequestParam("quantity") String stockQuantity,
            @RequestParam("date") String etaDate,
            @RequestParam("awb") String awbTrackingnumber) throws UnsupportedEncodingException, SQLException {

        String OrderNumber;

        // Add inbound order to the database
        OrderNumber = this.inboundOrderService.insertInboundOrder(supplierId, partnerId, carrierId, stockId,
                stockQuantity, etaDate, awbTrackingnumber);

        return OrderNumber;
    }
}
