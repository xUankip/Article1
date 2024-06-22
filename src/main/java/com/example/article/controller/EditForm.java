package com.example.article.controller;

import com.example.article.entity.Article;
import com.example.article.repository.ArticleRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class EditForm implements Initializable {
    ArticleRepository articleRepository = new ArticleRepository();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Article> data = FXCollections.observableArrayList(articleRepository.edit());
    }
}
