package com.revature;
import com.revature.dao.EmployeeDao;
import com.revature.dao.IEmployeeDao;
import com.revature.dao.IReimbursemnetDao;
import com.revature.dao.ReimbursementDao;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.models.*;
import com.revature.utils.*;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class ReimbursementDriver {
    public static void main(String[] args) throws ParseException {
        IEmployeeDao ed = new EmployeeDao();
        IReimbursemnetDao rd = new ReimbursementDao();

        Employee e = new Employee(2,"username", "password", "firstName", "lastName", "email", 1);
        //ed.createEmployee(e);

        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
        Date d1 = new Date(System.currentTimeMillis());
        Reimbursement r = new Reimbursement(500.57,d1, "FOOD", e, 3, 3);
        rd.createReimbursement(r);
        System.out.print(r.toString());
        r.setReimbursementStatus(1);
        r.setReimbursementResolver(e);
        r.setResolvedDate(d1);
        System.out.print(r.toString());
        rd.updateReimbursement(r);
    }
}
