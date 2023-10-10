/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.makler.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sofiya.mammadova
 */
public abstract class AbstractDao {
    public static Connection connect() throws SQLException{
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/makleraz", "root", "1234");
    //zdes try-catch ne delaem, a delaem throws, t.e mi connection budem ispolzovat i v insert, i v update i td
    //pri ispolzovanii try-catch viydet 1 i ta zhe oshibka, mol, pri inserte vidast 1 oshibku, pri update - druquyu, chtobi bilo ponatno, v kakoy imenno chasti v connectione u nas oshibka
    return conn;
    }
    
    
}
