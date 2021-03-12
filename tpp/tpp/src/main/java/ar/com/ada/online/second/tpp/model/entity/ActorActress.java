package ar.com.ada.online.second.tpp.model.entity;

import ar.com.ada.online.second.tpp.model.mapper.converter.YearAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Year;
import java.util.Date;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "Actor_Actress")
public class ActorActress implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    @Column(nullable = false,length = 6)
    private String gender;

    @Column(nullable = false)
    private String photoURL;

    @ManyToMany(mappedBy = "actorsActresses")
    private Set<Movie> movies;
}
