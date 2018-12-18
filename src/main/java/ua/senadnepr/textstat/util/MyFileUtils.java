package ua.senadnepr.textstat.util;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.senadnepr.textstat.model.TextFile;
import ua.senadnepr.textstat.model.TextFileString;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

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
                } catch (IOException e1) {
                    throw new ApplicationException("Error delete empty file");
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
        Integer numberOfString = 0;
        if(fileString.strings.get(0) == null) throw new ApplicationException("Empty file error");
        int numberOfWordInFile = 0;
        List<Integer> maxWordNumberArray = new ArrayList<>();
        List<Integer> minWordNumberArray = new ArrayList<>();

        for (String s: fileString.strings
             ) {
            if("".equals(s)) continue;
            numberOfString++;
            String delims = "[ .,?!]+";

            List<String> wordsInString = Arrays.stream(s.split(delims)).filter(e-> e.length()>0).collect(Collectors.toList());

            numberOfWordInFile += wordsInString.size();

            try {
                maxWordNumberArray.add(wordsInString.stream().mapToInt(String::length).max().getAsInt());
                minWordNumberArray.add(wordsInString.stream().mapToInt(String::length).min().getAsInt());
            } catch (Exception e) {
                throw new ApplicationException("Empty file error");
            }

        }
        if(numberOfWordInFile == 0 || numberOfString == 0) throw new ApplicationException("Empty file error");

        Integer averageNumber = numberOfWordInFile / numberOfString;
        Integer maxWord = Collections.max(maxWordNumberArray);
        Integer minWord = Collections.min(minWordNumberArray);

        return new TextFile(null, name, fullName, numberOfString, averageNumber, maxWord, minWord);
    }

}
