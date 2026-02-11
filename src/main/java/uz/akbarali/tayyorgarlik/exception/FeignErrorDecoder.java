package uz.akbarali.tayyorgarlik.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        if (response.status()==404){
            return new  UserNotFoundException(null);
        }
        if (response.status()==401){
            return new UserNotFoundException(null);
        }

        return new RuntimeException("Feign error: "+ response.status());
    }
}
