package com.test;


import com.entity.*;
import com.util.DBO;
import com.util.HibernateUtils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class HibernateDemo {

    public static void testUser(){
        //Major major = (Major) DBO.get(Major.class,1);
        User user = new User();
        user.setPassword("asd123445000");
        DBO.add(user);
        user.setUsername("哈哈哈");
        String s[] = new String[]{"经管"};
        Major major = (Major)DBO.queryOne("from Major where major = ?",s);
        user.setMajor(major);
        DBO.update(user);
    }
    public static void testDBOqueryone(){

        //User user = (User) DBO.queryOne("from User u where u.id=?",s);
        /*System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        System.out.println(user.getGender());*/
        //System.out.println(user.getMajor());
        ///System.out.println(user.getPhone());
        //System.out.println(user.getSid());
        //System.out.println(user.getRealname());
        //System.out.println(user);

    }
    public static void testDBOupdate(){
        Guestbook guestbook = new Guestbook();
        guestbook.setId(3);
        guestbook.setContent("hello");
        DBO.update(guestbook);
    }
    public static void testDBOadd(){
        Guestbook guestbook = new Guestbook();
        guestbook.setContent("fuck");
        DBO.add(guestbook);
    }
    public static void testMajor(){
        Session session = HibernateUtils.getSessionobject();
        Transaction tx = session.beginTransaction();

       /* Major major = new Major();
        major.setMajor("服务科学与工程");

        User user = new User();
        user.setUsername("田世先");
        user.setPassword("asd");

        Book book =new Book();
        book.setBookname("计算机网络");

        Booktype booktype = new Booktype();
        booktype.setType("计算机类");
        booktype.getBookSet().add(book);

        major.getUserSet().add(user);
        session.save(major);
        session.save(booktype);*/
       Admin admin = new Admin();
       admin.setPassword("234");
       admin.setUsername("qwrr");

       Affiche affiche = new Affiche();
       affiche.setContent("hello world");

       Guestbook guestbook = new Guestbook();
       guestbook.setContent("ads");
       session.save(guestbook);

       admin.getAfficheSet().add(affiche);
       session.save(admin);

        tx.commit();
    }
    //条件查询
    public static void testHql2(){
        Session session = HibernateUtils.getSessionobject();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from User u where u.username=? and u.password=?");
        query.setParameter(0,"卢奕阳");
        query.setParameter(1,"123");
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user);
            System.out.println(user.getMajor().getMajor());
        }
       /* //模糊查询
        Query query1 = session.createQuery("from User u where u.username like ?");
        query1.setParameter(0,"%卢%");
        List<User> list1 = query1.list();
        for (User user : list1) {
            System.out.println(user.getId()+"::"+user.getUsername());
        }
        //投影查询
        Query query2 = session.createQuery("select username from User where id=?");
        query2.setParameter(0,4);
        List<String> list2 = query2.list();
        for (String s : list2) {
            System.out.println(s);
        }*/
        tx.commit();
    }
    public static void testHqlAll(){
        Session session = HibernateUtils.getSessionobject();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from User");
        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user.getId()+"::"+user.getUsername());
        }
        tx.commit();
    }
    //企图通过查询order来查询相应的user
    public static void testOnetoManyq() {
        Session session = HibernateUtils.getSessionobject();
        Transaction tx = session.beginTransaction();

       Order order = session.get(Order.class,2);
       User user = order.getUser();
       System.out.println(user);

        tx.commit();
    }
    public static void testOnetoManyDe() {
        Session session = HibernateUtils.getSessionobject();
        Transaction tx = session.beginTransaction();

        User user =session.get(User.class,1);
        session.delete(user);

        tx.commit();
    }
    public static void testOnetoMany() {
        Session session = HibernateUtils.getSessionobject();
        Transaction tx = session.beginTransaction();
        //1
        User user = new User();
        user.setPassword("1234");
        user.setUsername("卢奕阳123");
        //多
        Order order = new Order();
       // order.setDate(new Date(2019,3,2));
        order.setPlace("placelyy");
        //配置cascade="save-update"之后可简化写法
        user.getOrderSet().add(order);
        //order.setUser(user);

        session.save(user);
        //session.save(order);
        tx.commit();
    }
    public static void testQuery(){
        Session session = HibernateUtils.getSessionobject();
        Transaction tx = session.beginTransaction();
        //1
        Query query = session.createQuery("from User");
        List<User> list=  query.list();
        for (User user : list) {
            System.out.println(user);
        }
        //2
        Criteria criteria = session.createCriteria(User.class);
        List<User> list2=  query.list();
        for (User user : list2) {
            System.out.println(user);
        }
        //3
        SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
        sqlQuery.addEntity(User.class);
        List<User> list3 = sqlQuery.list();
        for (User user : list3) {
            System.out.println(user);
        }
        tx.commit();
    }
    //与本地线程绑定的session
    public static void testsessionadd(){

            Session session = HibernateUtils.getSessionobject();
            Transaction tx = session.beginTransaction();
            User user = new User();
            user.setUsername("田世先");
            user.setPassword("110");
            session.save(user);
            tx.commit();

    }
    //添加操作
    public static void testAdd(){
        /*1：加载hibernate核心配置文件
          在src下面找到名称是hibernate.cfg.xml
        * 在hibernate里面封装对象
        * */
        Configuration cfg = new Configuration();
        cfg.configure();

        /*2:创建sessionFactory对象
         * 读取hibernate核心配置文件内容，创建SessionFactory
         * 在过程中根据映射关系，在配置数据库里面把表创建*/
        SessionFactory sessionFactory= cfg.buildSessionFactory();

        /*
         * 3：使用sessionFactory创建session对象
         * 类似于连接
         * */
        Session session = sessionFactory.openSession();

        /*4:开启事务*/
        Transaction tx = session.beginTransaction();

        /*5:具体逻辑crud操作*/
        User user = new User();
        user.setUsername("fenghanxu");
        user.setPassword("123");
        //调用session添加
        session.save(user);

        /*6:提交事务*/
        tx.commit();
        /*7:关闭资源*/
        session.close();
        sessionFactory.close();
    }
    //按id查询
    public static void testGet(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //根据id查询
        User user = session.get(User.class,1);
        //Order order = session.get(Order.class,1);
        System.out.println(user);
        //加一个order
        Order order = new Order();
        //order.setDate(new Date(119,5,9));
        order.setPlace("place10");

        user.getOrderSet().add(order);
        session.update(user);
        tx.commit();
        session.close();
        sessionFactory.close();
    }
    //修改
    public static void testUpdate(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //根据id查询
        User user = session.get(User.class,1);
        user.setUsername("卢奕阳");
        session.update(user);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
    //删除
    public static void testDelete(){
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        //删除操作 第一种：
        User user =session.get(User.class,12);
        session.delete(user);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //testAdd();
        //testGet();
        ///testUpdate();
        //testsessionadd();
        //testQuery();
        //testOnetoMany();
        //testOnetoManyDe();
        //testOnetoManyq();
        //testHqlAll();
        //testHql2();
        //testMajor();
        //testDBOadd();
        //testDBOupdate();
        //Guestbook guestbook =(Guestbook) DBO.get(Guestbook.class,1);
        String temp_str="";
        /*Date dt = new Date();*/
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        temp_str=sdf.format(dt);*/
        Guestbook guestbook = new Guestbook();
        guestbook.setNickname("fhx");
        guestbook.setEmail("9@qq.com");
        guestbook.setAdddate(new Date(System.currentTimeMillis()));
        DBO.add(guestbook);
        System.out.println(guestbook);
        /*
        * test query!!!
        *
        * */
       /* String s[] = new String[]{"卢奕阳","123"};
        System.out.println(s.length);
        //List<User> list =DBO.query("from User u where u.username=? and u.password=?",s);
        User user1 =(User) DBO.queryOne("from User u where u.username=? and u.password=?",s);
        System.out.println(user1);*/

      /*  for (User user : list) {
            System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getEmail());
        System.out.println(user.getGender());
            System.out.println(user.getPhone());
            System.out.println(user.getSid());
            System.out.println(user.getRealname());
            System.out.println(user.getMajor().getMajor());
        }*/

       //testDBOqueryone();
        //testUser();
       // String s[] = new String[]{"卢奕阳","123"};
        //int a = DBO.getCount("select count(*) from User");
        //System.out.println(a);
      /*Session session = HibernateUtils.getSessionobject();
        Transaction tran = session.beginTransaction();
        Query q = session.createQuery("select count(*) from User u where u.username=?");
        q.setParameter(0,"哈哈哈");
        Object object  = q.uniqueResult();
        System.out.println(object);
        tran.commit();*/
       /* User user = (User) DBO.get(User.class,1);
        Set<Order> set= user.getOrderSet();
        System.out.println(user.getOrderSet().size());
        for (Order order : set) {
            System.out.println(order);
        }
        Order order = new Order();
        order.setPlace("where");
        order.setUser(user);
        DBO.add(order);*/

        //int s[] = new int[]{1};
       /* List<Order> list = DBO.query("from Order where user.id=?",s);
        for (Order order : list) {
            System.out.println(order);
        }*/
        //List<Order> list=new ArrayList<Order>();
        //System.out.println(DBO.getCount("from Order where user.id=?",s));
        //list= DBO.queryByPage("from Order where user.id=?",s,1,1);
        //for (Order order : list) {
            //System.out.println(order);
        //}

        /*Session session = HibernateUtils.getSessionobject();
        Transaction tran = session.beginTransaction();

        Query q = session.createQuery("from Order where user.id = ?");
        q.setParameter(0,"1");
        List<Order> list = q.list();
        for (Order order : list) {
            System.out.println(or);
        }
        System.out.println(list.size());
        tran.commit();*/


    }

}
