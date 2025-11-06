package com.ll.chatApp.domain.chat.chatMessage.entity;

import com.ll.chatApp.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Entity
@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
public class ChatMessage extends BaseEntity {

}