package com.sis.eims4.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 * DB接続及び閉鎖
 * @author test01
 *
 */
public class DBUtil {
	private static  String driver;
	private static  String url;
	private static  String user;
	private static  String password;
	static {
		try {
			driver = ConfigUtil.getValue("driver");
			url = ConfigUtil.getValue("url");
			user = ConfigUtil.getValue("user");
			password = ConfigUtil.getValue("password");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    /**
     * DB接続
     * @return
     * @throws Exception
     */
	public static Connection getConnection() throws Exception {
		return DriverManager.getConnection(url, user, password);
	}

	/**
	 * DB閉じる
	 *
	 * @param conn          接続
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 閉じるPreparedStatement
	 *
	 * @param ps             PreparedStatement
	 */
	public static void close(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 閉じるResultSet
	 * @param rs             ResultSet
	 */
	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 *閉じる接続、PreparedStatement
	 * @param conn            接続
	 * @param ps              PreparedStatement
	 */

	public static void close(ResultSet rs,PreparedStatement ps) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 閉じる接続、PreparedStatement
	 * @param conn            接続
	 * @param ps              PreparedStatement
	 */

	public static void close(Connection conn,PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 閉じる接続PreparedStatement、ResultSet
	 * @param conn           接続
	 * @param ps             PreoparedStatement
	 * @param rs             ResultSet
	 */
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	}

}
