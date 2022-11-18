

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHelper {
    public static List<File> listFilesWithoutExt(String path) {
        List<File> retList = new ArrayList<>();

        File folderFile = new File(path);

        for (File file : folderFile.listFiles()) {
            if (!file.isDirectory())
                retList.add(file);
        }

        return retList;
    }

    public static Map<String,String> getExtensionDict(String filePath) throws FileNotFoundException, IOException {
        Map<String,String> dict = new HashMap<>();
        
        File file = new File(filePath);

        try (BufferedReader fStream = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = fStream.readLine()) != null && !line.equals("")) {
                String[] parts = line.split(",");
                dict.put((parts[0]).trim(), (parts[1]).trim());
            }
        }

        return dict;
    }
}