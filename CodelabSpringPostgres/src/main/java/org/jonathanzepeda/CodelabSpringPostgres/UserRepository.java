package org.jonathanzepeda.CodelabSpringPostgres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
