package com.revature;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.ReimbursementController;
import com.revature.dao.EmployeeDao;
import com.revature.dao.IEmployeeDao;
import com.revature.dao.IReimbursemnetDao;
import com.revature.dao.ReimbursementDao;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;
import com.revature.services.ReimbursementService;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static io.javalin.apibuilder.ApiBuilder.*;

public class ReimbursementDriver {
    public static void main(String[] args) throws ParseException {
        IEmployeeDao ed = new EmployeeDao();
        IReimbursemnetDao rd = new ReimbursementDao();

        Employee e = new Employee(2,"username", "password", "firstName", "lastName", "email", 1);
        ed.createEmployee(e);

        EmployeeService es = new EmployeeService(ed);
        ReimbursementService rs = new ReimbursementService(rd);

        EmployeeController ec = new EmployeeController(es);
        ReimbursementController rc = new ReimbursementController(rs);

        Javalin server = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
        });

        server.before(ctx -> ctx.header("Access-Control-Allow-Credentials", "true"));
        server.before(ctx -> ctx.header("Access-Control-Expose-Headers", "*"));
        server.routes(()-> {
            path("users", () -> {
                post("/register", ec.handleRegister);
                post("/login", ec.handleLogin);
                put("/", ec.handleUpdateEmployee);
                delete("/{id}", ec.handleDeleteEmployee);
                get("/logout", ec.handleLogout);
                get("/get/{id}", ec.handleGetEmployee);
            });
            path("reimbursement", () -> {
                post("/", rc.handleCreate);
                get("/", rc.handleGetReimbursement);
                get("/pending", rc.handleGetPendingReimbursement);
                get("/resolved", rc.handleGetResolvedReimbursement);
                put("/update/{id}", rc.handleUpdateReimbursement);
            });
        });

        server.start(8000);


    }
}
