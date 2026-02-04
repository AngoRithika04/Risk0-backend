package com.portfolio.Risk0.repository;

import com.portfolio.Risk0.model.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
    List<UserCourse> findByUserId(Long userId);
    List<UserCourse> findByCourseId(Long courseId);
    Optional<UserCourse> findByUserIdAndCourseId(Long userId, Long courseId);
}
