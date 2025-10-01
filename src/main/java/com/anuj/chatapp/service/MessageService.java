package com.anuj.chatapp.service;

import com.anuj.chatapp.entities.Message;
import com.anuj.chatapp.entities.Room;
import com.anuj.chatapp.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private RoomRepository roomRepository;



}

