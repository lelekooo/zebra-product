package br.com.zebra.product.core.exception;

import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;

@Getter
public abstract class ProductException extends RuntimeException {
    private final List<String> reasons;
    private final OffsetDateTime timestamp = OffsetDateTime.now();

    public ProductException(String message, String reason) {
        super(message);
        this.reasons = Collections.unmodifiableList(Collections.singletonList(reason));
    }

    public ProductException(String message, List<String> reasons) {
        super(message);
        this.reasons = Collections.unmodifiableList(reasons);
    }

    public ProductException(String message, Throwable cause, String reason) {
        super(message, cause);
        this.reasons = Collections.unmodifiableList(Collections.singletonList(reason));
    }

    public ProductException(String message, Throwable cause, List<String> reasons) {
        super(message, cause);
        this.reasons = Collections.unmodifiableList(reasons);
    }

    public String getMessage() {
        return super.getMessage();
    }
}