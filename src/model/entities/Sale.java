package model.entities;

public class Sale {
	
	private Integer month;
	private Integer year;
	private String seller;
	private Integer itens;
	private Double total;
	

	public Sale(String seller, Double total) {
		this.seller = seller;
		this.total = total;
	}

	public Sale(Integer month, Integer year, String seller, Integer itens, Double total) {
		this.month = month;
		this.year = year;
		this.seller = seller;
		this.itens = itens;
		this.total = total;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Integer getItens() {
		return itens;
	}

	public void setItens(Integer itens) {
		this.itens = itens;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double averagePrice() {
		return total / itens;
	}

	@Override
	public String toString() {
		return seller + ", " + String.format("%.2f", total);
	}
	
	
}