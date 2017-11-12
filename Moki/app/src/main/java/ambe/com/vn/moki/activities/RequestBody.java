package ambe.com.vn.moki.activities;

/**
 * Created by Truong on 11/11/2017.
 */

public class RequestBody {

    private String deviceName;
    private String deviceId;
    private String registrationId;
    private String id_user;

    public RequestBody(String deviceName, String deviceId, String registrationId, String id_user) {
        this.deviceName = deviceName;
        this.deviceId = deviceId;
        this.registrationId = registrationId;
        this.id_user = id_user;
    }

    public RequestBody() {
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }
}