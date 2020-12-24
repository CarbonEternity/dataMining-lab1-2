package ua.karazina.popova.service;


import org.apache.commons.io.FileUtils;
import ua.karazina.popova.model.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TextLoader {

    public static Data loadData(File file) throws IOException {
        String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        String[] lines = content.split("\\R*,,,\\R*");

        /**
         * splitting messages into 2 categories
         */
        List<String> hams = new ArrayList<>();
        List<String> spams = new ArrayList<>();
        for (int i = 1; i < lines.length; i++) {
            if (lines[i].startsWith("ham,")) {
                hams.add(lines[i].substring(4));
            } else if (lines[i].startsWith("spam,")) {
                spams.add(lines[i].substring(5));
            } else {
                throw new RuntimeException("Unexpecting category: " + lines[i]);
            }
        }

        return new Data(hams, spams);
    }

    public static String loadString(File file) throws IOException {
        return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
    }
}
