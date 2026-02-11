package uz.akbarali.tayyorgarlik.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    private Long id;

    public UserNotFoundException(Long id) {
        super("User not found");
        this.id = id;
    }

}
