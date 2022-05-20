import { format } from 'date-fns';
import React from 'react';

import { IReimbursement } from '../../Interfaces/IReimbursement';

//import './Reimbursement.css';

export const Reimbursement:React.FC<IReimbursement> = (reimbursement:IReimbursement) => {

    return(
        <div className="reimbursements">
            <div className="reimbursement-profile">
                <h3 className="reimbursement-user">{reimbursement.reimbursementId}</h3>
            </div>

            <div className="amount">
                <h4 className="reimbursement-amount">{reimbursement.amount}</h4>
            </div>

            <div className="reimbursement-date-submitted">
                <p>{format(reimbursement.submittedDate, "DD-MM-YYYY")}</p>
            </div>

            <div className="reimbursement-description">
                <p>{reimbursement.description}</p>
            </div>
        </div>
    )

}