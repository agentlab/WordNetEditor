package ru.agentlab.wordnet.editor.app.ui;

import javax.annotation.PostConstruct;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;

public class WordPart {

    public WordPart() {
	}

	@PostConstruct
	void initUI(BorderPane pane) {
		try {
			TreeItem<String> root = new TreeItem<>("Word 1");
			root.setExpanded(true);
			root.getChildren().addAll(new TreeItem<>("SynWord 1"), new TreeItem<>("SynWord 2"), new TreeItem<>("SynWord 3"));
			TreeView<String> treeView = new TreeView<>(root);

			pane.setCenter(treeView);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
