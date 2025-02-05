package mingli.ppshop.dao;

import mingli.ppshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserDao extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
}
