package com.anuj.chatapp.payload;

import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MessageRequest {
    private String content;
    private String sender;
    private Long roomId;
    private LocalDateTime messageTime;

}
