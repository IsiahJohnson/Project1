package com.revature.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.*;
import com.revature.services.ReimbursementService;
import io.javalin.http.Handler;

public class ReimbursementController {

    private ReimbursementService rs;
    private ObjectMapper om;

    public ReimbursementController(ReimbursementService rs){
        this.rs = rs;
        this.om = new ObjectMapper();
    }

    public Handler handleCreate = (ctx) -> {
        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must login to create reimbursements");
        } else {
            int reimburserId = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            ReimburseObject ro = om.readValue(ctx.body(), ReimburseObject.class);
            System.out.println(ro);

            rs.createReimbursement(ro.amount, ro.description,reimburserId, ro.status, ro.type);
            ctx.status(202);
            ctx.result("Create reimbursement");
        }
    };


}
