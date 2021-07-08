package ex03;

public enum DataType {
	SPECIAL, NUMERIC, STRING;
	public static int typeValueOf(DataType dataType) {
		if(dataType == SPECIAL) {
			return 0;
		}
		if(dataType == NUMERIC) {
			return 1;
		}
		if(dataType == STRING) {
			return 2;
		}
		return -1;
	}
	
	public static int compare(DataType dataType1, DataType dataType2) {
		int diff = typeValueOf(dataType1) - typeValueOf(dataType2);
		return (diff < 0) ? -1 : (diff == 0) ? 0 : 1;
	}
	
	public static DataType typeOf(String str) {
		if (str.equalsIgnoreCase("special")) {
			return DataType.SPECIAL;
		}
		try {
			Integer.parseInt(str);
			return DataType.NUMERIC;
		} catch (NumberFormatException e) {
			return DataType.STRING;
		}
	}
}
