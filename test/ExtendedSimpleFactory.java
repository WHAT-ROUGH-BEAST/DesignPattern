package test;

/**
 * 
 * @author 2017050521
 * generate odd / even number
 */
public class ExtendedSimpleFactory {
	public static void main(String[] args) {
		PropertyReader reader = new PropertyReader("resources/config.properties");
		NumberGenerator numGen = NumberGenerator.factoryMethod((String)reader.read("numberType"));
		
		for (int i = 0; i < 10; i++)
		{
			try
			{
				System.out.println(numGen.next());
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}

abstract class NumberGenerator
{ 
	abstract public int next();
	
	static NumberGenerator factoryMethod(String s)
	{
		if ("odd".equals(s))
			return new OddNumGenerator();
		else if ("even".equals(s))
			return new EvenNumGenerator();
		else
			return null;
	}
}

class OddNumGenerator extends NumberGenerator
{
	private int num = -1;
	
	public int next()
	{
		num += 2;
		return num;
	}
}

class EvenNumGenerator extends NumberGenerator
{
	private int num = -2;
	
	public int next()
	{
		num += 2;
		return num;
	}
}






