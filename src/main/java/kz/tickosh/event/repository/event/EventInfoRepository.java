package kz.tickosh.event.repository.event;

import kz.tickosh.event.model.event.Event;
import kz.tickosh.event.model.event.EventInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventInfoRepository extends JpaRepository<EventInfo, Long> {
    List<EventInfo> findEventInfoByEvent(Event event);
    void deleteEventInfosByEvent(Event event);
}