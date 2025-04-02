package kz.tickosh.event.controller;

import jakarta.validation.Valid;
import kz.tickosh.event.dto.request.CreateEventRequestDTO;
import kz.tickosh.event.dto.response.EventDTO;
import kz.tickosh.event.dto.response.EventDetailDTO;
import kz.tickosh.event.dto.response.EventInfoTypeDTO;
import kz.tickosh.event.dto.response.EventTypeDTO;
import kz.tickosh.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<Page<EventDTO>> getEvents(
            Pageable pageable,
            @RequestParam(required = false) Long typeId
    ) {
        return ResponseEntity.ok(eventService.getEvents(pageable, typeId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDetailDTO> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @GetMapping("/types")
    public ResponseEntity<List<EventTypeDTO>> getEventTypes() {
        return ResponseEntity.ok(eventService.getEventTypes());
    }

    @GetMapping("/info/types/{typeId}")
    public ResponseEntity<List<EventInfoTypeDTO>> getEventTypesInfo(@PathVariable Long typeId) {
        return ResponseEntity.ok(eventService.getEventTypesInfo(typeId));
    }

    @PostMapping
    public ResponseEntity<Void> createEvent(@Valid @RequestBody CreateEventRequestDTO event) {
        eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEvent(
            @PathVariable Long id,
            @Valid @RequestBody CreateEventRequestDTO event
    ) {
        eventService.updateEvent(id, event);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
