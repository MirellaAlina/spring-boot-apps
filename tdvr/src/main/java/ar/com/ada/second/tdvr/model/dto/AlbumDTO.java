package ar.com.ada.second.tdvr.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class AlbumDTO implements Serializable {

    private Long id;

    @NotBlank(message = "is required")
    private String name;

    @NotNull(message = "is required")
    private Integer year;
}
