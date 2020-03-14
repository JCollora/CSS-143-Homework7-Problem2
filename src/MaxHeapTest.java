import static org.junit.Assert.*;
import org.junit.Test;

public class MaxHeapTest {
	@Test
	public void testMaxHeapLogN() {
		Integer[][] cases = {
				{},
				{20, 10},
				{10, 20},
				{20, 5, 10},
				{20, 10, 5, 30}
		};
		
		Integer[][] expected = {
				{},
				{20, 10},
				{20, 10},
				{20, 5, 10},
				{30, 20, 5, 10}
		};
		
		for(int i = 0; i < cases.length; i++) {
			MaxHeap result = new MaxHeap(cases[i].length); 
			result.MaxHeapLogN(cases[i]);
			assertTrue(result.equals(expected[i]));
		}
	}
	
	@Test
	public void testMaxHeapN() {
		Integer[][] cases = {
				{},
				{20, 10},
				{10, 20},
				{20, 5, 10},
				{20, 10, 5, 30}
		};
		
		Integer[][] expected = {
				{},
				{20, 10},
				{20, 10},
				{20, 5, 10},
				{30, 20, 5, 10}
		};
		
		for(int i = 0; i < cases.length; i++) {
			MaxHeap result = new MaxHeap(cases[i].length); 
			result.MaxHeapN(cases[i]);
			assertTrue(result.equals(expected[i]));
		}
	}
	
	@Test
	public void testAdd() {
		//Empty Heap | SET 1
		MaxHeap s1 = new MaxHeap(0);
		assertFalse(s1.add(30));
		
		//Full Heap | SET 2
		MaxHeap s2 = new MaxHeap(3);
		assertTrue(s2.add(20));
		assertTrue(s2.add(50));
		assertTrue(s2.add(10));
		assertFalse(s2.add(100));
		assertFalse(s2.add(101));
		assertFalse(s2.add(102));
	}
	
	@Test
	public void testGet() {
		//Empty Heap | SET 1
		MaxHeap s1 = new MaxHeap(0);
		assertEquals(null, s1.get());
		
		//Large Capacity Empty Heap | SET 2
		MaxHeap s2 = new MaxHeap(20);
		assertEquals(null, s2.get());
		
		//Full Heap | SET 3
		MaxHeap s3 = new MaxHeap(5);
		assertTrue(s3.add(20));
		assertTrue(s3.add(50));
		assertTrue(s3.add(10));
		assertTrue(s3.add(20));
		assertTrue(s3.add(50));
		assertFalse(s3.add(10));
		
		assertEquals(50, (int) s3.get());
	}
	
	@Test
	public void testPop() {
		//Empty Heap | SET 1
		MaxHeap s1 = new MaxHeap(0);
		assertEquals(null, s1.get());
		
		//Large Capacity Empty Heap | SET 2
		MaxHeap s2 = new MaxHeap(11);
		assertEquals(null, s2.get());
		
		//Full Heap | SET 2
		//Full Heap | SET 3
		MaxHeap s3 = new MaxHeap(5);
		assertTrue(s3.add(20));
		assertTrue(s3.add(50));
		assertTrue(s3.add(10));
		assertTrue(s3.add(20));
		assertTrue(s3.add(40));
		assertFalse(s3.add(10));
		
		assertEquals(50, (int) s3.pop());
		
		assertEquals(40, (int) s3.get());
	}
	
}