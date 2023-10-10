/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.makler.dao.impl;

import az.makler.config.AbstractDao;
import static az.makler.config.AbstractDao.connect;
import az.makler.dao.inter.CategDaoInter;
import az.makler.entity.Agentlik;
import az.makler.entity.Category;
import az.makler.entity.Elan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sofiya.mammadova
 */
public class CategDaoImpl extends AbstractDao implements CategDaoInter {

    @Override
    public void insert(Category category) {
        try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class      
//posle zavershenia raboti, on auto zakroet connection. Eto nazivaetsa try with resource
            PreparedStatement st = conn.prepareStatement("insert into makleraz.category(category_name)\n" + "values(?)");
            //teper sdelaem set etih ? znakov vnutri values
            st.setString(1, category.getCategory_name());
            st.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Category category) {
       try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class 
            //posle zavershenia raboti, on auto zakroet connection. Eto nazivaetsa try with resource
            PreparedStatement st = conn.prepareStatement("update makleraz.category set category_name=? where category_id=?");
            //teper sdelaem set etih ? znakov vnutri values
            st.setString(1, category.getCategory_name());
            st.setInt(2, category.getCategory_id()); //mi dolzni peredat elan_id, chyi dannie on updatenet (where elan_id=?)
            st.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class 
           Statement st = conn.createStatement();
             st.execute("delete from makleraz.category where category_id="+id);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Category getCategById(int id) {
         Category c = null;
         try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class 
           Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select* from makleraz.category where category_id="+id); //executeQuery, t.k. mi pishem select
             //getAllInfo - eto mi sozdali view:
             //create view getAllInfo as select* from makleraz.elan inner join makleraz.category using(category_id) left join makleraz.agentlik using(agent_id);
            while(rs.next()){ //do teh por, poka est sled zapis, t.e poka ne konec, to delay get 
               c = getCategory(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return c;
    }

    @Override
    public List<Category> getAllCateg() {
       List<Category> list = new ArrayList();
         try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class 
           Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select* from makleraz.category"); //executeQuery, t.k. mi pishem select

            while(rs.next()){ //do teh por, poka est sled zapis, t.e poka ne konec, to delay get
            Category c = getCategory(rs);
            list.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return list;
    }
    
    public Category getCategory(ResultSet rs) throws SQLException{
           int category_id = rs.getInt("category_id");
           String category_name = rs.getString("category_name");           
           
           return new Category(category_id, category_name);
    
    }
    
}
