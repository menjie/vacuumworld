package grid;

public class GridObject extends ModelObject {

	public static final String CREATE = "Create";
	public static final String PAINT = "Paint";
	protected Grid grid;
	protected double x;
	protected double y;

	/**
	 * Constructs a new generic grid object.
	 * Object must be sited in a grid, this is fixed for the object's lifetime.
	 * @param grid A grid which this object calls home.
	 * @param location The (initial) grid coordinates of this object.
	 */
	public GridObject(Grid grid, GridPoint location) {
		this.grid = grid;
		this.x = location.x;
		this.y = location.y;
		grid.add(this, location);
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	/**
	 * Returns the (integer) point which most closely matches this object's current location. 
	 * @return Rounded integer coordinates for this GridObject.
	 */
	public GridPoint getLocation() {
		return new GridPoint((int)Math.round(x), (int)Math.round(y));
	}

	public Grid getGrid() {
		return grid;
	}

	/**
	 * Returns the single square that best matches this object's current location.
	 * Note that when a moving object moves between two squares, it temporarily occupies both.
	 * @return The Square at this object's rounded integer coordinates.
	 */
	public Square getSquare() {
		return grid.getSquareAt(this.getLocation());
	}

}