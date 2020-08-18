package utils;

import java.io.File;

public class FileUtil {

    public File getLatestFilefromDir(){

        File dir = new File("C:\\Users\\" + System.getProperty("user.name") + "\\Downloads" );
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
}
