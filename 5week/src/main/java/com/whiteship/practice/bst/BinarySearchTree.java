package com.whiteship.practice.bst;

import java.util.*;

public class BinarySearchTree {

	Node root;
	
	void addNode(int value) {
		Node newNode = new Node(value);
		if (root == null) {
			root = newNode;
			return;
		} 
	
		Node findNode = root;
		Node parentNode;
		
		while(true) {
			parentNode = findNode;
			
			if (findNode.value < value) {
				findNode = findNode.right;
				
				if (findNode == null) {
					parentNode.right = newNode;
					return;
				}
			} else {
				findNode = findNode.left;
				
				if (findNode == null) {
					parentNode.left = newNode;
					return;
				}
			}
		}
	}
	
	
	void deleteNode(int value) {
		if(root == null) {
			System.out.println("트리가 존재하지 않습니다.");
			return;
		}
		
		Node findNode = root;
		Node parentNode = root;
		Node rightMinNode;

		while(findNode.value != value) {
			parentNode = findNode;
			
			if (findNode.value < value) {
				findNode = findNode.right;
				
				if (findNode == null) {
					System.out.println("지울 값이 존재하지 않습니다.");
					return;
				}
			} else {
				findNode = findNode.left;
				
				if (findNode == null) {
					System.out.println("지울 값이 존재하지 않습니다.");
					return;
				}
			}
		}

		if (findNode.left == null && findNode.right == null) {
			if (findNode == root) {
				root = null;
			} else if (parentNode.left == findNode) {
				parentNode.left = null;
			} else {
				parentNode.right = null;
			}
		} 
		
		else if (findNode.left == null) {
			rightMinNode = findNode.right;
			
			if(findNode == root) {
				root = rightMinNode;
			} else if (parentNode.left == findNode) {
				parentNode.left = rightMinNode;
			} else {
				parentNode.right = rightMinNode;
			}
		} 
		
		else if (findNode.right == null) {
			rightMinNode = findNode.left;
			
			if (findNode == root) {
				root = rightMinNode;
			} else if (parentNode.left == findNode) {
				parentNode.left = rightMinNode;
			} else {
				parentNode.right = rightMinNode;
			}
		} 

		else {
			Node rightNode = findNode.right;
			rightMinNode = minNode(findNode.right);

			if (findNode == root) {
				root = rightMinNode;
			}
			else if (parentNode.left == findNode) {
				parentNode.left = rightMinNode;
			}
			else {
				parentNode.right = rightMinNode;
			}

			if (rightMinNode != rightNode) {
				rightMinNode.right = rightNode;
			}
			rightMinNode.left = findNode.left;
		}
	}

	Node minNode(Node rightNode) {
		Node parentNode = rightNode;
		while(rightNode.left != null) {
			parentNode = rightNode;
			rightNode = rightNode.left;
		}

		parentNode.left = null;

		return rightNode;
	}


	void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.value + " ");
			inOrder(node.right);
		}
	}


	void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.value + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.value + " ");
		}
	}


	void inOrderTraversal() {
		inOrder(root);
	}


	List<Integer> bfs(Node node) {
		List<Integer> nodes = new ArrayList<>();
		if (node == null) {
			return nodes;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while(!queue.isEmpty()) {
			node = queue.remove();
			nodes.add(node.value);

			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		return nodes;
	}

	List<Integer> dfs(Node node) {
		Stack<Node> stack = new Stack<>();
		List<Integer> nodes = new ArrayList<>();

		if (node == null) {
			return nodes;
		}

		stack.push(node);

		while(!stack.isEmpty()) {
			while(node.left != null) {
				node = node.left;
				stack.push(node);
			}
			node = stack.pop();
			nodes.add(node.value);

			if (node.right != null) {
				node = node.right;
				stack.push(node);
			}
		}
		return nodes;
	}


	public boolean search(int value) {
		return search(root, value);
	}


	public boolean search(Node node, int value) {
		boolean flag = false;

		while ((node != null) && !flag) {
			int nodeValue = node.value;

			if (value < nodeValue) {
				node = node.left;
			} else if (value > nodeValue) {
				node = node.right;
			} else {
				flag = true;
				break;
			}
			flag = search(node, value);
		}
		return flag;
	}

}


