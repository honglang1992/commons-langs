package com.cloudin.commons.langs.entity;

import java.util.List;

/**
 * 基本分页查询结果实体
 *
 * @author 小天
 * @version 1.0.0, 2017/11/28 0028 15:24
 */
public class BaseListWithPageResult<T> implements IBaseResult {
	
	private Integer   code;
	private String    message;
	private List<T>   data;
	private Exception exception;
	
	/**
	 * 总记录数
	 */
	private Integer total;
	/**
	 * 筛选后的总记录数
	 */
	private Integer filteredTotal;
	
	protected BaseListWithPageResult() {
	}
	
	protected BaseListWithPageResult(List<T> data) {
		this.data = data;
	}
	
	public static <U> BaseListWithPageResult<U> build() {
		return new BaseListWithPageResult<U>();
	}
	
	public static <U> BaseListWithPageResult<U> build(List<U> data) {
		return new BaseListWithPageResult<U>(data);
	}
	
	public BaseListWithPageResult<T> success(List<T> data, Integer total) {
		this.code = 0;
		this.data = data;
		this.total = total;
		this.filteredTotal = total;
		return this;
	}
	
	public BaseListWithPageResult<T> success(List<T> data, Integer total, Integer filteredTotal) {
		this.code = 0;
		this.data = data;
		this.total = total;
		this.filteredTotal = filteredTotal;
		return this;
	}
	
	public BaseListWithPageResult<T> error(int code, String message) {
		this.code = code;
		this.message = message;
		return this;
	}
	
	public BaseListWithPageResult<T> error(int code, String message, Exception exception) {
		this.code = code;
		this.message = message;
		this.exception = exception;
		return this;
	}
	
	public BaseListWithPageResult<T> withCode(int code) {
		this.code = code;
		return this;
	}
	
	public BaseListWithPageResult<T> withMessage(String message) {
		this.message = message;
		return this;
	}
	
	public BaseListWithPageResult<T> withData(List<T> data) {
		this.data = data;
		return this;
	}
	
	@Override
	public Integer getCode() {
		return code;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	@Override
	public List<T> getData() {
		return data;
	}

	public boolean isSuccess(){
		return code == 0;
	}

	public Exception getException() {
		return exception;
	}
	
	public Integer getTotal() {
		return total;
	}
	
	public Integer getFilteredTotal() {
		return filteredTotal;
	}
}
