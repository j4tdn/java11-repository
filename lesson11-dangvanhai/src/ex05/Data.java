package ex05;

public class Data {
	private String key;
	private Integer value;

	public Data() {
	}

	public Data(String key, Integer value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Data)) {
			return false;
		}

		Data that = (Data) obj;
		return this.getKey().equals(that.getKey());
	}

	@Override
	public String toString() {
		return "[key=" + key + ", value=" + value + "]";
	}
}
