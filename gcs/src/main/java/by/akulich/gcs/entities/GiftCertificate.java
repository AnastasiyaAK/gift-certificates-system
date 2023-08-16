package by.akulich.gcs.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gift_certificate")
@Getter
@Setter
public class GiftCertificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=120, nullable=false, unique=true)
    private String name;
    @Column(nullable=false, unique=true)
    private String description;
    @Column(nullable=false)
    private BigDecimal price;
    @Column(nullable=false)
    private int duration;
    @Column(name="create_date")
    private LocalDateTime createDate;
    @Column(name="last_update_date")
    private LocalDateTime lastUpdateDate;
    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "giftcertificate_tag",
            joinColumns = @JoinColumn(name = "gift_certificate_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    Set<Tag> tags = new HashSet<>();
}
