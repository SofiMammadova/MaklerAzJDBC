/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package az.makler.maklerazwithjdbc;

import az.makler.config.Context;
import az.makler.dao.inter.AgentDaoInter;
import az.makler.dao.inter.CategDaoInter;
import az.makler.dao.inter.ElanDaoInter;
import az.makler.entity.Agentlik;
import az.makler.entity.Category;
import az.makler.entity.Elan;

/**
 *
 * @author sofiya.mammadova
 */
public class MaklerAzWithJDBC {

    public static void main(String[] args) {
        
        //ELAN
      /*  ElanDaoInter edao = new ElanDaoImpl();
       // ElanDaoInter edao = new ElanDaoImplWithOracle(); //pri rabote s oracle
        edao.getAllElan(); */
      
      //insert:
     /* Elan e = new Elan(11, "Satilir", 7, 75, "Neftchiler", new Category(1), new Agentlik(1)); //zdes dla category i dla agentlik budem ispolzovat sleduyusheye
      //v entity i dla category i dla agentlik vizovem constructor dla id (tşe agent_id i category_id) 
        //System.out.println(e);
        ElanDaoInter edao = Context.instanceElanDao(); //obrashaemsa v Context, a ottuda perehodim v DaoImpl, chtob vizvat insert i zapisat v bazu
        edao.insert(e); //zapis v bazu */
        
 
        // update:  
      /*  Elan e = new Elan(11, "Satilir", 7, 75, "Neftchiler", new Category(1), new Agentlik(1)); //zdes dla category i dla agentlik budem ispolzovat sleduyusheye
        e.setTip("Satilir");
        ElanDaoInter edao = Context.instanceElanDao(); //obrashaemsa v Context, a ottuda perehodim v DaoImpl, chtob vizvat insert i zapisat v bazu
        edao.update(e); //update */
      
      //getElanById:
     /* ElanDaoInter edao = Context.instanceElanDao();
        System.out.println(edao.getElanById(2)); */
     
     //getAllElan:
    /* ElanDaoInter edao = Context.instanceElanDao();
        System.out.println(edao.getAllElan());*/
     //ELAN (END)
     
 //******************************************************************************************    
     //CATEGORY
     
     //insert:
    /* Category c = new Category(5, "Obyekt");
     CategDaoInter cdao = Context.instanceCategDao();
     cdao.insert(c); */ //t.k enum - raborat ne budet
     
     
     //update:
     /* Category c = new Category(5, "Obyekt");
      c.setCategory_name("Yeni tikili");
      CategDaoInter cdao = Context.instanceCategDao();
      cdao.update(c); //update */
     
     //delete
   /* Category c = new Category(5, "Obyekt");
     CategDaoInter cdao = Context.instanceCategDao();
     cdao.delete(5); */
   
   //getCategById
 /*     CategDaoInter cdao = Context.instanceCategDao();
        System.out.println(cdao.getCategById(3)); */
 
 //getAllCateg:
  /*    CategDaoInter cdao = Context.instanceCategDao();
        System.out.println(cdao.getAllCateg()); */     
     
     //CATEGORY(END)
     
 //******************************************************************************    
     
     //AGENTLIK
     
     //insert:
   /*  Agentlik a = new Agentlik(4, "CDC", "0554445566");
     AgentDaoInter adao = Context.instanceAgentDao();
     adao.insert(a); */
     
     //update:
    /* Agentlik a = new Agentlik(4, "CDC", "0554445566");
     a.setAgent_name("CDC_LTD");
     //a.setContact("0554449977");
     AgentDaoInter adao = Context.instanceAgentDao();
     adao.update(a); */
     
     
     //delete:
   /*  Agentlik a = new Agentlik(4, "CDC", "0554445566");
     AgentDaoInter adao = Context.instanceAgentDao();
     adao.delete(4); */
     
     //getAgentById:
    /* AgentDaoInter adao = Context.instanceAgentDao();
        System.out.println(adao.getAgentById(4)); */
     
     
     //getAllAgent:
   /*  AgentDaoInter adao = Context.instanceAgentDao();
        System.out.println(adao.getAllAgent()); */
     
     //AGENTLIK(END)
        
    }
    
}
