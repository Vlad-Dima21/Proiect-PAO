package com.proiect.services.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AuditingIO {
    File auditing = new File("D:\\Facultate\\An_2_Sem_2\\PAO\\Proiect\\src\\main\\java\\com\\proiect\\resources\\auditing.csv");

    public void logAction(String nameOfAction) {

        try {
            if (!auditing.exists()) {
                auditing.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(auditing, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String str = formatter.format(date);
            bufferedWriter.write('\n' + nameOfAction + ',' + str);
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Nu se poate inregistra actiunea!");
            System.exit(-1);
        }
    }
}
