package mateo.proyect.tfg.exception;

import lombok.Getter;

@Getter
public class EntityIllegalArgumentException extends RuntimeException{

    private final String errorCode;

    public EntityIllegalArgumentException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }
}

