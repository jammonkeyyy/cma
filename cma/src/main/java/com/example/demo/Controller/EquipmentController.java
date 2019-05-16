package com.example.demo.Controller;

import com.example.demo.Repository.EquipmentRepository;
import com.example.demo.Model.Equipment;
import com.example.demo.Exceptions.MyException;
import com.example.demo.framework.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.GeneratedValue;

/**
 * @author yxp
 */
@Service
@Transactional
@Controller
@RequestMapping(path="/Equipment")
public class EquipmentController {
    @Autowired
    private EquipmentRepository ERepository;
    @RequestMapping(path="add",method=RequestMethod.POST)
    @ResponseBody
    public Response addEquipment(
            @RequestParam (value="name",required=false)String name,
            @RequestParam (value="model",required=false)String model,
            @RequestParam (value="cpu",required=false)String cpu,
            @RequestParam (value="memory",required=false)String memory,
            @RequestParam (value="hardDisk",required=false)String hardDisk,
            @RequestParam (value="equipmentNumber",required=false)String equipmentNumber,
            @RequestParam (value="application",required=false)String application,
            @RequestParam (value="state",required=false)Byte state){
        Response response=new Response();
        try {
             if (ERepository.findByEquipmentNumber(equipmentNumber) != null) {
                throw new Exception("the equipment:"+equipmentNumber+" exists!");
            }
            Equipment equipment = new Equipment();
            equipment.setName(name);
            equipment.setModel(model);
            equipment.setCpu(cpu);
            equipment.setMemory(memory);
            equipment.setHardDisk(hardDisk);
            equipment.setEquipmentNumber(equipmentNumber);
            equipment.setApplication(application);
            equipment.setState(state);
            System.out.println(equipment);
           // JSONObject ejson = JSONObject.parseObject(JSONObject.toJSONString(equipment));
            response.code=200;
            response.data=null;
            response.setMessage("成功");
        }catch(Exception e){
            e.printStackTrace();
            response.code=500;
            response.msg=e.getMessage();
        }
        return response;
    }

   /* @RequestMapping(value="/getOne/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Response getOne( @RequestParam (value="id",required=false)Integer id){
        Response response=new Response();
        try {
            if (ERepository.findById(id) == null) {
                throw new Exception("the equipment:"+id+"in not exist");
            }
            Equipment equipment = ERepository.findOne(id);
            JSONObject ejson = JSONObject.parseObject(JSONObject.toJSONString(equipment));
            response.code=200;
            response.data=ejson;
            response.msg="成功";
            }catch(Exception e){
                e.printStackTrace();
                response.code=500;
                response.msg=e.getMessage();
            }
        return response;
        }*/
}
