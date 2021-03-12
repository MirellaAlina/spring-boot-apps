package ar.com.ada.online.second.tpp.model.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.Year;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
public class MovieDTO implements Serializable {

    private Long id;

    @NotBlank(message = "is required")
    private String title;

    @NotBlank(message = "is required")
    private String description;

    @NotBlank(message = "is required")
    private String posterURL;

    @JsonFormat(pattern = "yyyy")
    @NotNull(message = "is required")
    @PastOrPresent(message = "the year must be past or present")
    private Year released;

    private List<ActorActressDTO> actors_Actresses;

    public Boolean hasNullOrEmptyAttributes() {
        return title == null || title.trim().isEmpty() ||
                description == null || description.trim().isEmpty() ||
                posterURL == null || posterURL.trim().isEmpty() ||
                released == null;
    }
}
