package com.example.demo.Controller;

import Repository.EquipmentRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yxp
 */
@Controller
@RequestMapping(path="/Equipment")
public class EquipmentController {
    @Autowired
    private EquipmentRepository ERepository;

    @RequestMapping(path="add",method=RequestMethod.POST)
    public Response addEquipment(
            @RequestParam (value="id",required=false)Long id,
            @RequestParam (value="name",required=false)String name,
            @RequestParam (value="model",required=false)String model,
            @RequestParam (value="cpu",required=false)String cpu,
            @RequestParam (value="memory",required=false)String memory,
            @RequestParam (value="hardDisk",required=false)String hardDisk,
            @RequestParam (value="equipmentNumber",required=false)String equipmentNumber,
            @RequestParam (value="application",required=false)String application,
            @RequestParam (value="state",required=false)Byte state){
        Response response=new Response();
        if(ERepository.findById(id)!=null)
          //  response.message=

    }

}
