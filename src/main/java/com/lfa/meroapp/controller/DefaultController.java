/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lfa.meroapp.controller;

import com.lfa.meroapp.entity.Departments;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/home")
public class DefaultController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
        String sql = "Select * from departments";
        List<Departments> all = jdbcTemplate.query(sql, new RowMapper<Departments>() {
            public Departments mapRow(ResultSet rs, int i) throws SQLException {
                Departments department = new Departments();
                department.setName(rs.getString("name"));
                return department;
            }
        });
        model.addAttribute("user", "Niranjan");
        model.addAttribute("department", all);
        return "index";
    }
    
}
