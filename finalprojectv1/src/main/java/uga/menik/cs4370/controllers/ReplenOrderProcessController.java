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
@RequestMapping("/replenorderprocess")
public class ReplenOrderProcessController {
    private final ResourceLoader resourceLoader;
    private final InboundOrderService inboundOrderService;

    @Autowired
    public ReplenOrderProcessController(ResourceLoader resourceLoader, InboundOrderService inboundOrderService) {
        this.resourceLoader = resourceLoader;
        this.inboundOrderService = inboundOrderService;
    }

    @GetMapping
    public ResponseEntity<Resource> getReplenOrderProcessPage(@RequestParam(name = "error", required = false) String error) {
        Resource resource = resourceLoader.getResource("classpath:/static/replenorderprocess_page.html");
        return ResponseEntity.ok()
                .header("Content-Type", "text/html")
                .body(resource);

    }

    @PostMapping("/status")
    @ResponseBody
    public String getReplenOrderStatus(@RequestParam("orderNumber") String orderNumber) throws UnsupportedEncodingException, SQLException {

        String status = this.inboundOrderService.getReplenOrderStatus(orderNumber);

        return status;
        
    }

    @PostMapping("/receive")
    @ResponseBody
    public String receiveReplenOrder(@RequestParam("orderNumber") String orderNumber) throws UnsupportedEncodingException, SQLException {

        String status = this.inboundOrderService.updateReplenOrderStatusReceving(orderNumber);

        return status;
    }

    @PostMapping("/putaway")
    @ResponseBody
    public String putawayReplenOrder(@RequestParam("orderNumber") String orderNumber, @RequestParam("putAwayAisle") String putAwayAisle , @RequestParam("putAwayBin") String putAwayBin ) throws UnsupportedEncodingException, SQLException {

        String status = this.inboundOrderService.updateReplenOrderStatusPutAway(orderNumber, putAwayAisle, putAwayBin);

        return status;
    }


}