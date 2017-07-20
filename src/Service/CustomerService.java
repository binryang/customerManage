package Service;


import Dao.Dao;
import domain.CriteriaCustomer;
import domain.Customer;
import Dao.CustomerDao;

import java.util.List;

/**
 * Created by yangrb on 17-7-17.
 */
public class CustomerService extends Dao<Customer> implements CustomerDao{
    /**
     * 获得所有的列表
     * @return
     */
    @Override
    public List<Customer> getAll() {
        String sql = "SELECT id,name,gender,phone,email,description FROM customer";
        return this.getForLIst(sql);
    }

    /**
     * 编辑客户信息
     * @param customer
     */
    @Override
    public void edit(Customer customer) {
        String sql = "UPDATE customer SET name=?,gender=?,phone=?,email=?,description=? WHERE id=?";
        this.update(sql,customer.getName(),customer.getGender(),customer.getPhone(),customer.getEmail(),
                customer.getDescription(), customer.getId());
    }

    /**
     * 通过id返回Customer对象
     * @param id
     * @return
     */
    @Override
    public Customer get(Integer id) {
        String sql = "SELECT id,name,gender,phone,email,description FROM customer WHERE id = ?";
        return this.get(sql,id);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM customer WHERE id = ?";
        this.update(sql,id);
    }

    @Override
    public long getcountwithName(String name) {
        String sql = "SELECT count(id) FROM customer WHERE name = ?";
        return this.getForValue(sql,name);
    }

    @Override
    public void save(Customer customer) {
        String sql = "INSERT INTO customer(name,gender,phone,email,description) VALUES(?,?,?,?,?)";
        this.update(sql,customer.getName(),customer.getGender(),customer.getPhone(),customer.getEmail(),
                customer.getDescription());
    }

    @Override
    public List<Customer> getAllWithCC(CriteriaCustomer criteriaCustomer) {
        String sql = "SELECT id,name,gender,phone,email,description FROM customer WHERE name LIKE ? AND gender LIKE ? AND phone LIKE ? AND email LIKE ? AND description LIKE ?";
        return this.getForLIst(sql,criteriaCustomer.getName(),criteriaCustomer.getGender(),criteriaCustomer.getPhone(),
                criteriaCustomer.getEmail(),criteriaCustomer.getDescription());
    }

    public CustomerService() {
        super();
    }
}
