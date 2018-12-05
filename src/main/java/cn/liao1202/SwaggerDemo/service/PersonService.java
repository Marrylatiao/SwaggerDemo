package cn.liao1202.SwaggerDemo.service;

import cn.liao1202.SwaggerDemo.dao.PersonRepository;
import cn.liao1202.SwaggerDemo.entity.Person;
import cn.liao1202.SwaggerDemo.entity.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person findById(Integer id) {
        Optional<Person> optional = repository.findById(id);
        if (optional.isPresent()) return optional.get();
        return null;
    }

    public ResultCode add(Person person) {
        ResultCode code = new ResultCode();
        try {
            repository.save(person);
            code.setCode(0);
            code.setMessage("成功");
        } catch (Exception e) {
            code.setCode(1);
            code.setMessage("失败");
        }
        return code;
    }

    public ResultCode edit(Person person, Integer id) {
        ResultCode code = new ResultCode();
        if (this.findById(id) != null) {
            try {
                repository.save(person);
                code.setCode(0);
                code.setMessage("成功");
            } catch (Exception e) {
                code.setCode(1);
                code.setMessage("失败");
            }
        }
        code.setCode(1);
        code.setMessage("失败");
        return code;
    }

    public ResultCode deleteById(Integer id) {
        ResultCode code = new ResultCode();
        try {
            repository.deleteById(id);
            code.setCode(0);
            code.setMessage("成功");
        } catch (Exception e) {
            code.setCode(1);
            code.setMessage("失败");
        }
        return code;
    }
}
