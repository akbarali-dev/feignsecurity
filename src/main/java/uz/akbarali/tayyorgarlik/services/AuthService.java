package uz.akbarali.tayyorgarlik.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.akbarali.tayyorgarlik.dto.UserRegisterDto;
import uz.akbarali.tayyorgarlik.models.User;
import uz.akbarali.tayyorgarlik.reposioty.UserRepository;
import uz.akbarali.tayyorgarlik.security.JwtUtil;

import java.net.Authenticator;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public String register(UserRegisterDto userDto) {
        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new RuntimeException("username already exception");
        }
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role("ROLE_USER")
                .build();
        userRepository.save(user);
        return jwtUtil.generateToken(user.getUsername());
    }

    public String login(UserRegisterDto userRegisterDto) {
        Authentication authenticator = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRegisterDto.getUsername(), userRegisterDto.getPassword()
                )
        );
        if(authenticator.isAuthenticated()){
            return jwtUtil.generateToken(userRegisterDto.getUsername());
        }
        throw new RuntimeException("invalid username or password");
    }
}
