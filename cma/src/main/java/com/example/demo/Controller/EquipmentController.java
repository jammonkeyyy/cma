package com.example.demo.Controller;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.Repository.EquipmentRepository;
import com.example.demo.Model.Equipment;
import com.example.demo.Exceptions.MyException;
import com.example.demo.framework.Response;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

import javax.persistence.GeneratedValue;

/**
 * @author yxp
 */

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
            Equipment equipment = new Equipment();
            equipment.setName(name);
            equipment.setModel(model);
            equipment.setCpu(cpu);
            equipment.setMemory(memory);
            equipment.setHardDisk(hardDisk);
            equipment.setEquipmentNumber(equipmentNumber);
            equipment.setApplication(application);
            equipment.setState(state);
            ERepository.save(equipment);
            System.out.println(equipment.getId());
            JSONObject ejson = JSONObject.parseObject(JSONObject.toJSONString(equipment));
            response.code=200;
            response.data=null;
            response.setMessage("成功");
            return response;
    }

    @RequestMapping(value="/getOne/{id}",method=RequestMethod.GET)
    @ResponseBody
    public Response getOne(@PathVariable("id") Integer id){
        Response response=new Response();
        System.out.println("finfbyid:"+id);
        try {
            if (ERepository.findById(id) == null) {
                throw new Exception("ID:"+id+" does not exist");
            }
            Equipment equipment = ERepository.findById(id);
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
        }

    @RequestMapping(value="/getAll",method=RequestMethod.GET)
    @ResponseBody
    public Response getAll(){
        Response response=new Response();
        JSONObject alljson=new JSONObject();
        Iterable<Equipment> list=ERepository.findAll();
      /*  List<Equipment> list1=new ArrayList<>();
        list.forEach(i->{list1.add(i);});*/
        JSONArray jsons=new JSONArray();
        for(int i = 0; i<((List<Equipment>) list).size(); i++)
        {
            JSONObject ejson = JSONObject.parseObject(JSONObject.toJSONString(((List<Equipment>) list).get(i)));
            jsons.add(ejson);
        }
        alljson.put("Equipments",jsons);
        response.code=200;
        response.data=alljson;
        response.msg="成功";
        return response;
    }

}
