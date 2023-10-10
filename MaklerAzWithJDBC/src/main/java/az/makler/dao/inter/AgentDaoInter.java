/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package az.makler.dao.inter;

import az.makler.entity.Agentlik;
import java.util.List;

/**
 *
 * @author sofiya.mammadova
 */
public interface AgentDaoInter {
    void insert(Agentlik agent);
    void update(Agentlik agent);
    void delete(int id);
    Agentlik getAgentById(int id);
    List<Agentlik> getAllAgent();
    
    
}
