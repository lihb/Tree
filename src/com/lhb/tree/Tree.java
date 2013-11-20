package com.lhb.tree;

import java.util.Stack;

public class Tree {
	
	private char data;
	private Tree lchild;
	private Tree rchild;
	
	public Tree(char ch){
		data = ch;
	}
	
	//前序遍历
	private static void preOrder(Tree t){
		Stack<Tree> s = new Stack<Tree>();
		while(t!=null ||!s.empty()){
			while (t!=null) {
				System.out.print(t.data + " ");
				s.push(t);
				t=t.lchild;
			}
			if (!s.empty()) {
				t = s.pop();
				t = t.rchild;
			}
		}
		
	}
	
	//中序遍历
	private static void inOrder(Tree t){
		Stack<Tree> s = new Stack<Tree>();
		while(t!=null ||!s.empty()){
			while (t!=null) {
				s.push(t);
				t = t.lchild;
			}
			if (!s.empty()) {
				t = s.pop();
				System.out.print(t.data + " ");
				t = t.rchild;
			}
		}
	}
	
	//后序遍历
	private static void postOrder(Tree t){
		Stack<Tree> s = new Stack<Tree>();
		Stack<Integer> s2 = new Stack<Integer>();
		Integer flag = new Integer(1);
		while(t!=null ||!s.empty()){
			while (t!=null) {
				s.push(t);
				s2.push(new Integer(0));
				t = t.lchild;
			}
			while (!s.empty()&&s2.peek().equals(flag)) {
				System.out.print(s.pop().data + " ");
				s2.pop();
			}
			if (!s.empty()) {
				s2.pop();
				s2.push(new Integer(1));
				t = s.peek();
				t = t.rchild;
			}
		}	
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree t1 = new Tree('a');
		Tree t2 = new Tree('b');
		Tree t3 = new Tree('c');
		Tree t4 = new Tree('d');
		Tree t5 = new Tree('e');
		Tree t6 = new Tree('f');
		Tree t7 = new Tree('g');
		Tree t8 = new Tree('h');
		Tree t9 = new Tree('i');
		Tree t10 = new Tree('j');
		Tree t11 = new Tree('k');
		
		t1.lchild = t2; t1.rchild = t3;
		t2.lchild = t4; t2.rchild = t5;
		t3.lchild = t6; t3.rchild = t7;
		t4.lchild = t8; 
		t5.lchild = t9; t5.rchild = t10;
		t7.rchild = t11;
		
		Tree.preOrder(t1);
		System.out.println();
		Tree.inOrder(t1);
		System.out.println();
		Tree.postOrder(t1);
		

	}

}
