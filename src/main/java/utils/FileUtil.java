package utils;

import java.io.*;

public class FileUtil {

    public File getLatestFilefromDir() {

        File dir = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Downloads");
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null;
        }

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    public String readFile(String filename) {

        BufferedReader br = null;

        String fileContent = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader(filename));

            while ((sCurrentLine = br.readLine()) != null) {

                fileContent = sCurrentLine;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return fileContent;
    }

    public void appendFile(String filename, String apendText) {

        File file = new File(filename);

        //if file doesnt exists, then create it
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            deleteFile(filename);

        //true = append file
        FileWriter fileWritter = null;
        try {
            fileWritter = new FileWriter(filename, true);

            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(apendText);
            bufferWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFile(String filename) {

        File file = new File(filename);

        if (file.exists()) file.delete();
    }
}
