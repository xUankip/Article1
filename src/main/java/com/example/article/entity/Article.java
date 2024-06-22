package com.example.article.entity;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.CheckBox;

public class Article {
    private String id;
    private String title;
    private String description;
    private String content;
//    private CheckBox checkBox;
    private BooleanProperty selected;

    public Article(String id, String title, String description, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.selected = new SimpleBooleanProperty(false); // Initialize with false
    }

    // Getters and setters for other properties (id, title, description, content)

    public boolean isSelected() {
        return selected.get();
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected.set(selected);
    }

//    public Article(String id, String title, String description, String content) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.content = content;
//    }

//    public CheckBox getCheckBox() {
//        return checkBox;
//    }

//    public Article(String id, String title, String description, String content, CheckBox checkBox) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.content = content;
//        this.checkBox = checkBox;
//    }

//    public void setCheckBox(CheckBox checkBox) {
//        this.checkBox = checkBox;
//    }

    public Article() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
