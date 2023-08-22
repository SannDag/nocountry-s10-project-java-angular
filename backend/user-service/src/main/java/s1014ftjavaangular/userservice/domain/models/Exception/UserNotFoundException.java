package s1014ftjavaangular.userservice.domain.models.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException (String message){
        super(message);
    }
}
