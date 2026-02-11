package uz.akbarali.tayyorgarlik.feign;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.akbarali.tayyorgarlik.dto.UserRegisterDto;
import uz.akbarali.tayyorgarlik.models.User;
import uz.akbarali.tayyorgarlik.payload.ApiResponse;

@Service
@RequiredArgsConstructor
public class FeignService {
    private final UserFeignClient userFeignClient;

    public ApiResponse testCreateUser() {
        User user = new User();
        user.setFullName("Ali aka");
        return userFeignClient.saveUser(user);
    }

    public ApiResponse register() {
        int randomNum = (int) (Math.random() * 101);
        UserRegisterDto dto = UserRegisterDto.builder()
                .password("security")
                .username("akbarali" + randomNum)
                .build();
        return userFeignClient.register(dto);
    }

    public ApiResponse login(String username) {
        UserRegisterDto userRegisterDto = UserRegisterDto.builder().username(username).password("security").build();
        return userFeignClient.login(userRegisterDto);
    }


    public ApiResponse testGetUser(Long id) {
        return userFeignClient.getUserById(id);
    }
}
