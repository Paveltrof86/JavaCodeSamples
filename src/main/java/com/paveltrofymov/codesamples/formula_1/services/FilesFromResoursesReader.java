package com.paveltrofymov.codesamples.formula_1.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesFromResoursesReader {
    static final String EXCEPTION_MESSAGE = "File not found";

    public List<String> readFilesFromResources(String filePath) {
        List<String> list = new ArrayList<>();

        try {
            list = Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(EXCEPTION_MESSAGE);
        }

        return list;
    }
}
