import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "log_info")
public class LogInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private int logId;
    @Column(name = "name", length = 50, nullable = false)
    private String name;
    @Column(name = "login", length = 50, nullable = false)
    private String login;
    @Column(name = "password", length = 50, nullable = false)
    private String password;
    @Column(name = "create_date")
    @CreationTimestamp
    private Instant createDate;
    @Column(name = "update_date")
    @UpdateTimestamp
    private Instant updateDate;
    @JoinTable(
            name = "Loginfo_Role",
            joinColumns = { @JoinColumn(name = "log_id") },
            inverseJoinColumns = { @JoinColumn(name = "action_id") }
    )
    private Set<Role> action = new HashSet<>();

    public LogInfo() {
    }

    @Override
    public String toString() {
        return "LogInfo{" +
                "logId=" + logId +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", action=" + action +
                '}';
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }

    public Set<Role> getAction() {
        return action;
    }

    public void setAction(Set<Role> action) {
        this.action = action;
    }
}
