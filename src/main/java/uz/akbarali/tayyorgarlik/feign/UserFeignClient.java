package uz.akbarali.tayyorgarlik.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import uz.akbarali.tayyorgarlik.config.FeignConfig;
import uz.akbarali.tayyorgarlik.dto.UserRegisterDto;
import uz.akbarali.tayyorgarlik.models.User;
import uz.akbarali.tayyorgarlik.payload.ApiResponse;

@FeignClient(name = "user-client", url = "http://localhost:8085", configuration = FeignConfig.class)
public interface UserFeignClient {
    @GetMapping("/api/user")
    ApiResponse getAllUser();

    @GetMapping("/api/user/{id}")
    ApiResponse getUserById(@PathVariable Long id);

    @PostMapping(value = "/api/user", consumes = "application/json")
    ApiResponse saveUser(@RequestBody User user);

    @PostMapping(value = "/auth/register", consumes = "application/json")
    ApiResponse register(@RequestBody UserRegisterDto user);

    @PostMapping(value = "/auth/login", consumes = "application/json")
    ApiResponse login(@RequestBody UserRegisterDto user);

    @PostMapping(value = "/api/user", consumes = "application/json")
    ApiResponse updateUser(@RequestBody User user);

    @DeleteMapping("/api/user/{id}")
    ApiResponse deleteUserById(@PathVariable Long id);
}
