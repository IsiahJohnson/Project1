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

        server.routes(()-> {
            path("users", () -> {
                post("/register", ec.handleRegister);
                post("/login", ec.handleLogin);
                put("/", ec.handleUpdateEmployee);
                delete("/{id}", ec.handleDeleteEmployee);
            });
            path("reimbursement", () -> {
                post("/create", rc.handleCreate);
                get("/", rc.handleGetReimbursement);
                get("/pending", rc.handleGetPendingReimbursement);
                get("/resolved", rc.handleGetResolvedReimbursement);
            });
        });

        server.start(8000);



        /*Employee e = new Employee(2,"username", "password", "firstName", "lastName", "email", 1);
        //ed.createEmployee(e);

        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        Date d1 = new Date(System.currentTimeMillis());
        Reimbursement r = new Reimbursement(500.57,d1, "FOOD", ed.readEmployeeByEmail(e.getEmail()).getEmployeeId(), 3, 3);
        //rd.createReimbursement(r);
        /*System.out.println(r.toString());
        r.setReimbursementStatus(1);
        r.setReimbursementResolver(e.getEmpolyeeId());
        r.setResolvedDate(d1);
        rd.updateReimbursement(r);
        System.out.println(r.toString());

        List<Reimbursement> lr = new ArrayList<>();
        lr = rd.readAllReimbursement();
        System.out.println(lr);
        */


    }
}
