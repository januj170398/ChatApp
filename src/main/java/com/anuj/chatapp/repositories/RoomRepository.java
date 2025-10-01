package com.anuj.chatapp.repositories;

import com.anuj.chatapp.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface RoomRepository extends MongoRepository<Room, String> {
    Room findByRoomId(String roomId);


}
