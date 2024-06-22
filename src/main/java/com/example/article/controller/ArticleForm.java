package com.example.article.controller;

import com.example.article.entity.Article;
import com.example.article.repository.ArticleRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ArticleForm {
    public TextField txtTitle;
    public TextField txtDescription;
    public TextField txtContent;
    public TableColumn<Article, Boolean> checkBox;
    @FXML
    private TableView<Article> tableView;
    @FXML
    private TableColumn<Article, Integer> txtId;
    @FXML
    private TableColumn<Article, String > txtTitleView;
    @FXML
    private TableColumn<Article, String> txtDescriptionView;
    @FXML
    private TableColumn<Article, String> txtContentView;
    private ObservableList<Article> articlesList;
    ArticleRepository articleRepository = new ArticleRepository();
    public void tableLoad(ActionEvent actionEvent) {
        try {

            ArrayList<Article> arrayList = articleRepository.findAll();
            articlesList = FXCollections.observableArrayList(arrayList);
            txtId.setCellValueFactory(new PropertyValueFactory<Article, Integer>("id"));
            txtTitleView.setCellValueFactory(new PropertyValueFactory<Article, String>("title"));
            txtDescriptionView.setCellValueFactory(new PropertyValueFactory<Article, String>("description"));
            txtContentView.setCellValueFactory(new PropertyValueFactory<Article, String>("content"));
            checkBox.setCellValueFactory(cellData -> cellData.getValue().selectedProperty());
            checkBox.setCellFactory(CheckBoxTableCell.forTableColumn(checkBox));
            tableView.setItems(articlesList);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void processSave(ActionEvent actionEvent) {
        Article article = new Article();
        article.setTitle(txtTitle.getText());
        article.setDescription(txtDescription.getText());
        article.setContent(txtContent.getText());
        articleRepository.save(article);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Article Save Success");
        alert.show();
        reset();
    }

    public void processReset(ActionEvent actionEvent) {
        reset();
    }
    public void reset(){
        txtTitle.clear();
        txtDescription.clear();
        txtContent.clear();
    }

    }

