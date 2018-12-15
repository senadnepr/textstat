package ua.senadnepr.textstat.model;

import java.nio.file.Path;
import java.util.List;


public class TextFileString {

    public Path name;
    public List<String> strings;

    public TextFileString(Path name, List<String> strings) {
        this.name = name;
        this.strings = strings;
    }
}
