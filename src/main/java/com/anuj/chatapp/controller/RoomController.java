package com.anuj.chatapp.controller;
import com.anuj.chatapp.entities.Message;
import com.anuj.chatapp.entities.Room;
import com.anuj.chatapp.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

//    private RoomRepository roomRepository;

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId){

        if(roomService.findByRoomId(roomId) != null){
            return ResponseEntity.badRequest().body("Room already exists");
        }
        Room room = new Room();
        room.setRoomId(roomId);
        // Add default message
        Message defaultMessage = new Message("system", "Welcome to the room!");
        room.getMessages().add(defaultMessage);
        Room savedRoom = roomService.saveRoom(room);

        return ResponseEntity.ok(savedRoom);

    }

    //get room
    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId){
        Room room = roomService.findByRoomId(roomId);
        if(room == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Room not found");
        }
        return ResponseEntity.ok(room);
    }
    //get messages of room

    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessages(
            @PathVariable String roomId,
            @RequestParam(value = "page", defaultValue = "0",required = false) int page ,
            @RequestParam(value = "size", defaultValue = "10",required = false) int size
    )
    {
        Room room =  roomService.findByRoomId(roomId);

        if(room == null ){
            return ResponseEntity.badRequest().build();
        }
        List<Message> messages = room.getMessages();
        int start = Math.max(0,room.getMessages().size() - (page + 1) * size);
        int end = Math.min(room.getMessages().size(), start + size);
        List<Message> paginatedMessage = messages.subList(start,end);

        return ResponseEntity.ok(paginatedMessage);
    }



}
