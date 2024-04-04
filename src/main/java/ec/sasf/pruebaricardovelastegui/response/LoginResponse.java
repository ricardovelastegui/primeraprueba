package ec.sasf.pruebaricardovelastegui.response;


public class LoginResponse {

    String mesage;
    Boolean status;

    public LoginResponse(String mesage, Boolean status) {
        this.mesage = mesage;
        this.status = status;
    }

    public String getMesage() {
        return mesage;
    }
    public void setMesage(String mesage) {
        this.mesage = mesage;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LoginResponse(){}

    @Override
    public String toString() {
        return "LoginResponse{" +  "mesaje='" + mesage + '\'' +", status'" + status + '\'' + '}';
    }
    
}
