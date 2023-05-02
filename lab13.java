import java.util.stream.*;
import java.util.*;
import java.io.*;


public class lab13 {
	ArrayList<Integer> intArr = new ArrayList<Integer>();
	
	public void readData(String filename) {		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			String inn;
			while((inn = br.readLine())!= null) {
				StringTokenizer st = new StringTokenizer(inn);
				while (st.hasMoreTokens()) {
				
					String token = st.nextToken();
					int cur = Integer.parseInt(token);
					intArr.add(cur);
					
				}
			}
			
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		
	}
	
	public long getTotalCount() {
		long count = intArr.stream().count();
		return count;
	}
	
	public long getOddCount() {
		long count = intArr.stream().filter(n-> n%2 != 0).count();
		return count;
	}
	
	public long getEvenCount() {
		long count = intArr.stream().filter(n -> n%2 == 0).count();
		return count;
	}
	
	public long getDistenceGreaterThanFiveCount() {
		long count = intArr.stream().filter(n -> n>5).distinct().count();
		return count;
	}
	
	public Integer[] getResult1() {
		Integer[] result = intArr.stream().filter(n -> n > 5 && n < 50 && n % 2 == 0).sorted().toArray(Integer[]::new);
		return result;
	}
	
	public Integer[] getResult2() {
		Integer[] result = intArr.stream().map(n -> n * n * 3).limit(50).toArray(Integer[]::new);
		return result;
	}
	
	public Integer[] getResult3() {
		Integer[] result = intArr.stream().filter(n -> n%2 != 0).map(n -> n *2).sorted().skip(20).distinct().toArray(Integer[]::new);
		return result;
	}
	
	
}
