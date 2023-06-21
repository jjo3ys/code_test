package daily;

import java.util.ArrayList;
import java.util.Arrays;

public class d26 {
    static ArrayList<String> arrList = new ArrayList<>();
    public static void main(String[] args) {
        d26.tree root = new d26.tree("1");
        d26.tree rootChild1 = root.addChildNode(new d26.tree("2"));
        d26.tree rootChild2 = root.addChildNode(new d26.tree("3"));
        d26.tree leaf1 = rootChild1.addChildNode(new d26.tree("4"));
        d26.tree leaf2 = rootChild1.addChildNode(new d26.tree("5"));
        ArrayList<String> output = dfs(root);
        System.out.println(Arrays.toString(output.toArray()));
    }

    public static ArrayList<String> dfs(tree node) {
    // TODO:
		arrList.add(node.getValue());
        if (node.getChildrenNode()!=null){
            for (int i=0; i<node.getChildrenNode().size(); i++){
                if (node.getChildrenNode() != null){
                    dfs(node.getChildrenNode().get(i));
			}
		}
        }
		
		return arrList;
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
