package com.tandem.message.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message_attachment")
public class MessageAttachment {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="message_id")
    private Long messageId;

    @Column(name="file_name")
    private String fileName;


    public Long getId() {
    return id;
    }

    public void setId(Long id) {
    this.id = id;
    }

    public Long getMessage_id() {
    return messageId;
    }

    public void setMessage_id(Long messageId) {
    this.messageId = messageId;
    }

    public String getFile_name() {
    return fileName;
    }

    public void setFile_name(String fileName) {
    this.fileName = fileName;
    }
}
