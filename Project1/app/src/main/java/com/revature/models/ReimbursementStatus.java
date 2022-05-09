package.com.revature.models;

public class ReimbursementStatus{
        private boolean status;
        private int statusId;

        public ReimbursementStatus(){

        }

        public ReimbursementStatus(boolean status, int statusId) {
                this.status = status;
                this.statusId = statusId;
        }

        public boolean isStatus() {
                return status;
        }

        public void setStatus(boolean status) {
                this.status = status;
        }

        public int getStatusId() {
                return statusId;
        }

        public void setStatusId(int statusId) {
                this.statusId = statusId;
        }

        @java.lang.Override
        public java.lang.String toString() {
                return "ReimbursementStatus{" +
                        "status=" + status +
                        ", statusId=" + statusId +
                        '}';
        }
}