package com.example.demo.Model;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Controller.UserController;
import com.example.demo.DemoApplication;
import com.example.demo.Repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class UserTest {
    private User user1;
    private User user2;
    private User user3;
    @Autowired
    private UserRepository testRepository;
   // private UserController userController;
    //@BeforeClass
    @Transactional
    @Before
    public void User(){
       user1=new User();
       user1.setUsername("name");
       user1.setId(2);
       user1.setEmail("test@qq.com");
       user1.setPassword("123456");
       testRepository=new UserRepository() {
    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<User> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public <S extends User> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends User> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<User> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public User getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends User> S save(S entity) {
        return null;
    }

    @Override
    public Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends User> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends User> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends User> boolean exists(Example<S> example) {
        return false;
    }
};
       testRepository.save(user1);
        Assert.assertNotNull("失败",testRepository);
       Iterable<User> list=testRepository.findAll();
      System.out.println(((List<User>) list).size());
       /* for(int i = 0; i<((List<User>) list).size(); i++)
        {
           System.out.println(((List<User>) list).get(i));
        }
        System.out.println("1111111111111");*/
    }
    @Test
    public void TestFindUser()
    {
        Assert.assertNotNull("失败",testRepository);
       // testRepository.findByEmail("test@qq.com");
      //  Assert.assertNotNull("查询失败",testRepository.findByEmail("test@qq.com"));
    }
   /* @Test
    public void test*/
}