package test;

public class FactoryPattern
{
	public static void main(String[] args)
	{
		Factory fac = new AFactory();
		TV tv = fac.tvFactory();
		tv.play();
	}
}

interface TV
{
	void play();
}

interface Factory
{
	TV tvFactory();
}

class ATV implements TV 
{
	public void play() 
	{
		System.out.println(this.getClass().toString());
	}
}

class AFactory implements Factory 
{
	public TV tvFactory()
	{
		return new ATV();
	}
}










