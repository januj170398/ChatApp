package com.anuj.chatapp.service;

import com.anuj.chatapp.entities.Room;
import com.anuj.chatapp.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room findByRoomId(String roomId) {
        return roomRepository.findByRoomId(roomId);
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(String roomId) {
        Room room = roomRepository.findByRoomId(roomId);
        if (room != null) {
            roomRepository.delete(room);
        }
    }
}

