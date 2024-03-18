package com.app.dto;

import java.util.List;

public class ProductPagedResponseDTO {
	
	private List<ProductResponseDto> plist;
	
	private int current;
	
	private long total;
	
	private int pagesize;
	
	public List<ProductResponseDto> getPlist() {
		return plist;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public void setPlist(List<ProductResponseDto> plist) {
		this.plist = plist;
	}
	
}
