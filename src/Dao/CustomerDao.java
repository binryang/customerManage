package Dao;

import domain.CriteriaCustomer;
import domain.Customer;

import java.util.List;

/**
 * Created by yangrb on 17-7-17.
 */
public interface CustomerDao {
    public List<Customer> getAll(int page);

    public void edit(Customer customer);

    public Customer get(Integer id);

    public void delete(Integer id);

    public long getcountwithName(String name);

    public void save(Customer customer);

    public List<Customer> getAllWithCC(CriteriaCustomer criteriaCustomer,int page);

    public long getcountwithCC(CriteriaCustomer criteriaCustomer);

    public long getcountwithAll();
}
