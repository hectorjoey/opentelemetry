package hector.test.opentel.response;

import lombok.*;

@Data
@Getter
@Setter
public class ApiResponse<T> {
    private int code;
    private String message;

    private T date;

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse(int code, String message, T date) {
        this.code = code;
        this.message = message;
        this.date = date;
    }
}
