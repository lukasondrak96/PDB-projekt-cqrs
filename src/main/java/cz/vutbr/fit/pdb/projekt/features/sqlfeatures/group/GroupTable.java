package cz.vutbr.fit.pdb.projekt.features.sqlfeatures.group;

import cz.vutbr.fit.pdb.projekt.features.helperInterfaces.object.GroupInterface;
import cz.vutbr.fit.pdb.projekt.features.helperInterfaces.persistent.PersistentGroup;
import cz.vutbr.fit.pdb.projekt.features.helperInterfaces.reference.UserReference;
import cz.vutbr.fit.pdb.projekt.features.sqlfeatures.user.UserTable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class GroupTable implements GroupInterface, PersistentGroup {
    public GroupTable(String name, String description, GroupState state, UserTable userTableReference) {
        this.name = name;
        this.description = description;
        this.state = state;
        this.userTableReference = userTableReference;
    }

    @Id
    @SequenceGenerator(name = "GroupIdGenerator", sequenceName = "GROUP_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GroupIdGenerator")
    private int id;

    private String name;

    private String description;

    private GroupState state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private UserTable userTableReference;

    @ManyToMany(mappedBy = "groups", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserTable> users = new ArrayList<>();

    public void addUser(UserTable user) {
        this.users.add(user);
        user.getGroups().add(this);
    }

    public void removeUser(UserTable user) {
        this.users.remove(user);
        user.getGroups().remove(this);
    }

    @Override
    public UserReference getUserReference() {
        return userTableReference;
    }

    @Override
    public void setUserReference(UserReference userReference) {
        userTableReference = (UserTable) userReference;
    }
}
