package kr.cart.vo;

import java.sql.Date;

import kr.item.vo.ItemVO;

public class CartVO {
	private int cart_num;
	private int item_num;
	private int order_quantity;
	private Date reg_date;
	private int mem_num;
	private int sub_total;
	
	private ItemVO item;

	public final int getCart_num() {
		return cart_num;
	}

	public final void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}

	public final int getItem_num() {
		return item_num;
	}

	public final void setItem_num(int item_num) {
		this.item_num = item_num;
	}

	public final int getOrder_quantity() {
		return order_quantity;
	}

	public final void setOrder_quantity(int order_quantity) {
		this.order_quantity = order_quantity;
	}

	public final Date getReg_date() {
		return reg_date;
	}

	public final void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public final int getMem_num() {
		return mem_num;
	}

	public final void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}

	public final int getSub_total() {
		return sub_total;
	}

	public final void setSub_total(int sub_total) {
		this.sub_total = sub_total;
	}

	public final ItemVO getItem() {
		return item;
	}

	public final void setItem(ItemVO item) {
		this.item = item;
	}
	
}
