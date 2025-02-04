package com.example.study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // 기본적인 CRUD 메서드는 JpaRepository에서 제공됩니다.
}