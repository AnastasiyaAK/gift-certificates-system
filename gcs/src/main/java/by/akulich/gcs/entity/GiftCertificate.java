package by.akulich.gcs.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "gift_certificates")
@Data
public class GiftCertificate {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(columnDefinition = "CHAR(32)")
    private String id;

    @Column(length=120, nullable=false, unique=true)
    private String name;

    @Column(nullable=false, unique=true)
    @Max(250)
    private String description;

    @Column(nullable=false)
    private BigDecimal price;

    @Column(nullable=false)
    private int duration;

    @CreatedDate
    @Column(nullable=false, updatable=false)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(nullable=false)
    private LocalDateTime lastUpdateDate;

    @ManyToMany
    @JoinTable(
            name = "giftcertificate_tag",
            joinColumns = @JoinColumn(name = "gift_certificate_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

}
