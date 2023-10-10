/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package az.makler.config;

import az.makler.dao.impl.AgentDaoImpl;
import az.makler.dao.impl.CategDaoImpl;
import az.makler.dao.impl.ElanDaoImpl;
import az.makler.dao.inter.AgentDaoInter;
import az.makler.dao.inter.CategDaoInter;
import az.makler.dao.inter.ElanDaoInter;

/**
 *
 * @author sofiya.mammadova
 */
public class Context {
    public static ElanDaoInter instanceElanDao(){
    return new ElanDaoImpl();
    }
    
    public static CategDaoInter instanceCategDao(){
    return new CategDaoImpl();
    }
    
    public static AgentDaoInter instanceAgentDao(){
    return new AgentDaoImpl();
    }
    
}
