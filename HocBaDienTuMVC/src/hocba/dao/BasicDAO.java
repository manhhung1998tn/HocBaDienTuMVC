package hocba.dao;
import java.sql.*;



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
public class BasicDAO{
    //Bo quan ly ket noi de Basic su dung
    private ConnectionPool cp;

    //ket noi de Basic lam viec voi CSDL
    protected Connection conn;

    //Ten doi tuong lam viec voi basic
    private String objectName;





    protected BasicDAO(ConnectionPool cp, String objectName) {
        //Xac dinh doi tuong lam viec voi Basic
        this.objectName = objectName;

        //Xac dinh bo quan ly ket noi
        if(cp == null){
            this.cp = new ConnectionPool();
        }else{
            this.cp = cp;
        }


        //Hoi xin ket noi thong qua bo quan ly
        try {
            this.conn = this.cp.getConnection(this.objectName);
            //Kiem tra che do thuc thi cua ket noi

            if(this.conn.getAutoCommit()){
                //Cham dut che do thuc thi tu dong
                this.conn.setAutoCommit(false);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    private synchronized boolean exe(PreparedStatement pre){
        if(pre != null){
            //Thuc thi cap nhat
            try {
                int results = pre.executeUpdate();
                
                if(results == 0){
                    this.conn.rollback();
                    return false;
                }


                //Xac nhan thuc thi sau cung;
                this.conn.commit();
                return true;
            } catch (SQLException ex) {
                ex.printStackTrace();

                //Tro lai trang thai an toan
                try{
                    this.conn.rollback();
                }catch(SQLException ex1){
                    ex1.printStackTrace();
                }

            }finally{
                pre = null;
            }
        }


        return false;
    }

    protected boolean add(PreparedStatement pre) {
        return exe(pre);
    }



    protected boolean edit(PreparedStatement pre) {
        return exe(pre);
    }



    protected boolean del(PreparedStatement pre) {
        return exe(pre);
    }


    protected synchronized ResultSet get(String sql, int value) {
        PreparedStatement pre = null;
        //System.out.println("basic get(sql,value):" + value);
        try {
            pre = this.conn.prepareStatement(sql);
            if(value > 0){
                
                pre.setInt(1,value);

            }

            return pre.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();

            try {
                this.conn.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace();
            }
        }finally{
            sql = null;
        }




        return null;
    }

    protected ResultSet get(String sql, String name, String pass) {
        PreparedStatement pre = null;


        try {
            pre = this.conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, pass);

            return pre.executeQuery();


        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                this.conn.rollback();
            } catch (SQLException ex1) {
            }
        }finally{
            sql = null;
            name = null;
            pass = null;
        }


        return null;
    }

    protected ResultSet gets(String sql) {
        return this.get(sql,0);
    }


    protected ResultSet[] gets(String sqls[]) {
        ResultSet[] tmp = new ResultSet[sqls.length];
        for(int i = 0; i < tmp.length; ++i){
            tmp[i] = this.get(sqls[i],0);
        }
       return tmp;
   }


    public ConnectionPool getCP() {

        return this.cp;

    }

    public void releaseConnection() {
        try{
            this.cp.releaseConnection(this.conn,this.objectName);
        }catch(SQLException ex){
            ex.printStackTrace();
        }


    }



}
