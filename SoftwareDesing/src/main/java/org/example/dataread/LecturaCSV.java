package org.example.dataread;

import org.example.dataread.LecturaArchivo;

import java.io.*;
import java.util.Scanner;

public class LecturaCSV implements LecturaArchivo {
    private String direction = "record.csv";
    public LecturaCSV(){

    }

    public  LecturaCSV(String path){
        direction = path;
    }
    private boolean readFile(String path) {
        File file = new File(path);
        if(file.canRead() != false )
            this.direction = path;
        return file.canRead();
    }
    private Scanner openFile(){
        Scanner scanner = null;

        if (readFile(direction) != false){
            try {
                scanner = new Scanner(new File(direction));
            }catch (Exception e){
                System.out.println(e);
            }

        }
        return scanner;
    }



    public String[][] getRecords(){

        Scanner scannerCycleDimensions = openFile();
        int rowsNumber = 0;
        int columnsNumber = 0;


        while (scannerCycleDimensions.hasNextLine()){
            String line = scannerCycleDimensions.nextLine();
            String[] datafile = line.split(",");
            columnsNumber = datafile.length;
            rowsNumber++;
        }
        scannerCycleDimensions.close();

        String[][] records = new String[rowsNumber][columnsNumber];

        Scanner scannerCollectorData = openFile();

        for (int rows = 0; rows < rowsNumber; rows++){
            String line = scannerCollectorData.nextLine();
            String[] datafile = line.split(",");
            for (int columns = 0; columns < columnsNumber; columns++){
                records[rows][columns] = datafile[columns];
            }
        }
        scannerCollectorData.close();

        return records;
    }

}
