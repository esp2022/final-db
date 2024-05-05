/**
Copyright (c) 2024 Sami Menik, PhD. All rights reserved.

This is a project developed by Dr. Menik to give the students an opportunity to apply database concepts learned in the class in a real world project. Permission is granted to host a running version of this software and to use images or videos of this work solely for the purpose of demonstrating the work to potential employers. Any form of reproduction, distribution, or transmission of the software's source code, in part or whole, without the prior written consent of the copyright owner, is strictly prohibited.
*/
package uga.menik.cs4370.controllers;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.core.io.Resource;


import uga.menik.cs4370.services.UserService;

/**
 * This is the controler that handles /login URL.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    // UserService has user login and registration related functions.
    private final UserService userService;
    private final ResourceLoader resourceLoader;

    /**
     * See notes in AuthInterceptor.java regarding how this works 
     * through dependency injection and inversion of control.
     */
    @Autowired
    public LoginController(UserService userService, ResourceLoader resourceLoader) {
        this.userService = userService;
        this.resourceLoader = resourceLoader;

    }

    /**
     * This handles serving the login page at /login URL.
     * 
     * Note that this accepts a URL parameter called error.
     * The value to this parameter can be shown to the user as an error message.
     * See notes in HashtagSearchController.java regarding URL parameters.
     */
    @GetMapping
    public ResponseEntity<Resource> serveLoginPage(@RequestParam(name = "error", required = false) String error) {
        Resource resource = resourceLoader.getResource("classpath:/static/login_page.html");
        userService.unAuthenticate();
        return ResponseEntity.ok()
                .header("Content-Type", "text/html")
                .body(resource);
               

    }

    /**
     * This handles the /login form submission.
     * See notes in HomeController.java regardig /createpost form submission handler.
     */
    @PostMapping
    public String login(@RequestParam("username") String username,
            @RequestParam("password") String password) {
        boolean isAuthenticated = false;
        
        try {
            isAuthenticated = userService.authenticate(username, password);
        } catch (SQLException e) {
            // Redirect back to the login page with an error message if authentication
            // fails.
            String message = URLEncoder.encode("Authentication failed. Please try again.",
                    StandardCharsets.UTF_8);
            return "redirect:/login?error=" + message;
        }

        if (isAuthenticated) {
            // Redirect to home page if authentication is successful.
            return "redirect:/dashboard" + username;
        } else {
            // Redirect back to the login page with an error message if authentication
            // fails.
            String message = URLEncoder.encode("Invalid username or password. Please try again.",
                    StandardCharsets.UTF_8);
            return "redirect:/login?error=" + message;
        }
    }

}
