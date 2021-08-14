package bt05;

import java.util.Objects;

import bt04.Vocabulary;

public class Expenditures {
	private String nameSpending;
	private Integer moneySpending;

	public Expenditures() {
		
	}

	public Expenditures(String nameSpending, Integer moneySpending) {
		super();
		this.nameSpending = nameSpending;
		this.moneySpending = moneySpending;
	}

	public String getNameSpending() {
		return nameSpending;
	}

	public void setNameSpending(String nameSpending) {
		this.nameSpending = nameSpending;
	}

	public Integer getMoneySpending() {
		return moneySpending;
	}

	public void setMoneySpending(Integer moneySpending) {
		this.moneySpending = moneySpending;
	}

	//@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (!(obj instanceof Expenditures)) {
//			return false;
//		}
//		Expenditures that = (Expenditures) obj;
//		return getNameSpending().equals(that.getNameSpending());
//	}
//

	@Override
	public String toString() {
		return "Expenditures [nameSpending=" + nameSpending + ", moneySpending=" + moneySpending + "]";
	}
}
