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
	
	//1. funkcijas deklarācija
	private void resize()
	{
	//3. apreķināt newSize
		int newSize = (counter <= 100)? size * 2 : (int)(size * 1.5);
	//4. izveidot listNew ar newSize izmeru
		Ttype[] heapNew = (Ttype[]) new Object[newSize];
	//5. veikt kopēsanu no veca masīva uz jauno
		for(int i = 0; i < size; i++) {
			heapNew[i] = heap[i];
		}
		
	//6. nomainam list refernci uz listNew
		heap = heapNew;
	//7. izsaukt Garbage Collector
		System.gc();
	//8. size noaminām uz newSize
		size = newSize;
	}
	
	
	public void enqueue(Ttype element) throws Exception {
		if(element == null) throw new Exception("Problems with element");
		
		if(isFull()) resize();
		
		heap[counter] = element;
		counter++;
		//TODO reheapUp();
		
	}
	
	public Ttype dequeue() throws Exception{
		if(isEmpty()) throw new Exception("Heap is empty and it is not possible to retrieve max element");

		
		Ttype prioElement = heap[0];
		heap[0] = heap[counter-1];
		counter--;
		//TODO reaheapDown()
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

	public void makeEmpty() {
		counter = 0;
		size = HEAP_DEFAULT_SIZE;
		heap = (Ttype[])new Object[size];
		System.gc();	
	}
	
	
	
	
	
	
	
	
	

}
