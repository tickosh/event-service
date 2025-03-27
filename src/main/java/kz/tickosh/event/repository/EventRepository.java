package kz.tickosh.event.repository;

import kz.tickosh.event.enums.EventType;
import kz.tickosh.event.model.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findEventById(Long id);

    boolean existsById(Long id);

    Page<Event> findByEventType(Pageable pageable, EventType eventType);
}