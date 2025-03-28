package kz.tickosh.event.controller;

import kz.tickosh.event.dto.response.EventDTO;
import kz.tickosh.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<Page<Object>> getEvents(@PageableDefault(size = 20) Pageable pageable,
                                                    @RequestParam(name = "type" , required = false) String type) {
        return ResponseEntity.ok(eventService.getEvents(pageable, type));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<EventDto> getEventById(@PathVariable Long id) {
//        return ResponseEntity.ok(eventService.getEventById(id));
//    }

//    @PostMapping
//    public ResponseEntity<Void> createEvent(@RequestBody EventDto event) {
//        eventService.createEvent(event);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> updateEvent(@PathVariable Long id, @RequestBody EventDto event) {
//        eventService.updateEvent(id, event);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
