package com.sakha.sms.am.utils;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

import org.hibernate.HibernateException;

public class JdbcRowSetUtils {
	private static final JdbcRowSet jdbcRowSet;
	/**
	 * @return the jdbcrowset
	 */
	public static JdbcRowSet getJdbcrowset() throws HibernateException {
		return jdbcRowSet;
	}
	static {

		try {
			Class.forName(Constants.DB_DRIVER);
			jdbcRowSet = RowSetProvider.newFactory().createJdbcRowSet();
			jdbcRowSet.setUrl(Constants.DB_URL);
			jdbcRowSet.setUsername(Constants.DB_USER);
			jdbcRowSet.setPassword(Constants.DB_PASSWORD);
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	
}
