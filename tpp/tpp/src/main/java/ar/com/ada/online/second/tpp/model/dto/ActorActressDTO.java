package ar.com.ada.online.second.tpp.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.Year;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class ActorActressDTO implements Serializable {

    private Long id;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^[0-9a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "title contains not allowed characters")
    private String fullName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "is required")
    @PastOrPresent(message = "the birthday must be past or present")
    private Date birthday;

    @NotBlank(message = "is required")
    private String gender;

    @NotNull(message = "is required")
    private String photoURL;

    public Boolean hasNullOrEmptyAttributes() {
        return fullName == null || fullName.trim().isEmpty()
                || birthday == null ||
                gender == null || gender.trim().isEmpty() ||
                photoURL == null || photoURL.trim().isEmpty();

    }

}
