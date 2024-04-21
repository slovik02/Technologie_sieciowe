package ib.ts_2.repository;

import ib.ts_2.entity.Auth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends CrudRepository<Auth, Long> {
    Optional<Auth> findByUsername(String username);

}
