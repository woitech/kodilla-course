package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.Validator;

public final class Task {
    private final String subject;
    private final String content;

    public Task(final String subject, final String content) {
        Validator.notBlank(subject, "blank subject");
        Validator.notBlank(content, "blank content");
        this.subject = subject;
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    String toFineString() {
        return "Subject: " + subject + '\n' +
               "Content: " + content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        if (!subject.equals(task.subject)) return false;
        return content.equals(task.content);
    }

    @Override
    public int hashCode() {
        int result = subject.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }
}
