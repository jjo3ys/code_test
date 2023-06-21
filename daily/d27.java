package daily;

import java.util.*;

public class d27 {
    public static void main(String[] args) {
        Solution.tree root = new Solution.tree("1");
        Solution.tree rootChild1 = root.addChildNode(new Solution.tree("2"));
        Solution.tree rootChild2 = root.addChildNode(new Solution.tree("3"));
        Solution.tree leaf1 = rootChild1.addChildNode(new Solution.tree("4"));
        Solution.tree leaf2 = rootChild1.addChildNode(new Solution.tree("5"));
        ArrayList<String> output = Solution.bfs(root);
        System.out.println(Arrays.toString(output.toArray())); // --> ["1", "2", "3", "4", "5"]

        leaf1.addChildNode(new Solution.tree("6"));
        rootChild2.addChildNode(new Solution.tree("7"));
        output = Solution.bfs(root);
        System.out.println(Arrays.toString(output.toArray())); // --> ["1", "2", "3", "4", "5", "7", "6"]
    }
}

class Solution { 
	public static ArrayList<String> bfs(tree node) {
    // TODO:
    ArrayList<String> arr = new ArrayList<>();
    Queue<tree> queue = new LinkedList<>();
    queue.add(node);
    arr.add(node.getValue());
    while(!queue.isEmpty()){
      tree next = queue.poll();
      if (next.getChildrenNode()!=null){
        for(tree child:next.getChildrenNode()){
          queue.add(child);
          arr.add(child.getValue());
        }
      }
    }
    return arr;
	}    

	//아래 클래스의 내용은 수정하지 말아야 합니다.
	public static class tree {
    private String value;
    private ArrayList<tree> children;

    public tree(String data) {
      this.value = data;
      this.children = null;
    }

    public tree addChildNode(tree node) {
      if(children == null) children = new ArrayList<>();
      children.add(node);
      return children.get(children.size() - 1);
    }

    public String getValue() {      //현재 노드의 데이터를 반환
      return value;
    }

    public ArrayList<tree> getChildrenNode() {
      return children;
    }
  }
}
