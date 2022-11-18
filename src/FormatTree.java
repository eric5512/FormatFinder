import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormatTree {
    private Map<Byte, Node> nodes;
    
    public FormatTree() {
        this.nodes = new HashMap<>();
    }

    public void addExtensions(List<Byte> bytes, String ext) {
        if (bytes.isEmpty()) {
            return;
        }
        
        byte auxByte = bytes.remove(0);

        Node aux = this.nodes.get(auxByte);
        
        if (aux == null) {
            Node newNode = new Node(ext);
            this.nodes.put(auxByte, newNode);
        } else {
            aux.addChildNodes(bytes, ext);
        }
    }

    public String getExtension(List<Byte> bytes) throws Exception {
        Node next = this.nodes.get(bytes.remove(0));

        if (next == null) {
            throw new Exception("Header not found");
        }

        return next.getExtension(bytes);
    }
}
