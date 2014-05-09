package com.sis.eims4.util;

public class Constants {
	private static final String SES_CONDITION ="condition";
	private static final String SES_EMPDTO = "empDto";
	private static final String UPDATE_FLAG = "doUpdate";
	private static final String DELETE_FLAG = "doDelete";
	private static final String ADD_FLAG = "doAdd";
	private static final String SYSTEM_ERROR_FLAG = "systemError";
	private static final String URL_ERROR_FLAG = "urlError";
	private static final String CONFORM_ERROR_FLAG = "conformError";
	private static final String INPUT_ERROR_FLAG = "inputError";
	private static final String SES_ID = "sessionId";
	public static String getSesId() {
		return SES_ID;
	}
	public static String getInputErrorFlag() {
		return INPUT_ERROR_FLAG;
	}
	public static String getSystemErrorFlag() {
		return SYSTEM_ERROR_FLAG;
	}
	public static String getUrlErrorFlag() {
		return URL_ERROR_FLAG;
	}
	public static String getSesCondition() {
		return SES_CONDITION;
	}
	public static String getUpdateFlag() {
		return UPDATE_FLAG;
	}
	public static String getDeleteFlag() {
		return DELETE_FLAG;
	}
	public static String getConformErrorFlag() {
		return CONFORM_ERROR_FLAG;
	}
	public static String getAddFlag() {
		return ADD_FLAG;
	}
	public static String getSesEmpDto() {
		return SES_EMPDTO;
	}

}
