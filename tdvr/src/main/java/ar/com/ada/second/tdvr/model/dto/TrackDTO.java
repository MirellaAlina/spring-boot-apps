package ar.com.ada.second.tdvr.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class TrackDTO implements Serializable {
    private Long id;

    /**
     * @Pattern es la validacion con expresion regular, en este caso solo admite caracteres de la a-z A-Z,
     * espacios y numeros
     */
    @NotBlank(message = "is required")
    @Pattern(regexp = "^[0-9a-zA-ZáéíóúÁÉÍÓÚÜüñÑ\\s]*$", message = "title contains not allowed characters")
    private String title;

    @NotBlank(message = "is required")
    @Pattern(regexp = "^(?:[01]\\d|2[0123]):(?:[012345]\\d):(?:[012345]\\d)$", message = "wrong format, should be HH:MM:SS")
    private String trackDuration;

    @JsonIgnoreProperties( {"tracks"} )
    private AlbumDTO album;


    public Boolean hasNullOrEmptyAttributes() {
        return title == null || title.trim().isEmpty()
                || trackDuration.trim().isEmpty() || trackDuration == null;
    }
}
