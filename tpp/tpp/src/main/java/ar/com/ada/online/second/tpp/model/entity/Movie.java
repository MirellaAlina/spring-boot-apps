package ar.com.ada.online.second.tpp.model.entity;

import ar.com.ada.online.second.tpp.model.mapper.converter.YearAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Movie")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String posterURL;

    @Column(nullable = false, columnDefinition = "smallint")
    @Convert(converter = YearAttributeConverter.class)
    private Year released;

    @ManyToMany
    @JoinTable(
            name = "Actor_Actress_has_Movie",
            joinColumns = { @JoinColumn(
                    name = "Movie_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk_Actor_Actress_has_Movie_Movie"))
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "Actor_Actress_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(name = "fk_Actor_Actress_has_Movie_Actor_Actress"))
            }
    )
    private Set<ActorActress> actorsActresses;

}
