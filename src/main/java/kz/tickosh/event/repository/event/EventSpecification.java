package kz.tickosh.event.repository.event;

import kz.tickosh.event.model.event.Event;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public interface EventSpecification {
    static Specification<Event> hasTypeId(Long typeId) {
        return (root, query, criteriaBuilder) ->
                typeId == null ? null : criteriaBuilder.equal(root.get("eventType").get("id"), typeId);
    }

    static Specification<Event> hasStartDateAfter(LocalDateTime startDate) {
        return (root, query, criteriaBuilder) ->
                startDate == null ? null : criteriaBuilder.greaterThanOrEqualTo(root.get("startDate"), startDate);
    }

    static Specification<Event> hasEndDateBefore(LocalDateTime endDate) {
        return (root, query, criteriaBuilder) ->
                endDate == null ? null : criteriaBuilder.lessThanOrEqualTo(root.get("endDate"), endDate);
    }

    static Specification<Event> hasSearchTerm(String search) {
        return (root, query, criteriaBuilder) ->
                search == null ? null : criteriaBuilder.like(root.get("name"), "%" + search + "%");
    }
}
