package org.wcci.Spring.restControllers;



import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.Spring.repositories.PetRepo;
import org.wcci.services.PetService;

@RestController
public class PetRestController {
    public static final String LIST_ALL_NAMES = "listAllNames";
    public static final String LIST_ALL_HUNGERLEVELS = "listAllLevels";
    public static final String LIST_ALL_THIRSTLEVELS = "listAllThirstLevels";
    public static final String LIST_ALL_TRAININGLEVELS= "listAllTrainingLevels";
    public static final String LIST_ALL_BREEDS= "listAllBreeds";

    final private PetRepo messageRepo;
    final private PetService messageService;

    public PetRestController(@Autowired PetService service, @Autowired PetRepo petRepo) {
        this.PetService = service;
        this.PetRepo = PetRepo;
    }

    // Return all messages
    // curl -s http://localhost:8080/api/messages
    // This *reads* from the database and is the "R" in CRUD
    @GetMapping("/api/messages")
    public CollectionModel<EntityModel<Message>> getMessages() {
        List<EntityModel<Message>> messages = this.PetService.messageStream()
                .map(message -> EntityModel.of(message))
                .collect(Collectors.toList());
        return CollectionModel.of(messages);
    }

    // Return all names of messages
    // curl -s http://localhost:8080/api/messages/names
    @GetMapping("/api/messages/names")
    public CollectionModel<String> getAllNames() {
        List<String> names = this.PetService.messageStream()
                .map(Message::getName)
                .collect(Collectors.toList());
        return CollectionModel.of(names);
    }

    // Return all emails of messages
    // curl -s http://localhost:8080/api/messages/emails
    @GetMapping("/api/messages/emails")
    public CollectionModel<String> getAllEmails() {
        List<String> emails = this.PetService.messageStream()
                .map(Message::getEmail)
                .collect(Collectors.toList());
        return CollectionModel.of(emails);
    }

    // Return all message bodies
    // curl -s http://localhost:8080/api/messages/bodies
    @GetMapping("/api/messages/bodies")
    public CollectionModel<String> getAllMessageBodies() {
        List<String> bodies = this.PetService.messageStream()
                .map(Message::getMessageBody)
                .collect(Collectors.toList());
        return CollectionModel.of(bodies);
    }

    // Return one message
    // curl -s http://localhost:8080/api/messages/{messageID}
    // This *reads* from the database and is the "R" in CRUD
    @GetMapping("/api/messages/{messageID}")
    public EntityModel<Message> getMessage(@PathVariable final Long messageID) {
        final Message message = PetService.findMessage(messageID);
        return EntityModel.of(message,
                linkTo(methodOn(MessageRestController.class).getMessages()).withRel("LIST_ALL_MESSAGES"),
                linkTo(methodOn(MessageRestController.class).getAllEmails()).withRel("LIST_ALL_EMAILS"),
                linkTo(methodOn(MessageRestController.class).getMessage(messageID)).withSelfRel());
    }

    // Remove a student
    // curl -s -X DELETE http://localhost:8080/api/students/51
    // This *delete* a database record and is the "D" in CRUD
    @DeleteMapping("/api/messages/{messageID}")
    public void deleteMessage(@PathVariable long messageID) {
        messageService.deleteById(messageID);
    }

    public Message writeToDatabase(final Message message) {
        return this.messageRepo.save(message);
    }

    // Save a new message
    // This method handles the HTTP POST request to save a new message
    @PostMapping("/api/messages")
    public ResponseEntity<Message> saveMessage(@RequestBody Message message) {
        // Call the writeToDatabase method to save the message to the database
        Message savedMessage = writeToDatabase(message);
        return ResponseEntity.ok(savedMessage);
    }

}
