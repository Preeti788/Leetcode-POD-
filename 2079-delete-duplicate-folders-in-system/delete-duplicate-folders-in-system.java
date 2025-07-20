class Solution {
    class TrieNode {
        String name;
        Map<String, TrieNode> children = new HashMap<>();
        String serial = "";
        boolean toDelete = false;

        TrieNode(String name) {
            this.name = name;
        }
    }

    TrieNode root = new TrieNode("");
    Map<String, List<TrieNode>> serialMap = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new TrieNode(folder));
                curr = curr.children.get(folder);
            }
        }

        serialize(root);


        for (List<TrieNode> group : serialMap.values()) {
            if (group.size() > 1) {
                for (TrieNode node : group) {
                    node.toDelete = true;
                }
            }
        }

    
        List<List<String>> result = new ArrayList<>();
        collectPaths(root, new ArrayList<>(), result);
        return result;
    }

    private String serialize(TrieNode node) {
        if (node.children.isEmpty()) return "";

        List<String> serialList = new ArrayList<>();
        for (TrieNode child : node.children.values()) {
            String childSerial = serialize(child);
            serialList.add("(" + child.name + childSerial + ")");
        }

        Collections.sort(serialList);
        node.serial = String.join("", serialList);
        serialMap.computeIfAbsent(node.serial, k -> new ArrayList<>()).add(node);
        return node.serial;
    }

    private void collectPaths(TrieNode node, List<String> path, List<List<String>> result) {
        for (TrieNode child : node.children.values()) {
            if (child.toDelete) continue;
            path.add(child.name);
            result.add(new ArrayList<>(path));
            collectPaths(child, path, result);
            path.remove(path.size() - 1);
        }
    }
}
