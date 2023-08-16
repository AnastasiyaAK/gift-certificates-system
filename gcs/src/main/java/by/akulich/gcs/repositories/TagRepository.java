package by.akulich.gcs.repositories;

import by.akulich.gcs.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query(value = "SELECT * FROM tag WHERE name=?", nativeQuery = true)
    Tag findByName(String name);
}
