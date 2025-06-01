class Node
{
    int val;
    Node next;
    Node(int val)
    {
        this.val=val;
        this.next=null;
    }
}
public class LinkedList 
{
    public static Node head;
    public static Node tail;
    public static Node insertAtBeg(int value)
    {
        Node newNode=new Node(value);
        newNode.next=head;
        head=newNode;
        return newNode;
    }
    public static void insertAtEnd(int val)
    {
        Node temp=head;
        while(temp.next!=null)
            temp=temp.next;
        Node newNode=new Node(val);
        temp.next=newNode;
    }
    public static void insertAfterParticularNode(int val,Node givenNode)
    {
        Node newNode=new Node(val);
        newNode.next=givenNode.next;
        givenNode.next=newNode;
    }
    public static void insertAfterParticularValue(int val,int givenNodeVal)
    {
        Node temp=head;
        while(temp.val!=givenNodeVal)
            temp=temp.next;
        Node newNode=new Node(val);
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public static Node middleNodeLeetcode(Node head) // in even Case return the 2nd Middle
    {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static Node middleNodeV2(Node head)  // in even Case return the 1st Middle
    {
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static boolean isPalidrome(Node head)
    {
        Node middle=middleNodeV2(head);
        Node newHead=middle.next;
        middle.next=null;

        newHead=reverseNode(newHead);

        Node h1=head;
        Node h2=newHead;

        boolean ans=true;

        while(h2!=null)
        {
            if(h1.val!=h2.val)
            {
                ans=false;
                break;
            }
            h1=h1.next;
            h2=h2.next;
        }
        return ans;
    }
    public static Node reverseNode(Node head)
    {
        Node prev=null;
        Node next=null;
        Node temp=head;
        while(temp!=null)
        {
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }
    public static Node removeKthNodeFromEnd(Node head,int k)
    {
        Node fast=head;
        Node slow=head;
        while(k>0)
        {
            fast=fast.next;
            k--;
        }
        if(fast==null)
            return head.next;
        while(fast.next!=null)
        {
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }
    public static void reOrderLinkedList(Node head)
    {
        //s1 Middle
        Node middle=middleNodeV2(head);
        Node newhead=middle.next;
        middle.next=null;

        //s2 Reverse
        newhead=reverseNode(newhead);

        // s3 merge
        Node h1=head;
        Node h2=newhead;

        Node f1=null;
        Node f2=null;

        while(h1!=null && h2!=null)
        {
            f1=h1.next;
            f2=h2.next;

            h1.next=h2;
            h2.next=f1;

            h1=f1;
            h2=f2;
        }
        
    }
    public static void sizeOfLinkedList(Node head)
    {
        Node temp=head;
        int size=0;
        while(temp!=null)
        {
            size++;
            temp=temp.next;
        }
        System.out.println(size);
    }
    public static void printLinkedList(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void intialize()
    {
        Node a=new Node(10);
        Node b=new Node(20);
        Node c=new Node(30);
        Node d=new Node(40);
        Node e=new Node(50);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        head=a;
        tail=e;
    }
    public static void main(String[] args) {
        intialize();
        printLinkedList(head);
        insertAtBeg(100 );
        printLinkedList(head);
        insertAtEnd(101);
        printLinkedList(head);
        // insertAfterParticularNode(15,d);
        Node newhead=reverseNode(head);
        head=newhead;
        printLinkedList(head);
        // sizeOfLinkedList(b);
    }    
}
