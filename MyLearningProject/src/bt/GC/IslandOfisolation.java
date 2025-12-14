package bt.GC;

public class IslandOfisolation {
	IslandOfisolation value;
	public static void main(String[] args) {
		
		IslandOfisolation o1 = new IslandOfisolation();
		
		IslandOfisolation o2 = new IslandOfisolation();
		
		o1.value=o2;
		o2.value=o1;
		
		o1=null;
		o2=null;
		
		System.gc();
		
	}
	
	
	/*
	 * This method will be called 2 times, GC will be called only once , but here after o2=null, object are not reachable from outside,,
	 * 
	 * thus ther are not eleigible for GC root and are thus collectible by GC, even though they are being referenced by each other.
	 * Both the objects have external references t1 and t2.
		t1 = null : Both the objects can be reached via t2.i and t2 respectively.
		t2 = null: No way to reach any of the objects. 
	 * read --https://www.geeksforgeeks.org/island-of-isolation-in-java/
	 */
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Cleared object....");
		super.finalize();
	}
}
