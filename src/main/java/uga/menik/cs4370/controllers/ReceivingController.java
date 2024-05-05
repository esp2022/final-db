package uga.menik.cs4370.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/receiving")
public class ReceivingController {
    private final ResourceLoader resourceLoader;

    @Autowired
    public ReceivingController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping
    public ResponseEntity<Resource> serveLoginPage(@RequestParam(name = "error", required = false) String error) {
        Resource resource = resourceLoader.getResource("classpath:/static/receiving_page.html");
        return ResponseEntity.ok()
                .header("Content-Type", "text/html")
                .body(resource);

    }

}