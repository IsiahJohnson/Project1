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

public class ReimbursementDriver {
    public static void main(String[] args) {
        IEmployeeDao ed = new EmployeeDao();
        IReimbursemnetDao rd = new ReimbursementDao();

        Employee e = new Employee(0,"pass", "Ethan", "McGill", "eMcGill@mail.com", 1);
        ed.createEmployee(e);

        Reimbursement r = new Reimbursement(500.57,"5/10/2022", "FOOD");
    }
}
