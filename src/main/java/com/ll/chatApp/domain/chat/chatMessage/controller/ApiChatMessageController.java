package com.ll.chatApp.domain.chat.chatMessage.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class ApiChatMessageController {
    @GetMapping("/api/v1/chat/rooms/{roomId}/messages")
    public String getChatMessages(@PathVariable("roomId") Long roomId,
                                  @RequestParam(value = "afterChatMessageId", defaultValue = "-1") long afterChatMessageId) {
        return roomId + "번 채팅방 메세지 목록 조회 완료 : id : " + afterChatMessageId;
    }

    @PostMapping("/api/v1/chat/rooms/{roomId}/messages")
    public String createChatMessages(@PathVariable("roomId") Long roomId) {
        return roomId + "번 채팅방 메세지 생성 완료";
    }
}
