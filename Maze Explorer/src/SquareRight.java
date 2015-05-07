
public class SquareRight extends Square
{	
	SquareRight(int i, int j)
	{
		super(i, j);
	}

	 GraphicalObject step()
	 {
	 return new TriangleRightObject(RED, i, j);
	 }	 
}
