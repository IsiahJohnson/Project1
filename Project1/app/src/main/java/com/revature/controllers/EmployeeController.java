package com.revature.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.LoginObject;
import com.revature.models.RegisterObject;
import com.revature.services.EmployeeService;
import io.javalin.http.Handler;

public class EmployeeController {
    private EmployeeService es;
    private ObjectMapper om;

    public EmployeeController(EmployeeService es){
        this.es = es;
        this.om = new ObjectMapper();
    }

    public Handler handleRegister = (ctx) -> {
        RegisterObject ro = om.readValue(ctx.body(), RegisterObject.class);

        System.out.println(ro);

        es.registerEmployee(ro.username, ro.password,ro.first, ro.last, ro.email);
        ctx.status(201);
        ctx.result("Create employee");
    };

    public Handler handleLogin = (ctx) -> {
        LoginObject lo = om.readValue(ctx.body(), LoginObject.class);

        Employee e = es.loginEmployee(lo.email, lo.password);

        if(e == null){
            ctx.status(403);
            ctx.result("Email or password was incorrect");
        } else {
            //We could also, if the Employee is logged in successfully, setup a session for them
            ctx.req.getSession().setAttribute("loggedIn", e.getEmail());
            ctx.req.getSession().setAttribute("id", ""+es.readEmployeeByEmail(lo.email).getEmployeeId());
            ctx.result(om.writeValueAsString(e));
        }
    };

    public Handler handleLogout = (ctx) -> {
        ctx.req.getSession().invalidate();
        ctx.result("Employee logged out");
    };

    public Handler handleUpdateEmployee = (ctx) -> {
        Employee e = om.readValue(ctx.body(), Employee.class);

        System.out.println(e);

        ctx.result(om.writeValueAsString(es.updateEmployeeInfo(e)));
    };

    public Handler handleDeleteEmployee = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Employee e = new Employee();
        e.setEmployeeId(id);
        es.deleteEmployee(e);
        ctx.result("Employee deleted");
    };





}
