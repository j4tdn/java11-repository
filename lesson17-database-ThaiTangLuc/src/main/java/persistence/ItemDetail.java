package persistence;

public class ItemDetail {
	private Integer idLH;
	private String nameLH;
	private Integer idMH;
	private String nameMH;
	private Double GiaBan;
	private Double GiaMua;
	private Integer SoLuong;
	
	
	public ItemDetail() {
	}

	public ItemDetail(Integer idLH, String nameLH, Integer idMH, String nameMH, Double giaBan, Double giaMua,
			Integer soLuong) {
		this.idLH = idLH;
		this.nameLH = nameLH;
		this.idMH = idMH;
		this.nameMH = nameMH;
		GiaBan = giaBan;
		GiaMua = giaMua;
		SoLuong = soLuong;
	}

	public Integer getIdLH() {
		return idLH;
	}

	public void setIdLH(Integer idLH) {
		this.idLH = idLH;
	}

	public String getNameLH() {
		return nameLH;
	}

	public void setNameLH(String nameLH) {
		this.nameLH = nameLH;
	}

	public Integer getIdMH() {
		return idMH;
	}

	public void setIdMH(Integer idMH) {
		this.idMH = idMH;
	}

	public String getNameMH() {
		return nameMH;
	}

	public void setNameMH(String nameMH) {
		this.nameMH = nameMH;
	}

	public Double getGiaBan() {
		return GiaBan;
	}

	public void setGiaBan(Double giaBan) {
		GiaBan = giaBan;
	}

	public Double getGiaMua() {
		return GiaMua;
	}

	public void setGiaMua(Double giaMua) {
		GiaMua = giaMua;
	}

	public Integer getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(Integer soLuong) {
		SoLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ItemDetail [idLH=" + idLH + ", nameLH=" + nameLH + ", idMH=" + idMH + ", nameMH=" + nameMH + ", GiaBan="
				+ GiaBan + ", GiaMua=" + GiaMua + ", SoLuong=" + SoLuong + "]";
	}
	
}
