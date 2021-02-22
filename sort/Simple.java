public class Simple implements Comparable<Simple> {
	private String alpha = null;
	private Integer numeric = 0;

	public Simple() {
	}

	public Simple(String a, Integer n) {
		alpha = a;
		numeric = n;
	}

	public String alpha() { return alpha; }
	public void alpha(String a) { alpha = a; }
	public Integer numeric() { return numeric; }
	public void numeric(Integer n) { numeric = n; }

	@Override
	public String toString() {
		return "{"+alpha+","+numeric+"}";
	}

	@Override
	public int compareTo(Simple other) {
		return numeric.compareTo(other.numeric);
	}

	@Override
	public boolean equals(Object object) {
		if (this==object) return true;
		if (!(object instanceof Simple)) return false;

		Simple other = (Simple) object;
		return (alpha.equals(other.alpha) && numeric==other.numeric);

	}
}
