package hocba.dao;

import java.sql.*;

import java.util.*;

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
public class ConnectionPool{

    //Trinh dieu khien lam viec voi co so du lieu
    private String driver;

    //Duong Dan thuc thi (mySQL)

    private String url;


    //Tai Khoan Dang Nhap Co So Du Lieu
    private String username;
    private String password;

    private Stack<Connection> pool;
    private String driverManager;

    public ConnectionPool(){
        //Xac dinh trinh dieu khuyen

        //Xac Dinh DUong Dan Thuc Thi

        //Xac Dinh Tai Khoan Lam Viec
    	 this.driver = "com.mysql.jdbc.Driver";
    	
    	
    	
        this.username = "root";
        this.password = "123";
       
        this.url = "jdbc:mysql://localhost:3306/hocbadientu_data";
        
        
    	/*  
    	this.username = "root";
        this.password = "e13acB02gP";
        this.url = "jdbc:mysql://node194099-sagamaru.jelastic.servint.net:3306/hocbadientu_data";
         
   
  */
        try {
            Class.forName(this.driver).newInstance();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        }


        //Khoi tao doi tuong luu chu
        this.pool = new Stack<Connection>();
    }




    /**
     * this method to get Connection from Stack  - Nguyen Manh Hung
     * @version 01-29/9/2018
     *
     * @param objectName String
     * @return Connection
     * @throws SQLException
     */
    public Connection getConnection(String objectName) throws SQLException {
        //Kiem tra co ket noi
        if(this.pool.isEmpty()){
            System.out.println(objectName + "have created new Connection.");
            return DriverManager.getConnection(this.url,this.username, this.password);

        }else{
            //Lay ket noi da ton tai
            System.out.println(objectName + "have poped the Connection");
            return (Connection) this.pool.pop();
        }



    }


    /**
     * this method release Connection for Stack
     * @param conn Connection
     * @param objectName String
     * @throws SQLException
     */
    public void releaseConnection(Connection conn, String objectName) throws SQLException {
        //Yeu cau tra lai ket noi
        System.out.println(objectName + "Have pushed the Connection.");
        this.pool.push(conn);


    }

    protected void finalize() throws Throwable{
        this.pool.clear();
        this.pool = null;

        super.finalize();
        System.out.println("CP is closed");
    }

    public static void main(String[] args){
        ConnectionPool cp = new ConnectionPool();
        try {
			Connection con = cp.getConnection("test");
			
			if(con != null) {
				System.out.println("Thanh cong");
			}else {
				System.out.println("fail");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



    }





}
