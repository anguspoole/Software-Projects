
public class SquareUp extends Square
{	
	SquareUp(int i, int j)
	{
		super(i, j);
	}

	 GraphicalObject step()
	 {
	 return new TriangleUpObject(RED, i, j);
	 }	 
}
