package org.example.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Preferences {
    private String theme;
    private String language;
    private boolean notifications;
    private String timezone;

    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public boolean isNotifications() { return notifications; }
    public void setNotifications(boolean notifications) { this.notifications = notifications; }

    public String getTimezone() { return timezone; }
    public void setTimezone(String timezone) { this.timezone = timezone; }
}
