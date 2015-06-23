package by.ibragimov.heap.domain.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeapUserRepository extends JpaRepository<HeapUser, Long> {

    HeapUser getByEmail(String email);
}
