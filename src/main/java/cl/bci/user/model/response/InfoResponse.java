package cl.bci.user.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InfoResponse {

    private String id;
    private String created;
    private String modified;
    private String lastLogin;
    private String token;
    private boolean isActive;

}
