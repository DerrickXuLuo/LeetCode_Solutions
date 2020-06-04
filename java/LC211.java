
/**
 * @Author Derrick
 * @CreateTime 6/4/2020 2:25 PM
 * @Desc
 */
public class LC211 {

    static class TrieNode{
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }

    private TrieNode root;
    Set<String> set;
    /** Initialize your data structure here. */
    public LC211() {
        set = new HashSet<>();
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        this.set.add(word);

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);
            if (node.children[currChar - 'a'] == null) {
                node.children[currChar - 'a'] = new TrieNode();
            }
            node = node.children[currChar - 'a'];
        }

        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    /**
     * Time Complexity: Worst case: O(m), total number of characters in the Trie.
     * @param chs
     * @param k
     * @param node
     * @return
     */
    private boolean match(char[] chs, int k, TrieNode node){
        if (k == chs.length){
            return node.isWord;
        }

        if (chs[k] == '.'){
            for (int i = 0; i < node.children.length; i++){
                if (node.children[i] != null && match(chs, k + 1, node.children[i])){
                    return true;
                }
            }
        }else {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        }

        return false;
    }
}
