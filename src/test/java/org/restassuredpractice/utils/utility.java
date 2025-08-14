package org.restassuredpractice.utils;

import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class utility {

    public static String readJSON(String filepath) throws IOException {
        return FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
    }

    public static void saveResponseFile(String responsefilepath, String response) throws IOException {
        FileWriter fileWriter = new FileWriter(responsefilepath);
        fileWriter.write(response);
        fileWriter.close();

    }
}
