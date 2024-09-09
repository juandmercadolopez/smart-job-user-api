package cl.bci.user.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneModel {

    @NotNull(message = "The phone number is required")
    @NotEmpty(message = "The phone number cannot be empty")
    @Size(min = 10, max = 10, message = "The phone number must be 10 digits")
    private String number;
    @NotNull(message = "The city code is required")
    @NotEmpty(message = "The city code cannot be empty")
    @Size(min = 5, max = 5, message = "The city code must be 5 digits")
    private String cityCode;
    @NotNull(message = "The country code is required")
    @NotEmpty(message = "The country code cannot be empty")
    @Size(min = 3, max = 3, message = "The country code must be 3 digits")
    private String countryCode;

}
