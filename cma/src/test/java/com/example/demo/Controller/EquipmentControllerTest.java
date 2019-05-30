package com.example.demo.Controller;

import com.example.demo.Model.Equipment;
import com.example.demo.Repository.EquipmentRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
public class EquipmentControllerTest {

    private Equipment equipment1;
    private EquipmentRepository equipmentRepository;
    private EquipmentController equipmentController;


    @Before
    public void getOne() {

    }
    @Test
    public void addEquipment() {
       // equipmentController.addEquipment()
    }
    @Test
    public void getAll() {

    }

    @Test
    public void modifyOne() {
    }

    @Test
    public void deleteOne() {
        equipmentController.deleteOne(1);
        equipment1=equipmentRepository.findById(1);
        Assert.assertNull("删除成功",equipment1);
    }
}