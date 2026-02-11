package uz.akbarali.tayyorgarlik.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.akbarali.tayyorgarlik.payload.ApiResponse;

@RestController
@RequestMapping("/test")
public class FeignController {
    @Autowired
    FeignService feignService;

    @GetMapping
    public ApiResponse msg() {
        return feignService.testCreateUser();
    }

    @GetMapping("/register")
    public ApiResponse register() {
        return feignService.register();
    }

    @GetMapping("/login/{user}")
    public ApiResponse login(@PathVariable String user) {
        return feignService.login(user);
    }

    @GetMapping("/{id}")
    public ApiResponse getUserById(@PathVariable Long id) {
        return feignService.testGetUser(id);
    }
}
