package ru.agentlab.wordnet.editor.app.ui;

import javax.annotation.PostConstruct;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;

public class DictionaryPart {

    public DictionaryPart() {
	}

	@PostConstruct
	void initUI(BorderPane pane) {
		try {
			TreeItem<String> root = new TreeItem<>("Nouns");
			root.setExpanded(true);
			root.getChildren().addAll(new TreeItem<>("Word 1"), new TreeItem<>("Word 2"), new TreeItem<>("Word 3"));
			TreeView<String> treeView = new TreeView<>(root);

			pane.setCenter(treeView);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
