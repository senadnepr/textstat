package ua.senadnepr.textstat.util;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.senadnepr.textstat.model.TextFile;
import ua.senadnepr.textstat.model.TextFileString;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MyFileUtils {

    public static TextFile writeFile(MultipartFile file, String pathToWrite) throws ApplicationException{
        File target = new File(pathToWrite + file.getOriginalFilename());

        try {
            file.transferTo(target);
        } catch (IOException e) {
            throw new ApplicationException("Error write file");

        }

        TextFileString textFileString = parseFile(target.toPath());

        TextFile textFile = null;
        try {
            textFile = createStatistic(textFileString);
        } catch (ApplicationException e) {
            if ("Empty file error".equals(e.getMessage())) {
                try {
                    Files.delete(target.toPath());
                    System.out.println(target.toPath().toString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            throw e;
        }
        return textFile;
    }

    private static TextFileString parseFile(Path target) throws ApplicationException{
        FileReader input = null;
        try {
            input = new FileReader(target.toString());
        } catch (FileNotFoundException e) {
            throw new ApplicationException("File not found exception");
        }
        BufferedReader bufRead = new BufferedReader(input);
        String myLine = null;
        List<String> list = new ArrayList<>();
        try {
            while (true) {

                myLine = bufRead.readLine();
                if (myLine == null) break;

                list.add(myLine);
            }
        } catch (IOException e) {
            throw new ApplicationException("Parsing file error");
        } finally {
            try {
                bufRead.close();
                input.close();
            } catch (IOException e) {
                throw new ApplicationException("Parsing file error");
            }
        }

        return new TextFileString(target, list);

    }

    private static TextFile createStatistic(TextFileString fileString) throws ApplicationException{

        String name = fileString.name.getFileName().toString();
        String fullName = fileString.name.toString();
        Integer numberOfString = fileString.strings.size();
        if(fileString.strings.get(0) == null) throw new ApplicationException("File is empty");
        int nword = 0;
        Integer maxWord = 0;
        Integer minWord = 0;
        for (String s: fileString.strings
             ) {

            String delims = "[ .,?!]+";
            String[] words = s.split(delims);
            nword += words.length;

            Integer max = null;
            Integer min = null;
            try {
                max = Arrays.stream(words).mapToInt(String::length).max().getAsInt();
                min = Arrays.stream(words).mapToInt(String::length).min().getAsInt();
            } catch (Exception e) {
                throw new ApplicationException("Empty file error");
            }

            maxWord = (maxWord < max) ? max : maxWord;
            minWord = maxWord;
            minWord = (minWord > min) ? min : minWord;

        }

        Integer averageNumber = nword / fileString.strings.size();

        return new TextFile(null, name, fullName, numberOfString, averageNumber, maxWord, minWord);
    }

}
