package org.example.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginHistory {
    private String timestamp;
    private String ip;
    private boolean success;

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }

}
