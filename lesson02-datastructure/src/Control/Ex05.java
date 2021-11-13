package Control;

public class Ex05 {
	
	public static void main(String[] args) {
		
		prinwithdowhile(7);
	}
	private static void prinwithfor(int n)
	{
		for(int i=0;i<n;i++)
			System.out.println(i);
	}
	private static void prinwithwhile(int n)
	{
		int i=0;
			while(i<n)
			{
				System.out.println(i);
				i++;
			}
	}
	private static void prinwithdowhile(int n)
	{
		int i=0;
		do
		{
			System.out.println(i);
			i++;
		}
		while(i<n);
	}
	
}
