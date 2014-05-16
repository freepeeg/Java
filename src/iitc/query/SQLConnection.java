package iitc.query;

import java.sql.*;

/**
 * SQLConnection
 *
 * @author Ian
 * @version 1.0
 */
public class SQLConnection {
    private final String database;
    private String username;
    private String password;
    private Connection current;

    /**
     * Constructs a new <code>SQLConnection</code> to be used to facilitate future queries to the same database using the JDBC driver.
     *
     * @param database desired database name
     * @param username initial login credential
     * @param password initial login credential
     * @throws InsufficientDriverException
     */
    public SQLConnection(String database, String username, String password) throws InsufficientDriverException {
        this("com.mysql.jdbc.Driver", database, username, password);
    }

    /**
     * Constructs a new <code>SQLConnection</code> to be used to facilitate future queries to the same database.
     *
     * @param pathToDriver url to the drivers main class
     * @param database     desired database name
     * @param username     initial login credential
     * @param password     initial login credential
     * @throws InsufficientDriverException
     */
    public SQLConnection(String pathToDriver, String database, String username, String password) throws InsufficientDriverException {
        try {
            Class.forName(pathToDriver);
        } catch (Exception e) {
            throw new InsufficientDriverException();
        }
        this.database = database;
        this.username = username;
        this.password = password;
    }

    /**
     * Resets the cached username, password and connection for future queries.
     * This method makes use of a fluent interface to be able to easily reset the credentials in-line.
     *
     * @return a reference to this object
     * @throws java.sql.SQLException
     */
    public SQLConnection reconnect(String username, String password) throws SQLException {
        this.username = username;
        this.password = password;
        this.current = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, username, password);
        return this;
    }

    /**
     * Generates a new <code>Connection</code> upon the first use, then calls it from the cache from there on. This connection is the base
     * for all queries.
     *
     * @return a cached or newly updated connection
     * @throws java.sql.SQLException
     */
    protected final Connection getConnection() throws SQLException {
        if (current == null)
            reconnect();
        return current;
    }

    /**
     * Creates a <code>Statement</code> object for sending
     * SQL statements to the database.
     * SQL statements without parameters are normally
     * executed using <code>Statement</code> objects. If the same SQL statement
     * is executed many times, it may be more efficient to use a
     * <code>PreparedStatement</code> object. This method creates new statements each
     * call to avoid constricting previous queries.
     *
     * @return a new statement to send SQL statements to the database
     * @throws java.sql.SQLException
     */
    protected final Statement getStatement() throws SQLException {
        return getConnection().createStatement();
    }

    /**
     * Creates a <code>CallableStatement</code> object for calling
     * database stored procedures.
     * The <code>CallableStatement</code> object provides
     * methods for setting up its IN and OUT parameters, and
     * methods for executing the call to a stored procedure.
     *
     * @param sql an SQL statement that may contain one or more '?'
     *            parameter placeholders. Typically this statement is specified using JDBC
     *            call escape syntax.
     * @return a new default <code>CallableStatement</code> object containing the
     *         pre-compiled SQL statement
     * @throws java.sql.SQLException
     */
    public CallableStatement prepare(String sql) throws SQLException {
        return getConnection().prepareCall(sql);
    }

    /**
     * Keeps the current login data in tact but resets the cached connection.
     * This method makes use of a fluent interface to be able to easily reset the credentials in-line.
     *
     * @return a reference to this object
     * @throws java.sql.SQLException
     */
    public final SQLConnection reconnect() throws SQLException {
        return reconnect(username, password);
    }

    /**
     * Executes the given SQL statement, which returns a single
     * <code>ResultSet</code> object.
     *
     * @param sql an SQL statement to be sent to the database, typically a
     *            static SQL <code>SELECT</code> statement
     * @return a <code>ResultSet</code> object that contains the data produced
     *         by the given query; never <code>null</code>
     * @throws java.sql.SQLException
     */
    public ResultSet query(String sql) throws SQLException {
        return getStatement().executeQuery(sql);
    }
}
