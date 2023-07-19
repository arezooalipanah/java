package org.example.behavioral.memento;

public class Editor {
    private String content = "";
    private EditorMemento memento;

    public Editor() {
        this.memento = new EditorMemento("");
    }

    public void type(String words) {
        if (!this.content.isEmpty())
            this.content += " ";
        this.content += words;
    }

    public String getContent() {
        return this.content;
    }

    public void save() {
        memento = new EditorMemento(content);
    }

    public void restore() {
        content = memento.getContent();
    }
}
