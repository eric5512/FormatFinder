import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    private String ext;
    private Map<Byte, Node> childs;
    
    public Node(String ext) {
        this.childs = new HashMap<>();
        this.ext = ext;
    }

    public void addChildNodes(List<Byte> bytes, String ext) {
        if (bytes.isEmpty()) {
            this.ext = ext;
            return;
        }
        
        byte auxByte = bytes.remove(0);

        Node aux = this.childs.get(auxByte);
        
        if (aux == null) {
            Node newNode = new Node(ext);
            this.childs.put(auxByte, newNode);
        } else {
            aux.addChildNodes(bytes, ext);
        }
            
    }


}
