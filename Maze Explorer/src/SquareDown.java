
public class SquareDown extends Square
{	
	SquareDown(int i, int j)
	{
		super(i, j);
	}

	 GraphicalObject step()
	 {
	 return new TriangleDownObject(RED, i, j);
	 }	 
}
