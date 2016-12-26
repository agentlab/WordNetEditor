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

    void initializeTree(String name, PointerTargetNodeList hypernyms, PointerTargetNodeList hyponyms,
        PointerTargetNodeList synonyms, PointerTargetNodeList antonyms, PointerTargetNodeList holonyms,
        PointerTargetNodeList CoordinateTerms) {
        TreeItem<String> root = new TreeItem<>(name);
        String hyper = "Hypernyms: ";
        String hypo = "Hyponyms: ";
        String syno = "Synonyms: ";
        String anto = "Antonyms: ";
        String holo = "Holonyms: ";
        String coord = "Coordinate terms: ";
        root.setExpanded(true);

        Iterator<PointerTargetNode> iterHYPER = hypernyms.iterator();
        while (iterHYPER.hasNext())
        {
            String str = iterHYPER.next().toString();
            hyper = hyper.concat(u.getWords(str));
            if (iterHYPER.hasNext())
            {
                hyper = hyper.concat(", ");
            }
            else
            {
                hyper = hyper.concat(".");
            }
        }
        root.getChildren().add(new TreeItem<>(hyper));


        Iterator<PointerTargetNode> iterHYPO = hyponyms.iterator();
        while (iterHYPO.hasNext())
        {
            String str = iterHYPO.next().toString();
            hypo = hypo.concat(u.getWords(str));
            if (iterHYPO.hasNext())
            {
                hypo = hypo.concat(", ");
            }
            else
            {
                hypo = hypo.concat(".");
            }
        }
        root.getChildren().add(new TreeItem<>(hypo));


        Iterator<PointerTargetNode> iterSYNO = synonyms.iterator();
        while (iterSYNO.hasNext())
        {
            String str = iterSYNO.next().toString();
            syno = syno.concat(u.getWords(str));
            if (iterSYNO.hasNext())
            {
                syno = syno.concat(", ");
            }
            else
            {
                syno = syno.concat(".");
            }
        }
        root.getChildren().add(new TreeItem<>(syno));


        Iterator<PointerTargetNode> iterANTO = antonyms.iterator();
        while (iterANTO.hasNext())
        {
            String str = iterANTO.next().toString();
            anto = anto.concat(u.getWords(str));
            if (iterANTO.hasNext())
            {
                anto = anto.concat(", ");
            }
            else
            {
                anto = anto.concat(".");
            }
        }
        root.getChildren().add(new TreeItem<>(anto));

        Iterator<PointerTargetNode> iterHOLO = holonyms.iterator();
        while (iterHOLO.hasNext())
        {
            String str = iterHOLO.next().toString();
            holo = holo.concat(u.getWords(str));
            if (iterHOLO.hasNext())
            {
                holo = holo.concat(", ");
            }
            else
            {
                holo = holo.concat(".");
            }
        }
        root.getChildren().add(new TreeItem<>(holo));

        Iterator<PointerTargetNode> iterCOORD = CoordinateTerms.iterator();
        while (iterCOORD.hasNext())
        {
            String str = iterCOORD.next().toString();
            coord = coord.concat(u.getWords(str));
            if (iterCOORD.hasNext())
            {
                coord = coord.concat(", ");
            }
            else
            {
                coord = coord.concat(".");
            }
        }
        root.getChildren().add(new TreeItem<>(coord));

		treeView.setRoot(root);
	}
}