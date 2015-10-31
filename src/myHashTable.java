import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class myHashTable {
	private HashMap <Integer, ArrayList<String>> myHashTable = new HashMap<Integer, ArrayList<String>>();
	private ArrayList<String> duplicateStorage = new ArrayList<String>();
	
	private String lastFour(String data)
	{
		String[] Vals = data.split("-");
		return Vals[1];
	}
	
	private int getIndex(String data)
	{
		int value = Integer.parseInt(data);
		int rem = value%100;
		return rem;
	}
	
	public void add(String value)
	{
		String lastF = this.lastFour(value);
		int index = this.getIndex(lastF);
		if(myHashTable.get(index) != null)
		{
			ArrayList<String> temp = myHashTable.get(index);
			for(int i=0;i<temp.size();i++)
			{
				if(temp.get(i).equals(value))
				{
					int found = 0;
					for(int j=0;j<this.duplicateStorage.size();j++)
					{
						if(this.duplicateStorage.get(j).equals(value))
						{
							found = 1;
							break;
						}
					}
					if(found != 1)
						this.duplicateStorage.add(value);
					return;
				}
			}
			temp.add(value);
			myHashTable.remove(index);
			myHashTable.put(index, temp);
		}
		else
		{
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(value);
			myHashTable.put(index, temp);
		}
	}
	
	public void printDuplicates()
	{	
		for(int i=0;i<this.duplicateStorage.size();i++)
		{
			System.out.println(this.duplicateStorage.get(i) + " is duplicate");
		}
	}
	
	public void print()
	{
		Iterator mp = myHashTable.entrySet().iterator();
		while(mp.hasNext())
		{
			Entry pair = (Entry) mp.next();
			ArrayList<String> dataValues = new ArrayList<String>();
			dataValues = (ArrayList<String>) pair.getValue();
			int index = (int) pair.getKey();
			System.out.println("The key is " + index);
			for(int i=0;i<dataValues.size();i++)
			{
				System.out.print(dataValues.get(i) + " ");
			}
			System.out.println("\n");
		}
	}
}
