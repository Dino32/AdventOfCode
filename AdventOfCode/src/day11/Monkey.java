package day11;

import java.util.List;
import java.util.Objects;

public class Monkey {
	
	private int id;
	private List<Long> items;
	private int increase;
	private String increaseType; 
	private int test;
	private  int nextTrue;
	private int nextFalse;
	
	public Monkey() {}

	public Monkey(int id, List<Long> items, int increase, String increaseType, int test, int nextTrue, int nextFalse) {
		this.id = id;
		this.items = items;
		this.increase = increase;
		this.increaseType = increaseType;
		this.test = test;
		this.nextTrue = nextTrue;
		this.nextFalse = nextFalse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Long> getItems() {
		return items;
	}

	public void setItems(List<Long> items) {
		this.items = items;
	}

	public int getIncrease() {
		return increase;
	}

	public void setIncrease(int increase) {
		this.increase = increase;
	}

	public int getNextTrue() {
		return nextTrue;
	}

	public void setNextTrue(int nextTrue) {
		this.nextTrue = nextTrue;
	}

	public int getNextFalse() {
		return nextFalse;
	}

	public void setNextFalse(int nextFalse) {
		this.nextFalse = nextFalse;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public String getIncreaseType() {
		return increaseType;
	}

	public void setIncreaseType(String increaseType) {
		this.increaseType = increaseType;
	}

	@Override
	public String toString() {
		return "Monkey [id=" + id + ", items=" + items + ", increase=" + increase + ", increaseType=" + increaseType
				+ ", test=" + test + ", nextTrue=" + nextTrue + ", nextFalse=" + nextFalse + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, increase, items, nextFalse, nextTrue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Monkey other = (Monkey) obj;
		return id == other.id && increase == other.increase && Objects.equals(items, other.items)
				&& nextFalse == other.nextFalse && nextTrue == other.nextTrue;
	}
	
	
}
