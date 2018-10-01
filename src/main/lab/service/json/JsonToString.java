package service.json;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class JsonToString {

    public String readJsonFromURL(String urlString) {
        StringBuilder stringBuilder = new StringBuilder();
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public String readJsonFromFile(String filepath) {
        File file = new File(filepath);
        String fileData = "";
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                fileData = sc.nextLine();
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileData;
    }
}