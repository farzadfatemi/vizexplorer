package com.vizexplorer.eval;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by VOLCANO on 3/19/2017.
 */
public class PersonDAO {
    private static final String MAIN_FILE_PATH = "D:\\Test\\";


    private static void writeToFile(String id, String data) {
        try {
            File newFile = new File(MAIN_FILE_PATH + id + ".txt");
            if(!newFile.exists()){
                newFile.createNewFile();
            }
            FileWriter file = new FileWriter(newFile);
            file.write(data);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void insertOrUpdatePerson(String id, String name, String gender, String birthDate) {
        try {
            String data = name + "::" + gender + "::" + birthDate;
            writeToFile(id, data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static File getFile(String id) {
        File f = new File(MAIN_FILE_PATH + id + ".txt");
        if (f.exists() && !f.isDirectory()) {
            return f;
        }
        return null;
    }

    public static String[] getPerson(String id) {
        String[] person = null;
        String line;
        try {
            if (id != null) {
                try (BufferedReader br = new BufferedReader(new FileReader(MAIN_FILE_PATH + id + ".txt"))) {
                    if ((line = br.readLine()) != null) {
                        person = line.split("::");
                        System.out.println("name : " + person[0]);
                        System.out.println("gender : " + person[1]);
                        System.out.println("date of birth : " + person[2]);

                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }

    public static void removePerson(String id) {
        File person = getFile(id);
        if (person!=null && !person.delete()) {
            System.out.println("File not found or Could not delete person");
        }
    }


}
