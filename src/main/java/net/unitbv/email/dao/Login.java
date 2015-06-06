package net.unitbv.email.dao;

import net.unitbv.email.dao.util.DaoUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created with IntelliJ IDEA.
 * User: sidona
 * Date: 6/6/15
 * Time: 4:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Login {
    public static boolean validate(String name,String pass){
        boolean status=false;
        try{
            Connection connection = DaoUtil.getConnection();
            //Statement statement = connection.createStatement();

            PreparedStatement ps=connection.prepareStatement("select * from login where username=? and password=?");
            ps.setString(1,name);
            ps.setString(2,pass);

            ResultSet rs=ps.executeQuery();
            status=rs.next();


        }catch(Exception e){System.out.println(e);}
        return status;
    }
}


