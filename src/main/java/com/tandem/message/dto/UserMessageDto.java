package com.tandem.message.dto;

import org.junit.platform.commons.util.ToStringBuilder;
import java.util.List;

public class UserMessageDto {

    private int messageId;
    private String subject;
    private String content;
    private int fromId;
    private String fromName;
    private String fromEmail;
    private int threadId;
    private int threadOrder;
    private List < Integer > recipientId = null;
    private List < String > recipientName = null;
    private List < String > recipientEmail = null;
    private List < String > attachments = null;

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public int getThreadId() {
        return threadId;
    }

    public void setThreadId(int threadId) {
        this.threadId = threadId;
    }

    public int getThreadOrder() {
        return threadOrder;
    }

    public void setThreadOrder(int threadOrder) {
        this.threadOrder = threadOrder;
    }

    public List < Integer > getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(List < Integer > recipientId) {
        this.recipientId = recipientId;
    }

    public List < String > getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(List < String > recipientName) {
        this.recipientName = recipientName;
    }

    public List < String > getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(List < String > recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public List < String > getAttachments() {
        return attachments;
    }

    public void setAttachments(List < String > attachments) {
        this.attachments = attachments;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("messageId", messageId).append("subject", subject).append("content", content).append("fromId", fromId).append("fromName", fromName).append("fromEmail", fromEmail).append("threadId", threadId).append("threadOrder", threadOrder).append("recipientId", recipientId).append("recipientName", recipientName).append("recipientEmail", recipientEmail).append("attachments", attachments).toString();
    }
}
