package datastr;

public class MyHeap<Ttype> {
	private Ttype[] heap;
	private final int HEAP_DEFAULT_SIZE = 10;
	private int size = HEAP_DEFAULT_SIZE;
	private int counter = 0;
	
	public MyHeap()
	{
		heap = (Ttype[]) new Object[size];
	}
	
	public MyHeap(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		heap = (Ttype[]) new Object[size];
	}
	
	public boolean isEmpty() {
		return (counter==0);
	}
	
	public boolean isFull() {
		return (counter == size);
	}
	
	public int howManyElements() {
		return counter;
	}

	private void resize()
	{
		int newSize = (counter <= 100) ? size * 2 : (int)(size * 1.5);
		Ttype[] heapNew = (Ttype[]) new Object[newSize];
		for(int i = 0; i < size; i++) {
			heapNew[i] = heap[i];
		}
		heap = heapNew;
		System.gc();
		size = newSize;
	}
	
	
	public void enqueue(Ttype element) throws Exception {
		if(element == null) throw new Exception("Problems with element");
		
		if(isFull()) resize();
		
		heap[counter] = element;
		counter++;
		reheapUp(counter - 1);
		
	}
	
	public Ttype dequeue() throws Exception{
		if(isEmpty()) throw new Exception("Heap is empty and it is not possible to retrieve max element");

		
		Ttype prioElement = heap[0];
		heap[0] = heap[counter-1];
		counter--;
		reheapDown(0);
		return prioElement;
		
	}
	
	//print() - parastā
	public void print() throws Exception{
		if(isEmpty()) throw new Exception("Array is empty and it "
				+ "is not possible to print elements");
		
		for(int i = 0; i < counter;i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
	
	//TODO print() - rekursīvo

	public void printRecursive() throws Exception {
		if(isEmpty()) throw new Exception("Array is empty and it "
				+ "is not possible to print elements");

		printRecursiveHelp(0);
	}

	private void printRecursiveHelp(int indexOfElement) {

		Ttype element = heap[indexOfElement];
		System.out.print("P: " + element + " ");

		int leftChildIndex = indexOfElement * 2 + 1;
		int rightChildIndex = indexOfElement * 2 + 2;

		if (leftChildIndex < counter) {
			Ttype leftChild = heap[leftChildIndex];
			System.out.print("L: " + leftChild + " [" + element + "] \n");
			printRecursiveHelp(leftChildIndex);
		}

		if (rightChildIndex < counter) {
			Ttype rightChild = heap[rightChildIndex];
			System.out.print("R: " + rightChild + " [" + element + "] \n");
			printRecursiveHelp(rightChildIndex);
		}
	}

	public void makeEmpty() {
		counter = 0;
		size = HEAP_DEFAULT_SIZE;
		heap = (Ttype[])new Object[size];
		System.gc();	
	}

	private void reheapUp(int indexOfElement) {
		int parentIndex = (indexOfElement - 1) / 2;

		if (parentIndex >= 0 ) {
			Ttype element = heap[indexOfElement];
			Ttype parent = heap[parentIndex];

			if (((Comparable)(element)).compareTo(parent) == 1) {
				swap(parentIndex, indexOfElement);
				reheapUp(parentIndex);
			}
		}
 	}

	 private void reheapDown(int indexOfElement) {
		int leftChildIndex = indexOfElement * 2 + 1;
		int rightChildIndex = indexOfElement * 2 + 2;
		Ttype leftChild;
		Ttype rightChild;
		Ttype element = heap[indexOfElement];

		if (leftChildIndex < counter && rightChildIndex < counter) {
			leftChild = heap[leftChildIndex];
			rightChild = heap[rightChildIndex];

			if (((Comparable)(leftChild)).compareTo(rightChild) == 1) {
				if ( ((Comparable)(leftChild)).compareTo(element) == 1) {
					swap(leftChildIndex, indexOfElement);
					reheapDown(leftChildIndex);
				}
			} else {
				if (((Comparable)(rightChild)).compareTo(element) == 1) {
					swap(rightChildIndex, indexOfElement);
					reheapDown(rightChildIndex);
				}
			}
		} else if (leftChildIndex < counter) {
			leftChild = heap[leftChildIndex];

			if (((Comparable)(leftChild)).compareTo(element) == 1) {
				swap(leftChildIndex, indexOfElement);
			}
		}
	 }

	 private void swap(int index1, int index2) {
		Ttype temp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = temp;
	 }


	
	
	
	
	
	
	
	

}
