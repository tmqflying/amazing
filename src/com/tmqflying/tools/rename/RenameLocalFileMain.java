/**
 * util RenameLocalFileMain.java Version: 1.0<br>
 * Copyright 2015 &copy; <a href="http://www.tmqflying.com/">tmqflying.com</a>, All Rights Reserved<br>
 * @author Maoqitao May 2, 2015 11:26:02 PM
 */
package com.tmqflying.tools.rename;

import java.io.File;

import com.tmqflying.tools.rename.model.InitParamsModel;

/**
 * <b>RenameLocalFileMain.java</b><br>
 * <b>Desc:</b> Rename local files tool.<br>
 *
 * @author Maoqitao May 2, 2015 11:26:02 PM
 *
 */
public class RenameLocalFileMain {

	/**
	 * <b>main</b><br>
	 * <b>Desc:</b> Rename files.<br>
	 *
	 * @author Maoqitao May 2, 2015 11:26:02 PM
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		// Initialization params
		InitParamsModel params = new InitParamsModel();
		
		// Setting [args] params
		setArgsParams(params, args);
		
		// Print params information
		printParams(params);
		
		// Processing method
		processing(params);
		
		// Print count information
		printCount(params);
	}

	/**
	 * <b>printCount</b><br>
	 * <b>Desc:</b> <br>
	 *
	 * @author Maoqitao May 3, 2015 12:26:21 AM
	 *
	 * @param params
	 */
	private static void printCount(InitParamsModel params) {
		StringBuffer sb = new StringBuffer();
		sb.append("\ncount:").append(params.getCount());
		sb.append("\nsuccess:").append(params.getSuccess());
		sb.append("\nfinished.");
		
		System.out.println(sb.toString());
	}

	/**
	 * <b>processing</b><br>
	 * <b>Desc:</b> <br>
	 *
	 * @author Maoqitao May 3, 2015 12:11:36 AM
	 *
	 * @param params
	 */
	private static void processing(InitParamsModel params) {
		// Get base params
		// Get file name list
		// Check file exists
		// Rename file
		// Loop until finish
		
		File fileDir = new File(params.getFilePath());
		if (fileDir.isDirectory()) {
			File[] fileList = fileDir.listFiles();
			
			for (File fileTemp : fileList) {
				if (fileTemp.isFile()) {
					params.setCount(params.getCount() + 1);
					File newFile = null;
					while (newFile == null || newFile.exists()) {
						params.setFileSequenceNum(params.getFileSequenceNum() + 1);
						newFile = new File(getNewFileName(params, fileTemp));
					}
					
					boolean executeFlag = fileTemp.renameTo(newFile);
					
					if (executeFlag) {
						params.setSuccess(params.getSuccess() + 1);
						System.out.println("--" + fileTemp.getName() + "->" + newFile.getName());
					}
				}
			}
			
		} else {

			params.setCount(params.getCount() + 1);
			File newFile = null;
			while (newFile == null || newFile.exists()) {
				params.setFileSequenceNum(params.getFileSequenceNum() + 1);
				newFile = new File(getNewFileName(params, fileDir));
			}
			
			boolean executeFlag = fileDir.renameTo(newFile);
			
			if (executeFlag) {
				params.setSuccess(params.getSuccess() + 1);
				System.out.println(fileDir.getName() + "->" + newFile.getName());
			}
		}
	}

	/**
	 * <b>getNewFileName</b><br>
	 * <b>Desc:</b> <br>
	 *
	 * @author Maoqitao May 3, 2015 12:56:16 AM
	 *
	 * @param params
	 * @param fileTemp 
	 * @return
	 */
	private static String getNewFileName(InitParamsModel params, File fileTemp) {
		StringBuffer sb = new StringBuffer();
		sb.append(params.getFilePath());
		sb.append("/");
		sb.append(params.getNewName());
		
		if (params.getNameSeparator() != null)
			sb.append(params.getNameSeparator());
		
		sb.append(params.getFileSequenceNum());
		
		if (params.getFileExtension() != null) 
			sb.append(params.getFileExtension());
		else sb.append(fileTemp.getName().substring(fileTemp.getName().lastIndexOf(".")));
		
		return sb.toString();
	}

	/**
	 * <b>printParams</b><br>
	 * <b>Desc:</b> <br>
	 *
	 * @author Maoqitao May 3, 2015 12:25:48 AM
	 *
	 * @param params
	 */
	private static void printParams(InitParamsModel params) {
		if (params == null || params.getFilePath() == null || params.getNewName() == null) {
			System.out.println("params is null, executing will cancel.");
			System.exit(0);
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append("\nfilePath:").append(params.getFilePath());
		sb.append("\nnewName:").append(params.getNewName());
		sb.append("\nnameSeparator:").append(params.getNameSeparator());
		sb.append("\nfileExtension:").append(params.getFileExtension());
		
		System.out.println(sb.toString());
	}

	/**
	 * <b>setArgsParams</b><br>
	 * <b>Desc:</b> <br>
	 *
	 * @author Maoqitao May 3, 2015 12:05:22 AM
	 *
	 * @param params
	 * @param args 
	 */
	private static void setArgsParams(InitParamsModel params, String[] args) {
		// params[0]-filePath params[1]-newName params[2]-nameSeparator(options) params[3]-fileExtension(options)
		if (params != null && args != null) {
			if (args.length > 0 && !args[0].equals("0"))
				params.setFilePath(args[0]);
			
			if (args.length > 1 && !args[1].equals("0"))
				params.setNewName(args[1]);
			
			if (args.length > 2 && !args[2].equals("0"))
				params.setNameSeparator(args[2]);
			
			if (args.length > 3 && !args[3].equals("0"))
				params.setFileExtension(args[3]);
		}
	}

}
