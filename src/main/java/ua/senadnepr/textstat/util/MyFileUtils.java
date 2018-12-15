package ua.senadnepr.textstat.util;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.senadnepr.textstat.model.TextFile;
import ua.senadnepr.textstat.model.TextFileString;

import java.io.*;
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

//        Path target = null;
//        try {
//
//            byte[] bytes = file.getBytes();
//
//            Path path = Paths.get(pathToWrite + file.getOriginalFilename());
//            target = Files.write(path, bytes);
//
//        } catch (IOException e) {
//            throw new ApplicationException("Error write file");
//        }

        TextFileString textFileString = parseFile(target.toPath());
        TextFile textFile = createStatistic(textFileString);

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

        while (true) {
            try {
                myLine = bufRead.readLine();
            } catch (IOException e) {
                throw new ApplicationException("Parsing file error");
            }

            if (myLine == null) break;

            list.add(myLine);
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
            minWord = (minWord > min) ? min : minWord;

        }

        Integer averageNumber = nword / fileString.strings.size();

        return new TextFile(null, name, fullName, numberOfString, averageNumber, maxWord, minWord);
    }

}