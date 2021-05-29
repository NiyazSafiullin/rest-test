package ru.safiullin.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.safiullin.rest.model.Message;
import ru.safiullin.rest.repository.MessageRepository;

import java.util.Map;

@RestController
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepository.findAll();

        model.put("messages", messages);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        try {
            Message message = new Message(text, tag);

            messageRepository.save(message);

            Iterable<Message> messages = messageRepository.findAll();

            model.put("messages", messages);

            return "main";
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Client Not Found", ex);
        }
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepository.findByTag(filter);
        } else {
            messages = messageRepository.findAll();
        }

        model.put("messages", messages);

        return "main";
    }

    @DeleteMapping("/remove/{id}")
    public String delete(@PathVariable Long id) {
        try {
            messageRepository.deleteById(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Actor Not Found", ex);
        }
        messageRepository.deleteById(id);
        return "main";
    }

}
