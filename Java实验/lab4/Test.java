import java.util.*;
public class Test {
    public static void main(String[] arg)
    {
	Scanner out=new Scanner(System.in);
	int treesize=out.nextInt();
	int judge;
	Binarytree tree=new Binarytree();
	while(treesize>0)
	{
		judge=out.nextInt();
		if(judge==1)
		{
			Student stu=new Student();
			stu.course=out.nextInt();
			stu.makeArray();
			for(int i=0;i<stu.course;i++)
			{
				stu.credit[i]=out.nextInt();
				stu.grade[i]=out.nextInt();
			}
			Node thenode=new Node("Student",stu.getLevel(),null);
			tree.insertNode(thenode);
		}
		else if(judge==2)
		{
			Worker theworker=new Worker();
			theworker.salary=out.nextInt();
			theworker.level=theworker.salary/100;
			Node thenode2=new Node("Worker",theworker.level,null);
			tree.insertNode(thenode2);
		}
		treesize--;
	}
	tree.preorderTraverse(tree.root);
    }
}
class Student{
	int course;
	int level;
	int grade[];
	int credit[];
	public void makeArray()
	{
		this.grade=new int[this.course];
		this.credit=new int[this.course];
	}
	public int getLevel()
	{
		if(this.course==0)
			return 0;
		int sum=0;
		int sum2=0;
		for(int i=0;i<this.course;i++)
		{
			sum=sum+this.grade[i]*this.credit[i];
			sum2=sum2+credit[i];
		}
		this.level=sum/sum2;
		return this.level;
	}
}
class Worker{
	int salary;
	int level;
	
}
class Node{
	String name;
	int level;
	Node leftchild;
	Node rightchild;
	Node lastnode;
	Node(){
		this.name="";
		this.level=0;
	}
	Node(String name,int level,Node thelastnode){
		this.name=name;
		this.level=level;
		this.lastnode=thelastnode;
	}
	public void displayNode()
	{
		System.out.println(this.name+":"+this.level);
	}
}
class Binarytree{
	Node root;
	Binarytree(){
		this.root=null;
	}

	public Node findNode(Node treenode)
	{
		if(this.root==null)
			return this.root;
		Node operate=this.root;
		while(operate!=null)
		{
			if(operate.level>treenode.level&&operate.leftchild!=null)
			{
				operate=operate.leftchild;
			}
			else if(operate.level<=treenode.level&&operate.rightchild!=null)
			{
				operate=operate.rightchild;
			}
			else
				return operate;
		}
		return operate;
	}
	public void insertNode(Node treenode)
	{
		Node thenode=this.findNode(treenode);
		if(thenode==null)
		{
			this.root=new Node(treenode.name,treenode.level,null);
			return ;
		}
		if(treenode.level>=thenode.level)
		{
			thenode.rightchild=new Node(treenode.name,treenode.level,thenode);
		}
		else if(treenode.level<thenode.level)
			thenode.leftchild=new Node(treenode.name,treenode.level,thenode);
		else
			System.out.println("error");
	}
	public Node findPrecursor(Node treenode)
	{
		Node operate=treenode.leftchild;
		while(operate.rightchild!=null)
		{
			operate=operate.rightchild;
		}
		return operate;
	}
	public boolean deleteNode(Node treenode)
	{
		if(this.root==null)
			return false;
		Node operate=this.root;
		while(operate!=null)
		{
			if(operate.level>treenode.level&&operate.leftchild!=null)
			{
				operate=operate.leftchild;
			}
			else if(operate.level<treenode.level&&operate.rightchild!=null)
			{
				operate=operate.rightchild;
			}
			else if(operate.level==treenode.level&&operate.name.equals(treenode.name))
			{
				if(operate.leftchild==null||operate.rightchild==null)
				{
					if(operate.leftchild==null&&operate.rightchild==null)
					{
						if(operate==operate.lastnode.rightchild)
							operate.lastnode.rightchild=null;
						else
							operate.lastnode.leftchild=null;
						operate=null;
					}
					else if(operate.leftchild==null)
					{
						if(operate==operate.lastnode.rightchild)
							operate.lastnode.rightchild=operate.rightchild;
						else
							operate.lastnode.leftchild=operate.rightchild;
						operate.rightchild.lastnode=operate.lastnode;
						operate=null;
					}
					else
					{
						if(operate==operate.lastnode.rightchild)
							operate.lastnode.rightchild=operate.leftchild;
						else
							operate.lastnode.leftchild=operate.leftchild;
						operate.leftchild.lastnode=operate.lastnode;
						operate=null;
					}
				}
				else
				{
					Node precursor=this.findPrecursor(operate);
					operate.level=precursor.level;
					operate.name=precursor.name;
					if(precursor.lastnode.leftchild==precursor)
						precursor.lastnode.leftchild=precursor.leftchild;
					else
						precursor.lastnode.rightchild=precursor.leftchild;
					precursor.leftchild.lastnode=precursor.lastnode;
					precursor=null;
				}
				return true;	
			}
			else
				return false;
		}
		return false;
	}
	public void preorderTraverse(Node treenode)
	{
		treenode.displayNode();
		if(treenode.leftchild!=null)
			preorderTraverse(treenode.leftchild);
		if(treenode.rightchild!=null)
			preorderTraverse(treenode.rightchild);
	}
}