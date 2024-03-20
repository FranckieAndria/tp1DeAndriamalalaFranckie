/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.andriamalalafranckie.tp1.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;
import mg.itu.andriamalalafranckie.tp1.entity.Customer;

/**
 * Façade pour gérer les Customers
 *
 * @author andriamalala
 */
@RequestScoped
public class CustomerManager {

    @PersistenceContext
    private EntityManager em;

    public void persist(Customer customer) {
        em.persist(customer);
    }

    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    public Customer findById(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }

    @Transactional
    public Customer update(Customer customer) {
        return em.merge(customer);
    }

}
