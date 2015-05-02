/**
 * util InitParamsModel.java Version: 1.0<br>
 * Copyright 2015 &copy; <a href="http://www.tmqflying.com/">tmqflying.com</a>, All Rights Reserved<br>
 * @author Maoqitao May 2, 2015 11:49:49 PM
 */
package com.tmqflying.tools.rename.model;

/**
 * <b>InitParamsModel.java</b><br>
 * <b>Desc:</b> <br>
 *
 * @author Maoqitao May 2, 2015 11:49:49 PM
 *
 */
public class InitParamsModel {
	// base params
	private String filePath = null;
	private String newName = null;
	private String nameSeparator = null;
	private String fileExtension = null;
	
	// count params
	private int count = 0;
	private int success = 0;
	
	private int fileSequenceNum = 0;
	
	/**
	 * @return the newName
	 */
	public String getNewName() {
		return newName;
	}
	/**
	 * @param newName the newName to set
	 */
	public void setNewName(String newName) {
		this.newName = newName;
	}
	/**
	 * @return the nameSeparator
	 */
	public String getNameSeparator() {
		return nameSeparator;
	}
	/**
	 * @param nameSeparator the nameSeparator to set
	 */
	public void setNameSeparator(String nameSeparator) {
		this.nameSeparator = nameSeparator;
	}
	/**
	 * @return the fileExtension
	 */
	public String getFileExtension() {
		return fileExtension;
	}
	/**
	 * @param fileExtension the fileExtension to set
	 */
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the success
	 */
	public int getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(int success) {
		this.success = success;
	}
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}
	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	/**
	 * @return the fileSequenceNum
	 */
	public int getFileSequenceNum() {
		return fileSequenceNum;
	}
	/**
	 * @param fileSequenceNum the fileSequenceNum to set
	 */
	public void setFileSequenceNum(int fileSequenceNum) {
		this.fileSequenceNum = fileSequenceNum;
	}
}
