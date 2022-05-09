package.com.revature.models;

public class ReimbursementType(){
    private String type;
    private int typeId;

    public ReimbursementType(String type, int typeId) {
        this.type = type;
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "ReimbursementType{" +
                "type='" + type + '\'' +
                ", typeId=" + typeId +
                '}';
    }
}