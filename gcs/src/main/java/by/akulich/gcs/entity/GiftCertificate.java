package by.akulich.gcs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "gift_certificates")
@Data
public class GiftCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length=120, nullable=false, unique=true)
    private String name;

    @Column(nullable=false, unique=true)
    private String description;

    @Column(nullable=false)
    private BigDecimal price;

    @Column(nullable=false)
    private int duration;

    @Column(nullable=false, updatable=false)
    @CreatedDate
    private LocalDateTime createDate;

    @Column(nullable=false)
    @LastModifiedDate
    private LocalDateTime lastUpdateDate;

    @ManyToMany
    @JoinTable(
            name = "giftcertificate_tag",
            joinColumns = @JoinColumn(name = "gift_certificate_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @JsonBackReference
    private List<Tag> tags = new LinkedList<>();

}
