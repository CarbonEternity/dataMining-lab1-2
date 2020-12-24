package ua.karazina.popova.model;

import java.util.List;

public class Data {

    private final List<String> hamMessages;

    private final List<String> spamMessages;

    public Data(List<String> hamMessages, List<String> spamMessages) {
        this.hamMessages = hamMessages;
        this.spamMessages = spamMessages;
    }

    public List<String> getHamMessages() {
        return hamMessages;
    }

    public List<String> getSpamMessages() {
        return spamMessages;
    }
}
