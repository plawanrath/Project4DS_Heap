import java.util.Scanner;
import java.io.File;

public class DupHT {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("src/ph.txt"));
			myHashTable mht = new myHashTable();			
			while(sc.hasNext())
			{
				String ph = sc.nextLine();
				mht.add(ph);
			}
			mht.printDuplicates();
//			mht.print();
		}
		catch(Exception e)
		{
			System.err.println(e);
			System.exit(-1);
		}
	}

}
