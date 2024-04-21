package ib.ts_2.repository;

import ib.ts_2.entity.Auth;
import ib.ts_2.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String user_name);
}
