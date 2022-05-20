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
            int reimburserId = Integer.parseInt((ctx.pathParam("id")));

            ReimburseObject ro = om.readValue(ctx.body(), ReimburseObject.class);
            System.out.println(ro);

            rs.createReimbursement(ro.amount, ro.description,reimburserId,3, ro.type);
            ctx.status(202);
            ctx.result("Create reimbursement");
        }
    };

    public Handler handleGetReimbursement = (ctx) -> {
        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must login to view requests");
    } else {
        int reimburserId = Integer.parseInt((ctx.pathParam("id")));

        ctx.result(om.writeValueAsString(rs.getReimbursementByUser(reimburserId)));
    }

    };

    public Handler handleUpdateReimbursement = (ctx) -> {
        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must login to update requests");
        } else {
            Reimbursement r = om.readValue(ctx.body(), Reimbursement.class);
            int id = Integer.parseInt(ctx.pathParam("id"));
            r.setReimbursementId(id);
            ctx.result(om.writeValueAsString(rs.updateReimbursementInfo(r)));
        }


    };


    public Handler handleGetPendingReimbursement = (ctx) -> {
        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must login to view pending requests");
        } else {
            int reimburserId = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            ctx.result(om.writeValueAsString(rs.getPendingReimbursement(reimburserId)));
        }
    };

    public Handler handleGetResolvedReimbursement = (ctx) -> {
        if(ctx.req.getSession().getAttribute("id") == null){
            ctx.status(401);
            ctx.result("You must login to view resolved requests");
        } else {
            int reimburserId = Integer.parseInt((String) ctx.req.getSession().getAttribute("id"));

            ctx.result(om.writeValueAsString(rs.getResolvedReimbursement(reimburserId)));
        }
    };

}
