package org.example.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int id;
    private String name;
    private String email;
    private int age;
    private boolean active;
    private double score;
    private String phone;
    private Address address;
    private List<String> tags;
    private List<Double> ratings;
    private Preferences preferences;
    private List<Role> roles;

    @JsonProperty("lucky_numbers")
    private List<Integer> luckyNumbers;

    @JsonProperty("login_history")
    private List<LoginHistory> loginHistory;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public List<Double> getRatings() { return ratings; }
    public void setRatings(List<Double> ratings) { this.ratings = ratings; }

    public Preferences getPreferences() { return preferences; }
    public void setPreferences(Preferences preferences) { this.preferences = preferences; }

    public List<Role> getRoles() { return roles; }
    public void setRoles(List<Role> roles) { this.roles = roles; }

    public List<Integer> getLuckyNumbers() { return luckyNumbers; }
    public void setLuckyNumbers(List<Integer> luckyNumbers) { this.luckyNumbers = luckyNumbers; }

    public List<LoginHistory> getLoginHistory() { return loginHistory; }
    public void setLoginHistory(List<LoginHistory> loginHistory) { this.loginHistory = loginHistory; }

}
