package hocba.dao;

/**
 * <p>Title: JP1802</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2018</p>
 *
 * <p>Company: </p>
 *
 * @author ManhHung
 * @version 1.0
 */

public interface ShareControl{
    public ConnectionPool getCP();
    public void releaseConnection();

}
