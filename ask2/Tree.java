import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Tree{
    int data;
    int group;
    List<Tree> children = new LinkedList<>();

    Tree(int data ){
        this.data = data;
    }

    Tree(int data , int group){
        this.data = data;
        this.group = group;
    }

    Tree(int data, List<Tree> children){
        this.data = data;
        this.children = children;
    }

    public void printTree(Tree root){
        if(root == null) return;
        Queue<Tree> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0 ; i < length; i++){
                Tree node = queue.poll();
                System.out.print(node.data + " ");
                for(Tree item : node.children){
                    queue.offer(item);
                }
            }
            System.out.println();
        }
    }



    public  void main(String[] args) {
        Tree root = new Tree(1);
        root.children.add(new Tree(2));
        root.children.add(new Tree(2));
        root.children.add(new Tree(2));
        root.children.get(0).children.add(new Tree(3));
        root.children.get(1).children.add(new Tree(3));
        root.children.get(0).children.add(new Tree(3));


        printTree(root);


        
    }
}