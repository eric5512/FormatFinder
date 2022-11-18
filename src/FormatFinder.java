import java.io.File;
import java.util.List;
import java.util.Map;

public class FormatFinder {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java FormatFinder <path-to-files> <path-to-dictionary>");
        }

        String path = args[0], dict = args[1];
        List<File> files = FileHelper.listFilesWithoutExt(path);
        Map<String,String> dicMap;
        try {
            dicMap = FileHelper.getExtensionDict(dict);
        } catch(Exception e) {
            e.printStackTrace();
        }

        FormatTree formatTree = new FormatTree();

        for (File file : files) {
            String name = file.getName();
            
            try {
                String ext = formatTree.getExtension(null);
                file.renameTo(new File(name + ext));
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        
        
    }
}