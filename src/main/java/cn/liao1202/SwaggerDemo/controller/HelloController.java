package cn.liao1202.SwaggerDemo.controller;

import cn.liao1202.SwaggerDemo.entity.Person;
import cn.liao1202.SwaggerDemo.entity.ResultCode;
import cn.liao1202.SwaggerDemo.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("测试Swagger")
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private PersonService service;

    @GetMapping("/say/{word}")
    @ApiOperation(value = "测试打印String", notes = "仅供测试")
    public String say(@PathVariable("word") String word) {
        return "Hello! " + word;
    }

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "根据ID查询", notes = "请输入1/2/3")
    public Person findById(@PathVariable("id") Integer id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增", notes = "修改完请还原数据")
    public ResultCode add(@RequestBody Person person) {
        return service.add(person);
    }

    @PutMapping("/edit/{id}")
    @ApiOperation(value = "修改", notes = "修改完请还原数据")
    public ResultCode edit(@RequestBody Person person, @PathVariable("id") Integer id) {
        return service.edit(person, id);
    }

    @DeleteMapping("/deleteById/{id}")
    @ApiOperation(value = "根据ID删除", notes = "修改完请还原数据")
    public ResultCode deleteById(@PathVariable("id") Integer id) {
        return service.deleteById(id);
    }
}
