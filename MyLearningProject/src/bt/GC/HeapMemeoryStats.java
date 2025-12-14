package bt.GC;

public class HeapMemeoryStats {
public static void main(String[] args) {
	
	long mb = 1024*1024;
	Runtime r = Runtime.getRuntime();
	
	System.out.println(r.maxMemory()/mb);
	System.out.println(r.freeMemory()/mb);
	System.out.println(r.totalMemory()/mb);
//	System.out.println(r.me);
}
}
