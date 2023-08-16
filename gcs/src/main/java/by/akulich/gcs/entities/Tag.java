package by.akulich.gcs.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tag")
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name", length=120, nullable=false, unique=true)
    private String name;
    @ManyToMany(mappedBy = "tag_id")
    Set<GiftCertificate> giftCertificates;
}
