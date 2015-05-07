
public class SquareLeft extends Square
{	
	SquareLeft(int i, int j)
	{
		super(i, j);
	}

	 GraphicalObject step()
	 {
	 return new TriangleLeftObject(RED, i, j);
	 }	 
}
