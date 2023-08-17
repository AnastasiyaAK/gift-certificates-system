package by.akulich.gcs.repositories;

import by.akulich.gcs.entities.GiftCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface GiftCertificateRepository extends JpaRepository<GiftCertificate, Long> {
    @Query(value = "SELECT * FROM gift_certificate WHERE name=?", nativeQuery = true)
    GiftCertificate findByName(String name);
}
