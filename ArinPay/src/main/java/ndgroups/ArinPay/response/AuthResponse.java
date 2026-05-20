package ndgroups.ArinPay.response;

import lombok.Data;
import ndgroups.ArinPay.Enum.USER_ROLE;

@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private USER_ROLE role;

}