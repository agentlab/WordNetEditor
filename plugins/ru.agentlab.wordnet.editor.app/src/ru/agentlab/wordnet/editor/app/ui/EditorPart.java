package ru.agentlab.wordnet.editor.app.ui;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.fx.ui.di.FXMLLoader;
import org.eclipse.fx.ui.di.FXMLLoaderFactory;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

public class EditorPart {
	@Inject
	@FXMLLoader
	FXMLLoaderFactory factory;

    public EditorPart() {
		System.out.println("Hello");
	}

	@PostConstruct
	void initUI(BorderPane pane) {
		try {
			Node node = initWeek();
			pane.setCenter(node);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
