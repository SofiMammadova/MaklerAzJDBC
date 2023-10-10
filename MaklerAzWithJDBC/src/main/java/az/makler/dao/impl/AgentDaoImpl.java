/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.makler.dao.impl;

import az.makler.config.AbstractDao;
import static az.makler.config.AbstractDao.connect;
import az.makler.dao.inter.AgentDaoInter;
import az.makler.entity.Agentlik;
import az.makler.entity.Category;
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
public class AgentDaoImpl extends AbstractDao implements AgentDaoInter{

    @Override
    public void insert(Agentlik agent) {
        try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class      
//posle zavershenia raboti, on auto zakroet connection. Eto nazivaetsa try with resource
            PreparedStatement st = conn.prepareStatement("insert into makleraz.agentlik(agent_name, contact)\n" + "values(?, ?)");
            //teper sdelaem set etih ? znakov vnutri values
            st.setString(1, agent.getAgent_name());
            st.setString(2, agent.getContact());
            st.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Agentlik agent) {
        try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class 
            //posle zavershenia raboti, on auto zakroet connection. Eto nazivaetsa try with resource
            PreparedStatement st = conn.prepareStatement("update makleraz.agentlik set agent_name=?, contact=? where agent_id=?");
            //teper sdelaem set etih ? znakov vnutri values
            st.setString(1, agent.getAgent_name());
            st.setString(2, agent.getContact());
            st.setInt(3, agent.getAgent_id()); //mi dolzni peredat elan_id, chyi dannie on updatenet (where elan_id=?)
            st.execute();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class 
           Statement st = conn.createStatement();
             st.execute("delete from makleraz.agentlik where agent_id="+id);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Agentlik getAgentById(int id) {
        Agentlik a = null;
         try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class 
           Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select* from makleraz.agentlik where agent_id="+id); //executeQuery, t.k. mi pishem select
             //getAllInfo - eto mi sozdali view:
             //create view getAllInfo as select* from makleraz.elan inner join makleraz.category using(category_id) left join makleraz.agentlik using(agent_id);
            while(rs.next()){ //do teh por, poka est sled zapis, t.e poka ne konec, to delay get 
               a = getAgentlik(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return a;
    }

    @Override
    public List<Agentlik> getAllAgent() {
         List<Agentlik> list = new ArrayList();
         try(Connection conn = connect()){       //zdes connect - eto to, chto vozvrashaet abstract class 
           Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select* from makleraz.agentlik"); //executeQuery, t.k. mi pishem select

            while(rs.next()){ //do teh por, poka est sled zapis, t.e poka ne konec, to delay get
            Agentlik a = getAgentlik(rs);
            list.add(a);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
         return list;
    }
    
    
    public Agentlik getAgentlik(ResultSet rs) throws SQLException{
           int agent_id = rs.getInt("agent_id");
           String agent_name = rs.getString("agent_name");
           String contact = rs.getString("contact");
           
           return new Agentlik(agent_id, agent_name, contact);
    
    }
    
}
