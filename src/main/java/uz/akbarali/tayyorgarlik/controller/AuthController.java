package uz.akbarali.tayyorgarlik.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.akbarali.tayyorgarlik.dto.UserRegisterDto;
import uz.akbarali.tayyorgarlik.payload.ApiResponse;
import uz.akbarali.tayyorgarlik.services.AuthService;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody UserRegisterDto user) {
        String token = authService.register(user);
        return ResponseEntity.ok(new ApiResponse("success", true, token)
                );
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody UserRegisterDto user) {
        String token = authService.login(user);
        return ResponseEntity.ok(new ApiResponse("success", true, token)
        );
    }
}
