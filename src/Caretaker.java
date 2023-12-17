import java.util.ArrayList;

public class Caretaker {
	public static Caretaker care;
	private Caretaker()
	{
		
	}
	
	public static Caretaker getInstance()
	{
		if(care == null)
			care = new Caretaker();
		
		return care;
		
		
	}
	
	
	ArrayList<Memento> list = new ArrayList<Memento>();
	int index =-1;
	
	public void add(Memento m)
	{
		if(index != -1)
			delete();
		list.add(m);
		index = list.size()-1;
		
	}
	
	public void delete()
	{
		int size = list.size();
		int i=index+1;
		
		while(i<size)
		{
			
			
			list.remove(index+1);
			i++;
		}
		
		
	}
	
	public Memento getPrev()
	{
		index--;
		return list.get(index);
		
		
	}

	
	public Memento getNext()
	{
		index++;
		return list.get(index);
		
		
	}
	
	public boolean isThereNext()
	{
		if(index == list.size()-1)
			return false;
		
		return true;
	}

	public boolean isTherePrev()
	{
		if(index == 0)
			return false;
		
		return true;
	}

}
