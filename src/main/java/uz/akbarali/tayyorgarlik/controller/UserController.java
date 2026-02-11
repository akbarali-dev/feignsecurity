package uz.akbarali.tayyorgarlik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.akbarali.tayyorgarlik.models.User;
import uz.akbarali.tayyorgarlik.payload.ApiResponse;
import uz.akbarali.tayyorgarlik.services.UserServices;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    public HttpEntity<ApiResponse> answer(String message, boolean isSuccess, Object data, HttpStatus status) {
        return ResponseEntity.status(
                        status)
                .body(
                        new ApiResponse(
                                message,
                                isSuccess,
                                data
                        ));
    }
    @Autowired
    private UserServices userServices;

    @GetMapping
    public HttpEntity<ApiResponse> getAllUser(){
        List<User> users = userServices.getAllUsers();

        return answer("ok", true, users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HttpEntity<ApiResponse> getUserById(@PathVariable Long id){
        User user = userServices.findById(id);

        return answer("ok", true, user, HttpStatus.OK);
    }
    @PostMapping
    public HttpEntity<ApiResponse> saveUser(@RequestBody User user){
        User sUser = userServices.saveUser(user);

        return answer("ok", true, sUser, HttpStatus.OK);
    }

    @PutMapping
    public HttpEntity<ApiResponse> updateUser(@RequestBody User user){
        User sUser = userServices.updateUser(user);
        return answer("ok", true, sUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<ApiResponse> deleteUser(@PathVariable Long id){
        userServices.deleteUser(id);
        return answer("ok", true, null, HttpStatus.OK);
    }

}
