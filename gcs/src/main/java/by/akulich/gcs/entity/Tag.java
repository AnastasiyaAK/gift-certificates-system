package by.akulich.gcs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tags")
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    @Column(length=120, nullable=false, unique=true)
    private String name;
    @ManyToMany(mappedBy = "tags")
    Set<GiftCertificate> giftCertificates;
}