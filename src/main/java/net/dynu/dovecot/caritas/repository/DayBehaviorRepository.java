package net.dynu.dovecot.caritas.repository;

import net.dynu.dovecot.caritas.model.DayBehavior;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DayBehaviorRepository extends CrudRepository<DayBehavior, Integer>{

    @Query(value = "select * " +
            "from day_behavior " +
            "where id < :id " +
            "order by id desc limit :lastDays", nativeQuery = true)
    Optional<DayBehavior> getLastXDays(Integer id, int lastDays);
}
