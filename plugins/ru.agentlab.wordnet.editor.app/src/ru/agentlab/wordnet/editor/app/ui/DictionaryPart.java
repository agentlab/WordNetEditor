package ru.agentlab.wordnet.editor.app.ui;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.dictionary.Dictionary;
import net.sf.extjwnl.service.IExtjwnlService;
import net.sf.extjwnl.utilities.Examples;

public class DictionaryPart {

    private IExtjwnlService extjwnlService;
    private List<Dictionary> dictionary = new LinkedList<>();

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

    public synchronized void setDictionary(IExtjwnlService service) {
        System.err.println("Service was set. Thank you DS!");

        this.extjwnlService = service;
        this.dictionary = this.extjwnlService.getDictionary();

        if (null != dictionary)
        {
            try
            {
                new Examples(this.dictionary.get(0)).go();
            }
            catch (JWNLException | CloneNotSupportedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // Method will be used by DS to unset the quote service
    public synchronized void unsetDictionary(IExtjwnlService service) {
        if (this.dictionary != null)
        {
            this.dictionary = null;
        }
        if (this.extjwnlService == service)
        {
            this.extjwnlService = null;
        }
    }
}
