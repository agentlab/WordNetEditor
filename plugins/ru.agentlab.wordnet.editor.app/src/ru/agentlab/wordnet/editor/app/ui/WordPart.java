package ru.agentlab.wordnet.editor.app.ui;

import javax.annotation.PostConstruct;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;

public class WordPart {

	private static WordPart wp;

	public static WordPart getWp() {
		return wp;
	}

	TreeItem<String> root;

    public WordPart() {
		wp = this;
	}

	private TreeView<String> treeView = new TreeView<>();

	@PostConstruct
	void initUI(BorderPane pane) {
		try {
			initializeTree("Word 1");
			pane.setCenter(treeView);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	void initializeTree(String word) {
		TreeItem<String> root = new TreeItem<>(word);
		root.setExpanded(true);
		root.getChildren().addAll(new TreeItem<>("SynWord 1"), new TreeItem<>("SynWord 2"), new TreeItem<>("SynWord 3"));

		treeView.setRoot(root);
	}
}