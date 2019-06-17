package com.util;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DBO {
    private static Session session ;
    private static Transaction tran = null;
    public static Session getSession(){
        session = HibernateUtils.getSessionobject();
        return session;
    }

    /**
     * @param obj 添加数据
     * @return
     */
    public static boolean add(Object obj)
    {
        boolean result=false;
        try
        {
            session=getSession();
            tran=session.beginTransaction();
            session.save(obj);
            tran.commit();
            result=true;
        }
        catch (Exception e)
        {
            if(tran!=null)
            {
                //事物回滚
                tran.rollback();
            }
        }
        finally
        {

        }
        return result;
    }
    /**
     * @return 更新数据
     * 参数为修改的主键id对象
     */
    public static boolean update(Object object)
    {
        boolean result=false;
        try
        {
            session=getSession();
            tran=session.beginTransaction();
            session.update(object);
            tran.commit();
            result=true;
        }
        catch (Exception e)
        {
            if(tran!=null)
            {
                //事物回滚
                tran.rollback();
            }
        }
        finally
        {

        }
        return result;
    }
    /**
     * @param c
     * @param id  查询一条数据根据主键的id号
     * @return
     */
    public static Object get(Class c,int id)
    {
        Object object=null;
        try
        {
            session=getSession();
            tran=session.beginTransaction();
            object=session.get(c,id);
            tran.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(session!=null)
            {
            }
        }
        return object;
    }
    /**
     * @param obj
     * @return 删除数据
     */
    public static boolean delete(Object obj)
    {
        boolean result=false;
        try
        {
            session=getSession();
            tran=session.beginTransaction();
            session.delete(obj);
            tran.commit();
            result=true;
        }
        catch (Exception e)
        {
            if(tran!=null)
            {
                //事物回滚
                tran.rollback();
            }
        }
        finally
        {
            if(session!=null)
            {

            }
        }
        return result;
    }

    /**
     * @param <T> 查询多条记录
     * @param hql  sql语句
     * @param param 参数数组
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> query(String hql, String[] param)
    {
        List<T> list=null;
        try
        {
            session=getSession();
            tran=session.beginTransaction();
            Query query=session.createQuery(hql);

            if(param!=null)
            {
                for(int i=0;i<param.length;i++)
                {
                    query.setParameter(i,param[i]);
                }
            }
            list=query.list();
            tran.commit();
        }

        catch (Exception e)
        {
            tran.rollback();
        }
        finally
        {
            if(session!=null)
            {

            }
        }
        return list;
    }

    public static <T> List<T> query(String hql, int[] param)
    {
        List<T> list=null;
        try
        {
            session=getSession();
            tran=session.beginTransaction();
            Query query=session.createQuery(hql);

            if(param!=null)
            {
                for(int i=0;i<param.length;i++)
                {
                    query.setParameter(i,param[i]);
                }
            }
            list=query.list();
            tran.commit();
        }

        catch (Exception e)
        {
            tran.rollback();
        }
        finally
        {
            if(session!=null)
            {

            }
        }
        return list;
    }

    /**
     * @param hql
     * @param param 查询单条记录
     * @return
     */
    public static Object queryOne(String hql,String[] param)
    {
        Object object=null;
        try
        {
            session=getSession();
            tran = session.beginTransaction();
            Query query=session.createQuery(hql);
            if(param!=null)
            {
                for(int i=0;i<param.length;i++)
                {
                    query.setParameter(i,param[i]);
                }

            }
            object=query.uniqueResult();
            tran.commit();
        }

        catch (Exception e)
        {
            tran.rollback();
        }
        finally
        {
            if(session!=null)
            {
            }
        }
        return object;
    }
    public static Object queryOne(String hql,int[] param)
    {
        Object object=null;
        try
        {
            session=getSession();
            tran = session.beginTransaction();
            Query query=session.createQuery(hql);
            if(param!=null)
            {
                for(int i=0;i<param.length;i++)
                {
                    query.setParameter(i,param[i]);
                }

            }
            object=query.uniqueResult();
            tran.commit();
        }

        catch (Exception e)
        {
            tran.rollback();
        }
        finally
        {
            if(session!=null)
            {
            }
        }
        return object;
    }
    /**
     * @param <T>
     * @param sql
     * @param param
     * @param page
     * @param size
     * @return 实现分页查询
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> queryByPage(String sql,String[] param,int page,int size)
    {
        List<T> list=new ArrayList<T>();
        try
        {
            session=getSession();
            tran = session.beginTransaction();
            Query query=session.createQuery(sql);
            if(param!=null)
            {
                for(int i=0;i<param.length;i++)
                {
                    query.setString(i,param[i]);
                }
            }
            //筛选条数
            query.setFirstResult((page-1)*size);
            query.setMaxResults(size);
            list=query.list();
            tran.commit();
        }

        catch (Exception e)
        {
            tran.rollback();
        }
        finally
        {
            if(session!=null)
            {

            }
        }
        return list;
    }
    public static <T> List<T> queryByPage(String sql,int[] param,int page,int size)
    {
        List<T> list=new ArrayList<T>();
        try
        {
            session=getSession();
            tran = session.beginTransaction();
            Query query=session.createQuery(sql);
            if(param!=null)
            {
                for(int i=0;i<param.length;i++)
                {
                    query.setParameter(i,param[i]);
                }
            }
            //筛选条数
            query.setFirstResult((page-1)*size);
            query.setMaxResults(size);
            list=query.list();
            tran.commit();
        }

        catch (Exception e)
        {
            tran.rollback();
        }
        finally
        {
            if(session!=null)
            {

            }
        }
        return list;
    }
    /**
     * @param hql
     * @param pras
     * @return返回数据个数
     */
   /* public static int getCount(String hql, String[] pras) {
        int resu = 0;
        try {
            session = getSession();
            tran = session.beginTransaction();
            Query q = session.createQuery(hql);
            if (pras != null) {
                for (int i = 0; i < pras.length; i++) {
                    q.setString(i, pras[i]);
                }
            }
            resu = Integer.valueOf(q.iterate().next().toString());
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return resu;
    }*/

    public static int getCount(String hql,String[] pras) {
        int resu=0;
        try {
            session = getSession();
            tran = session.beginTransaction();
            hql = "select count(*) "+hql;
            Query q = session.createQuery(hql);
            if (pras != null) {
                for (int i = 0; i < pras.length; i++) {
                    q.setString(i, pras[i]);
                }
            }
            Object object = q.uniqueResult();
            long l = Long.valueOf(String.valueOf(object));
            resu= new Long(l).intValue();
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return resu;
    }
    public static int getCount(String hql,int[] pras) {
        int resu=0;
        try {
            session = getSession();
            tran = session.beginTransaction();
            hql = "select count(*) "+hql;
            Query q = session.createQuery(hql);
            if (pras != null) {
                for (int i = 0; i < pras.length; i++) {
                    q.setParameter(i, pras[i]);
                }
            }
            Object object = q.uniqueResult();
            long l = Long.valueOf(String.valueOf(object));
            resu= new Long(l).intValue();
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return resu;
    }
}
