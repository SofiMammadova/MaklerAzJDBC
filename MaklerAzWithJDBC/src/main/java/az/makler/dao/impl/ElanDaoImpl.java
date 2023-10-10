/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.makler.dao.impl;

import az.makler.config.AbstractDao;
import az.makler.dao.inter.ElanDaoInter;
import az.makler.entity.Agentlik;
import az.makler.entity.Category;
import az.makler.entity.Elan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sofiya.mammadova
 */
public class ElanDaoImpl extends AbstractDao implements ElanDaoInter {

    @Override
    public void insert(Elan elan) {
        //try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/makleraz", "root", "Sofi0123456789");) { //t.k. pri otkritii lyuboqo connectiona nado ego zakricvat posle zaversheniya, poetomu mi napisali eto vnutri TRY
          try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class      
//posle zavershenia raboti, on auto zakroet connection. Eto nazivaetsa try with resource
            PreparedStatement st = conn.prepareStatement("insert into makleraz.elan(tip, mertebe, sahe, unvan, category_id, agent_id)\n" + "values(?,?,?,?,?,?)");
            //teper sdelaem set etih ? znakov vnutri values
            st.setString(1, elan.getTip());
            st.setInt(2, elan.getMertebe());
            st.setInt(3, elan.getSahe());
            st.setString(4, elan.getUnvan());
            st.setInt(5, elan.getCategory().getCategory_id()); //t.k eto mi berem iz druqoy tablici, t.e eto u nas constraint references v baze mysql
            st.setInt(6, elan.getAgentlik().getAgent_id());
            st.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Elan elan) {
        //try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/makleraz", "root", "Sofi0123456789");) { //t.k. pri otkritii lyuboqo connectiona nado ego zakricvat posle zaversheniya, poetomu mi napisali eto vnutri TRY           
            //vo izbejanie povtora vospolzuemsa AbstractDao classom iz configa
            try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class 
            //posle zavershenia raboti, on auto zakroet connection. Eto nazivaetsa try with resource
            PreparedStatement st = conn.prepareStatement("update makleraz.elan set tip=?, mertebe=?, sahe=?, unvan=?, category_id=?, agent_id=? where elan_id=?");
            //teper sdelaem set etih ? znakov vnutri values
            st.setString(1, elan.getTip());
            st.setInt(2, elan.getMertebe());
            st.setInt(3, elan.getSahe());
            st.setString(4, elan.getUnvan());
            st.setInt(5, elan.getCategory().getCategory_id()); //t.k eto mi berem iz druqoy tablici, t.e eto u nas constraint references v baze mysql
            st.setInt(6, elan.getAgentlik().getAgent_id());
            st.setInt(7, elan.getElan_id()); //mi dolzni peredat elan_id, chyi dannie on updatenet (where elan_id=?)
            st.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class 
           Statement st = conn.createStatement();
             st.execute("delete from makleraz.elan where elan_id="+id);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Elan getElanById(int id) {
        Elan e = null;
         try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class 
           Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select* from getAllInfo where elan_id="+id); //executeQuery, t.k. mi pishem select
             //getAllInfo - eto mi sozdali view:
             //create view getAllInfo as select* from makleraz.elan inner join makleraz.category using(category_id) left join makleraz.agentlik using(agent_id);
            while(rs.next()){ //do teh por, poka est sled zapis, t.e poka ne konec, to delay get
            /*   int elan_id = rs.getInt("elan_id");
               String tip = rs.getString("tip");
               int mertebe = rs.getInt("mertebe");
               int sahe = rs.getInt("sahe");
               String unvan = rs.getString("unvan");
               Category category = new Category(rs.getInt("category_id"), rs.getString("category_name"));
               Agentlik agentlik = new Agentlik(rs.getInt("agent_id"), rs.getString("agent_name"), rs.getString("contact"));
            
            e = new Elan(elan_id, tip, mertebe, sahe, unvan, category, agentlik); */ //chtobi izbajet povtora, sdelaem nijesleduyusheye:
            e = getElan(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return e;
    }

    @Override
    public List<Elan> getAllElan() {
        List<Elan> list = new ArrayList();
         try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class 
           Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select* from getAllInfo"); //executeQuery, t.k. mi pishem select
             //getAllInfo - eto mi sozdali view:
             //create view getAllInfo as select* from makleraz.elan inner join makleraz.category using(category_id) left join makleraz.agentlik using(agent_id);
            while(rs.next()){ //do teh por, poka est sled zapis, t.e poka ne konec, to delay get
              /* int elan_id = rs.getInt("elan_id");
               String tip = rs.getString("tip");
               int mertebe = rs.getInt("mertebe");
               int sahe = rs.getInt("sahe");
               String unvan = rs.getString("unvan");
               Category category = new Category(rs.getInt("category_id"), rs.getString("category_name"));
               Agentlik agentlik = new Agentlik(rs.getInt("agent_id"), rs.getString("agent_name"), rs.getString("contact"));
            
            Elan e = new Elan(elan_id, tip, mertebe, sahe, unvan, category, agentlik); */ //chtobi izbajet povtora, sdelaem nijesleduyusheye:
            Elan e = getElan(rs);
            list.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return list;
    }
    
    //chtobi izbezhat pvtora v fetAllElan i getElanById sdelaem sleduyusheye:
    public Elan getElan(ResultSet rs) throws SQLException{
           int elan_id = rs.getInt("elan_id");
           String tip = rs.getString("tip");
           int mertebe = rs.getInt("mertebe");
           int sahe = rs.getInt("sahe");
           String unvan = rs.getString("unvan");
           Category category = new Category(rs.getInt("category_id"), rs.getString("category_name"));
           Agentlik agentlik = new Agentlik(rs.getInt("agent_id"), rs.getString("agent_name"), rs.getString("contact"));
           
           return new Elan(elan_id, tip, mertebe, sahe, unvan, category, agentlik);
    
    }
    
    
}
