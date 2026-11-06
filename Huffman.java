import java.util.*;

class Node{
    char ch;
    int freq;
    Node left , right;

    Node(char ch , int freq){
        this.ch = ch;
        this.freq = freq;
    }


    Node(int freq , Node left , Node right){
        this.ch = '-';
        this.freq = freq;
        this.left = left;
        this.right = right;

    }
}


    public class Huffman{
        static void printCode(Node root , String code){
            if(root == null){
                return ;
            }

            //leaf node
            if(root.left == null && root.right==null){
                System.out.println(root.ch + " : " + code);

                return;


            }
            printCode(root.left , code + "0");
            printCode(root.right , code + "1");

        }
    

    public static void main(String[] args){

        char[] chars = {'a' , 'b' , 'c' , 'd' , 'e' , 'f'};
        int [] freq = {5 , 9 , 12 , 13 , 16 , 45};

        PriorityQueue<Node> pq = new PriorityQueue<>((a , b) -> a.freq - b.freq);


        // add each char as node\
    for(int i = 0 ; i < chars.length ; i++){
        pq.add(new Node(chars[i] , freq[i]));
    }
        // combine two minimun frwq nodes
        while(pq.size()>1){
            Node left = pq.poll();
            Node right = pq.poll();

            Node Parent = new Node(left.freq + right.freq , left , right);
            pq.add(Parent);

            
        }
        
        //Step 3: Reemaininf nde is root
            Node root = pq.poll();


            // print huffman codes
            System.out.println("Huffman codes are: ");
            printCode(root , " ");


    }

    

    }

    
