package day09;

import java.util.Objects;

public class Point {
	
	public int row;
	public int column;
	
	public Point(int row, int column) {
		this.row = row;
		this.column = column;
	}

	@Override
	public String toString() {
		return "Point [row=" + row + ", column=" + column + "]";
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(column, row);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return column == other.column && row == other.row;
	}
}
