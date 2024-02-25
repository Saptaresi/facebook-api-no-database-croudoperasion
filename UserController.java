
package com.organization.facebook.controller;

import org.springframework.web.bind.annotation.RestController;

import com.organization.facebook.entity.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/facebook")

public class UserController {
                                    // First Response api --->1
    /* 
     * 
     * 
     * 
     * 
     * 
    */
                                            
     private Map<Long, User> users = new HashMap<>(); // Storing users by their IDs

    @PostMapping("/users")
    public String createUser(@RequestBody User user) {
        users.put(user.getId(), user); // Store the user in the map
        return "User created successfully";
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return users.getOrDefault(id, null); // Retrieve user from map using ID
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        if (users.containsKey(id)) {
            users.put(id, user); // Update the user in the map
            return "User updated successfully.";
        } else {
            return "User not found.";
        }
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (users.containsKey(id)) {
            users.remove(id); // Delete the user from the map
            return "User deleted successfully.";
        } else {
            return "User not found.";
        }
    }
        
}



    // My Api no output response    -->2


    // private List<User> users = new ArrayList<User>();

    // @PostMapping("/users")
    // public String createUser(@RequestBody User user) {

    //     // Logic to create a user (not cunnected to a database
    //     return "User created successfully";
    // }

    // @GetMapping("/users/{id}")
    // public User getUser(@PathVariable Long id) {

    //     // Logic to retrive a user by ID (not connected to a database)
    //     return new User(id, "exampleUser", "user@example.com");
    // }

    // @PutMapping("/users/{id}")
    // public String updateUser(@PathVariable Long id, @RequestBody User user) {

    //     // Logic to update a user by ID (not connected to a database)
    //     return "User updated successfully.";
    // }

    // @DeleteMapping("/users/{id}")
    // public String deleteUser(@PathVariable Long id) {

    //     // Logic to delete a user by ID (not connected to a database)
    //     return "User deleted successfully.";
    // }

// }
