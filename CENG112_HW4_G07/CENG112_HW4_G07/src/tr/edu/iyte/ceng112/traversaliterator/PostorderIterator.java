package tr.edu.iyte.ceng112.traversaliterator;

import java.util.Iterator;

import tr.edu.iyte.ceng112.stack.ArrayStack;
import tr.edu.iyte.ceng112.stack.StackInterface;
import tr.edu.iyte.ceng112.tree.BinaryNode;

public class PostorderIterator<T> implements Iterator<T> {

	private StackInterface<BinaryNode<T>> nodeStack;
	private BinaryNode<T> currentNode;

	public PostorderIterator(BinaryNode<T> root) {
		nodeStack = new ArrayStack<>();
		currentNode = root;
	}

	private void findNextLeaf() {
		while (currentNode != null) {
			nodeStack.push(currentNode);
			if (currentNode.getLeftChild() != null)
				currentNode = currentNode.getLeftChild();
			else
				currentNode = currentNode.getRightChild();
		}
	}

	@Override
	public boolean hasNext() {
		return !nodeStack.isEmpty() || (currentNode != null);
	}

	@Override
	public T next() {
		findNextLeaf();
		BinaryNode<T> nextNode = nodeStack.pop();
		if (!nodeStack.isEmpty()) {
			BinaryNode<T> parent = nodeStack.peek();
			if (nextNode == parent.getLeftChild())
				currentNode = parent.getRightChild();
			else
				currentNode = null;
		} else
			currentNode = null;

		return nextNode.getData();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
