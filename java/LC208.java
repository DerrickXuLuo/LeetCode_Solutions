
/**
 * @Author Derrick
 * @CreateTime 6/4/2020 10:26 AM
 * @Desc
 */
public class LC208 {

    static class TrieNode{
        //links stores the children of the TrieNode
        private TrieNode[] links;
        //26 letters
        private final int R = 26;
        //mark the end of a word
        private boolean isEnd;

        public TrieNode(){
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch){
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node){
            links[ch - 'a'] = node;
        }

        public void setEnd(){
            isEnd = true;
        }

        public boolean isEnd(){
            return isEnd;
        }
    }

    private final TrieNode root;
    /** Initialize your data structure here. */
    public LC208() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);
            if (!node.containsKey(currChar)){
                node.put(currChar, new TrieNode());
            }
            //Move down the tree following the link to the next child level.
            node = node.get(currChar);
        }
        //Mark the current node as an end node.
        node.setEnd();
    }

    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);
            if (node.containsKey(currChar)){
                node = node.get(currChar);
            }else {
                return null;
            }
        }

        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        //(node != null) indicates that the prefix or the whole word is in the trie
        //node.isEnd indicates that the whole word is in the trie.
        return node != null && node.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
