package Dao;

import Db.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

/**
 * Created by yangrb on 17-7-16.
 */
/*
CRUD
 */
public class Dao<T> {
    private QueryRunner queryRunner = new QueryRunner();

    private Class<T> clazz;
    /*
    利用反射
     */
    public Dao(){
        Type superClass = this.getClass().getGenericSuperclass();//返回该类继承的带有泛型的父类
        if(superClass instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) superClass;
            Type[] types = parameterizedType.getActualTypeArguments(); //获得此类型参数类型，返回Type数组 即dao<T> 的T
            if (types!=null&&types.length>0){
                clazz = (Class<T>) types[0];//返回当前的T  Customer
            }
        }
    }

    /**
     * 返回某一个字段
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    public <E> E getForValue(String sql,Object ... args){
        Connection connection = null;
        try{
            connection = JdbcUtils.getConnection();
            return (E) queryRunner.query(connection,sql,new ScalarHandler(),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.ReleaseConnection(connection);
        }
        return null;
    }

    /**
     *  返回T类型的List
     * @param sql
     * @param args
     * @return
     */
    public List<T> getForLIst(String sql,Object ... args){
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection,sql,new BeanListHandler<T>(clazz),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.ReleaseConnection(connection);
        }
        return null;
    }

    /**
     * 返回一个T类型的对象
     * @param sql
     * @param args
     * @return
     */
    public T get(String sql,Object ... args){
        Connection connection = null;
        try {
            connection = JdbcUtils.getConnection();
            return queryRunner.query(connection,sql,new BeanHandler<T>(clazz),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.ReleaseConnection(connection);
        }
        return null;
    }

    public void update(String sql,Object ... args){
        Connection connection = null;
        try{
            connection = JdbcUtils.getConnection();
            queryRunner.update(connection,sql,args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JdbcUtils.ReleaseConnection(connection);
        }
    }
}
