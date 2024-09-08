package cl.bci.user.exception;

import org.springframework.validation.BindingResult;

public class InvalidArgumentException extends RuntimeException {

    private BindingResult result;

    public InvalidArgumentException(BindingResult result) {
        super();
        this.setResult(result);
    }

    public BindingResult getResult() {
        return result;
    }

    public void setResult(BindingResult result) {
        this.result = result;
    }
}
