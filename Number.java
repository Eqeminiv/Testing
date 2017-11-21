package testy;

public class Number {
	public int num;
	
	public Number(int num) {
		this.num = num;
	}
	
	public int sign()
	{
		if (this.num > 0)
		{
			return 1;
		}
		
		else if (this.num == 0)
		{
			return 0;
		}
		else
		{
			return -1;
		}
		
	}

}
