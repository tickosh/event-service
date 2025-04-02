package kz.tickosh.event.repository.event;

import kz.tickosh.event.model.event.EventInfoType;
import kz.tickosh.event.model.event.EventType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventInfoTypeRepository extends JpaRepository<EventInfoType, Long> {
    List<EventInfoType> findEventInfoTypeByEventType(EventType eventType);
}