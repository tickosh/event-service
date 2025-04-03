package kz.tickosh.event.repository.event;

import kz.tickosh.event.model.event.Event;
import kz.tickosh.event.model.event.EventType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event> {
    Optional<Event> findEventById(Long id);

    boolean existsById(Long id);

    Page<Event> findByEventType(Pageable pageable, EventType eventType);
}