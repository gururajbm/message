package com.tandem.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tandem.message.repo.MessageRepository;
import com.tandem.message.entity.Message;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessages() {
        return messageRepository.getMessages();
    }
}
