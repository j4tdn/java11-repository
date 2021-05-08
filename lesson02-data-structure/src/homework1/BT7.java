package homework1;

public class BT7 {
	public static void main (String[] args)
	{

	int countofPrime = 0;
	for (int getal =2; ; getal++)
	{
	//int count = 0;
	//while (count < 201)

	    if (Priem(getal))
	    {
	        countofPrime++;
	        System.out.println(getal);
	        if(countofPrime == 200)
	            break;
	    }
	}

	}   

	public static boolean Priem (int getal)
	{

	for (int i=2; i<getal; i++)
	{

	    if (getal%i == 0)
	    {
	    return false;
	    }

	}
	return true;
	}
}
