package org.example.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenResponse {
    private String token;

    @JsonProperty("expires_at")
    private String expiresAt;

    @JsonProperty("expires_in")
    private int expiresIn;

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getExpiresAt() { return expiresAt; }
    public void setExpiresAt(String expiresAt) { this.expiresAt = expiresAt; }

    public int getExpiresIn() { return expiresIn; }
    public void setExpiresIn(int expiresIn) { this.expiresIn = expiresIn; }

}
