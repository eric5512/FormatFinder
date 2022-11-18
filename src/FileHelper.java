

import java.io.File;
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

    public static Map<String,String> getExtension(String file) {
        Map<String,String> dict = new HashMap<>();
        
        return dict;
    }
}