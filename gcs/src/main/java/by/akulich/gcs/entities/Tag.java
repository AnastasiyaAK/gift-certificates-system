package by.akulich.gcs.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "tag")
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=120, nullable=false, unique=true)
    private String name;
    @ManyToMany(mappedBy = "tags")
    Set<GiftCertificate> giftCertificates;
}
