package Pojos;

public class EmployeePojos {

    private String status;
    private Data data;
    private String message;

    /**
     * No args constructor for use in serialization
     *
     */
    public EmployeePojos() {
    }

    /**
     *
     * @param data
     * @param message
     * @param status
     */
    public EmployeePojos(String status, Data data, String message) {
        super();
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmployeePojos{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
