package com.webrob.spatial.repositories;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Robert on 2014-12-30.
 */
public abstract class ConnectionManager<T>
{
    protected Connection connection;


    private void closeConnection()
    {
	try
	{
	    connection.close();
	}
	catch (SQLException e)
	{
	    e.printStackTrace();
	}
    }

    private void initConnection() throws ClassNotFoundException, SQLException
    {
	Class.forName("com.mysql.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spdb", "root3", "root");

    }

    private List<T> doTransaction() throws SQLException, ClassNotFoundException
    {
	initConnection();
	List<T> queryResult = doQuery();
	closeConnection();
	return queryResult;
    }

    protected List<T> doAllTransaction()
    {
	List<T> transactionResult = null;
	try
	{
	    transactionResult = doTransaction();
	}
	catch (SQLException | ClassNotFoundException e)
	{
	    e.printStackTrace();
	}
	return transactionResult;
    }

    protected abstract List<T> doQuery() throws SQLException;
}
