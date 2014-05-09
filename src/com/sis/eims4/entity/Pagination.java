package com.sis.eims4.entity;

import java.io.Serializable;

import com.sis.eims4.util.ConfigUtil;
/**
 * ページ
 * @author test01
 *
 */
public class Pagination implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 828927275285252810L;
	//現在のページ
	private int page = 1;
	//表示本数
	private int pageSize;
	//前のページ
	private int prePage = 1;
	//後一ページ
	private int nextPage = 2;
    //から行
	private int startRow = 1;
	//結束行
	private int endRow = 100;
	//最大のページ
	private int maxPage = Integer.MAX_VALUE;
	//総本数
	private int countItem = 0;
	public Pagination(){
		this.setPageSize(Integer.parseInt(ConfigUtil.getValue("MAXLINES")));
	}

	public int getCountItem() {
		return countItem;
	}
	public void setCountItem(int countItem) {
		this.countItem = countItem;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getPage() {
	    return page;
	  }
	public void setPage(int page) {
	    if(page <= 0) page=1;
	    if(page > maxPage) page = maxPage;
	    this.page = page;
	    prePage = this.page==1?1:this.page-1;
	    nextPage = this.page==maxPage?maxPage:this.page+1;
	    startRow = (this.page-1)*pageSize + 1;
	    endRow = startRow+pageSize-1;
	}
	public int getPageSize() {
	    return pageSize;
	}
	public void setPageSize(int pageSize) {
	    if(pageSize < 3) pageSize = 3;
	    if(pageSize > 100) pageSize = 100;
	    this.pageSize = pageSize;
	    setPage(this.page);
	}
	public int getPrePage() {
	    return prePage;
	}
	public void setPrePage(int prePage) {
	    this.prePage = prePage;
	}
	public int getNextPage() {
	    return nextPage;
	}
	public void setNextPage(int nextPage) {
	    this.nextPage = nextPage;
	}
	public int getStartRow() {
	    return startRow;
	}
	public void setStartRow(int startRow) {
	    this.startRow = startRow;
	}
	public int getMaxPage() {
	    return maxPage;
	}
	public void setMaxPage(int maxPage) {
	    if(maxPage<=0) maxPage = 1;
	    this.maxPage = maxPage;
	    setPage(page);
	}

}
