package ru.agentlab.wordnet.editor.app.ui;

import java.util.Iterator;

import javax.annotation.PostConstruct;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import net.sf.extjwnl.data.list.PointerTargetNode;
import net.sf.extjwnl.data.list.PointerTargetNodeList;

public class WordPart {

	private static WordPart wp;

	public static WordPart getWp() {
		return wp;
	}

	TreeItem<String> root;
    Utilities u = new Utilities();

    public WordPart() {
		wp = this;
	}

	private TreeView<String> treeView = new TreeView<>();

	@PostConstruct
	void initUI(BorderPane pane) {
		try {
			pane.setCenter(treeView);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

    void initializeTree(String name, PointerTargetNodeList hyponyms) {
        TreeItem<String> root = new TreeItem<>(name);
        root.setExpanded(true);

        Iterator<PointerTargetNode> iter = hyponyms.iterator();
        if (iter.hasNext() == false)
        {
            root.getChildren().add(new TreeItem<>("No hyponyms."));
        }
        else
        {
            while (iter.hasNext())
            {
                String str = iter.next().toString();
                root.getChildren().add(new TreeItem<>(u.getWords(str)));
            }
        }

		treeView.setRoot(root);
	}
}