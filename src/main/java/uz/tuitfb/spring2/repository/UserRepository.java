package uz.tuitfb.spring2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tuitfb.spring2.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userUser);
}
