import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_id")
    private int actionId;
    @Column(name = "action_role", length = 50, nullable = false)
    private String actionRole;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Loginfo_Role",
            joinColumns = { @JoinColumn(name = "action_id") },
            inverseJoinColumns = { @JoinColumn(name = "log_id") }
    )
    private Set<LogInfo> loginfo = new HashSet<>();

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "actionId=" + actionId +
                ", actionRole='" + actionRole + '\'' +
                '}';
    }

    public int getActionId() {
        return actionId;
    }

    public void setActionId(int actionId) {
        this.actionId = actionId;
    }

    public String getActionRole() {
        return actionRole;
    }

    public void setActionRole(String actionRole) {
        this.actionRole = actionRole;
    }

    public Set<LogInfo> getLoginfo() {
        return loginfo;
    }

    public void setLoginfo(Set<LogInfo> loginfo) {
        this.loginfo = loginfo;
    }
}
