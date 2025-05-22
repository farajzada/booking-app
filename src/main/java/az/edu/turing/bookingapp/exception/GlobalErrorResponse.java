package az.edu.turing.bookingapp.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalErrorResponse {
    private UUID errorId;
    private String errorCode;
    private String errorMessage;
    private LocalDateTime timestamp;

}
