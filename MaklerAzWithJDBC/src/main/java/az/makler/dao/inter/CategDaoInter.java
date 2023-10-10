/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package az.makler.dao.inter;

import az.makler.entity.Category;
import java.util.List;

/**
 *
 * @author sofiya.mammadova
 */
public interface CategDaoInter {
    void insert(Category category);
    void update(Category category);
    void delete(int id);
    Category getCategById(int id);
    List<Category> getAllCateg();
    
}
