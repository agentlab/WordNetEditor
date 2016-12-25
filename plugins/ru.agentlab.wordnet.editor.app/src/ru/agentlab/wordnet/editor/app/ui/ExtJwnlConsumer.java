/**
 *
 */
package ru.agentlab.wordnet.editor.app.ui;

import java.util.LinkedList;
import java.util.List;

import net.sf.extjwnl.dictionary.Dictionary;
import net.sf.extjwnl.service.IExtjwnlService;

public class ExtJwnlConsumer {

    private IExtjwnlService extjwnlService;
    private List<Dictionary> dictionary = new LinkedList<>();

    public synchronized void setDictionary(IExtjwnlService service) {
        System.err.println("Service was set. Thank you DS!");

        this.extjwnlService = service;
        this.dictionary = this.extjwnlService.getDictionary();

        if (null != dictionary) {

        }
    }

    // Method will be used by DS to unset the quote service
    public synchronized void unsetDictionary(IExtjwnlService service) {
        if (this.dictionary != null) {
            this.dictionary = null;
        }
        if (this.extjwnlService == service) {
            this.extjwnlService = null;
        }
    }

}
