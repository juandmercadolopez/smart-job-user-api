package cl.bci.user.repository;

import cl.bci.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    void deleteByUuid(String uuid);

    User findByUuid(String uuid);
}
