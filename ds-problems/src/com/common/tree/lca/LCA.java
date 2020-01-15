package com.common.tree.lca;

import javax.print.attribute.standard.Finishings;

public class LCA
{
	private Node root;
	
	private static class Node
	{
		int value;
		Node left,right;
		
		public Node(int value)
		{
			this.value = value;
		}
	}

	public static void main(String[] args)
	{
		LCA tree = new LCA();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7);
        
        System.out.println("LCA of (4, 5) is: " + tree.findLca(tree.root, 4, 5).value);
        System.out.println("LCA of (4, 6) is: " + tree.findLca(tree.root, 4, 6).value);
        System.out.println("LCA of (3, 4) is: " + tree.findLca(tree.root, 3, 4).value);
        System.out.println("LCA of (2, 4) is: " + tree.findLca(tree.root, 2, 4).value);
	}
	
	public Node findLca(Node root, int n1, int n2)
	{
		if(root == null)
		{
			return null;
		}
		
		if(root.value == n1 || root.value == n2)
		{
			return root;
		}
		
		Node left = findLca(root.left, n1, n2);
		Node right = findLca(root.right, n1, n2);
		
		/*
		 * If left and right are not null then the current root node should be
		 * the LCA (Least Common Ancestor)
		 */
		if(left != null && right != null)
		{
			return root;
		}
		
		// If left and right both came null, means search doesn't identified under current root
		// so return null
		if(left == null & right == null)
		{
			return null;
		}
		
		// If any of the node from left or right is not null return that node
		return null != left? left : right;
	}
}
