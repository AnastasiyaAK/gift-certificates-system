package by.akulich.gcs.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name", length=120, nullable=false, unique=true)
    private String name;
    @Column(name="name", nullable=false, unique=true)
    private String description;
    @Column(name="name", nullable=false)
    private BigDecimal price;
    @Column(name="name", nullable=false)
    private int duration;
    @Column(name="create_date")
    private LocalDateTime createDate;
    @Column(name="last_update_date")
    private LocalDateTime lastUpdateDate;
    @ManyToMany
    @JoinTable(
            name = "giftcertificate_tag",
            joinColumns = @JoinColumn(name = "gift_certificate_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    Set<Tag> tags = new HashSet<>();
}
