package ar.com.ada.second.tdvr.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Track")
public class Track implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "track_duration", nullable = false)
    private String trackDuration;

    @ManyToOne
    @JoinColumn(name = "Album_id", nullable = false, foreignKey = @ForeignKey(name = "fk_Track_Album"))
    private Album album;
}
