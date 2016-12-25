package ru.agentlab.wordnet.editor.app.ui;

import javax.annotation.PostConstruct;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class DictionaryPart {

    public DictionaryPart() {
    }

    TreeView<String> treeView;

    @PostConstruct
    void initUI(BorderPane pane) {
        try
        {
            TreeItem<String> root = new TreeItem<>("Nouns");
            root.setExpanded(true);
            root.getChildren().addAll(new TreeItem<>("Word 1"), new TreeItem<>("Word 2"), new TreeItem<>("Word 3"));
            treeView = new TreeView<>(root);

            EventHandler<MouseEvent> mouseEventHandle = (MouseEvent event) -> {
                handleMouseClicked(event);
            };

            treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEventHandle);

            pane.setCenter(treeView);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void handleMouseClicked(MouseEvent event) {
        Node node = event.getPickResult().getIntersectedNode();

        if (node instanceof Text || (node instanceof TreeCell && ((TreeCell)node).getText() != null))
        {
            String name = (String)((TreeItem)treeView.getSelectionModel().getSelectedItem()).getValue();

            WordPart wordsChange = WordPart.getWp();
            wordsChange.initializeTree(name);
        }
    }
}
