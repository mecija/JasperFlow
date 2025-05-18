package mateo.proyect.tfg.exception;

import lombok.Getter;

@Getter
public class EntityAlreadyExistsException extends RuntimeException{

    private final String errorCode;

    public EntityAlreadyExistsException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

}
