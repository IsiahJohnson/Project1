export interface IReimbursement {
    reimbursementId?: number,
    amount: number,
    submittedDate: Date,
    resolvedDate: Date,
    description: string,
    reimbursementAuthor: number,
    reimbursementResolver: number,
    reimbursementStatus: number,
    reimbursementType: number
}