package com.leelamohan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leelamohan.model.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {


    @Modifying
    @Query("SELECT t FROM Task t WHERE t.user_id = :userId")
    List<Task> findByUserId(@Param("userId") String userId);


    @Modifying
    @Query("UPDATE Task t SET t.completedDays = t.completedDays + 1 WHERE t.task_id = :taskId AND t.completedDays<21" )
    int incrementCompletedDays(@Param("taskId") Long taskId);

    @Modifying
    @Query("UPDATE Task t SET t.completedDays = t.completedDays - 1 WHERE t.task_id = :taskId AND t.completedDays > 0")
    int decrementCompletedDays(@Param("taskId") Long taskId);

    @Modifying
    @Query("UPDATE Task t SET t.completedDays = 0 WHERE t.task_id = :taskId")
    int resetCompletedDays(@Param("taskId") Long taskId);

    @Modifying
    @Query("UPDATE Task t SET t.task_name = :challenge ,t.task_description=:description  WHERE t.task_id = :taskId")
    void updateChallenge(@Param("taskId") Long taskId, @Param("challenge") String challenge, @Param("description") String description);

}
