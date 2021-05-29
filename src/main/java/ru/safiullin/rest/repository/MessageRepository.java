package ru.safiullin.rest.repository;

import org.springframework.data.repository.CrudRepository;
import ru.safiullin.rest.model.Message;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}
