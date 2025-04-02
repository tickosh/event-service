package kz.tickosh.event.repository.event;

import kz.tickosh.event.model.event.EventInfoType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventInfoTypeRepository extends JpaRepository<EventInfoType, Long> {
}