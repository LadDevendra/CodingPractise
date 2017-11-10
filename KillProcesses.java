import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class KillProcesses {

	class Node{
		int id;
		List<Node> children = new ArrayList<>();
		public Node(int id){
			this.id = id;
		}
	}
	//idea is to creat a tree kinda structure by iterating over it!!
	//O(n) time and O(n) space, can we do better?
	public List<Integer> killProcesses(List<Integer> pId, List<Integer> ppId, int kill){
		HashMap<Integer, Node> map = new HashMap<>();
		//create all nodes
		for(int i: pId){
			map.put(i, new Node(i));
		}
		//establish links
		for(int i=0; i< ppId.size();i++){
			if(ppId.get(i) > 0){
				Node parent = map.get(ppId.get(i));
				parent.children.add(map.get(pId.get(i)));
			}
		}
		List<Integer> killed = new ArrayList<>();
		killed.add(kill);
		killChildren(map.get(kill), killed);
		return killed;
	}
	
	public void killChildren(Node parent, List<Integer> killed){
		for(Node child: parent.children){
			killed.add(child.id);
			killChildren(child, killed);
		}
	}
	
	
	
}

