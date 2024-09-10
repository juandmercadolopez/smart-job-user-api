package cl.bci.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String uuid;
    @NotNull(message = "The name is required")
    @NotEmpty(message = "The name cannot be empty")
    private String name;
    @NotNull(message = "the email is required")
    @NotEmpty(message = "email cannot be empty")
    @Email(message = "The email is not valid")
    private String email;
    @NotNull(message = "A password is required")
    @NotEmpty(message = "The password cannot be empty")
    private String password;

    @Valid
    //this is used to validate de object elements data in the list. This indicate @NotEmpty annotation below phone list check elements into the list
    @NotNull(message = "All phone data is required")
    private @NotEmpty List<PhoneModel> phones;
    @NotNull(message = "You must indicate if the user is active or not")
    private boolean isActive;

}
