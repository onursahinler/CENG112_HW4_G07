package tr.edu.iyte.ceng112.traversaliterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

import tr.edu.iyte.ceng112.tree.BinaryNode;

public class LevelOrderIterator<T> implements Iterator<T> {

	private Queue<BinaryNode<T>> nodeQueue;

	public LevelOrderIterator(BinaryNode<T> root) {
		nodeQueue = new LinkedList<>();
		nodeQueue.offer(root);
	}

	@Override
	public boolean hasNext() {

		return !nodeQueue.isEmpty();
	}

	@Override
	public T next() {

		if (nodeQueue.isEmpty()) {
			throw new NoSuchElementException();
		}

		BinaryNode<T> nextNode = nodeQueue.poll();
		if (nextNode.getLeftChild() != null) {
			nodeQueue.offer(nextNode.getLeftChild());
		}

		if (nextNode.getRightChild() != null) {
			nodeQueue.offer(nextNode.getRightChild());
		}

		return nextNode.getData();
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
