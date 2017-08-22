package pl.sda.javawwa.Model;

import pl.sda.javawwa.Model.Older.Parent;
import pl.sda.javawwa.Model.Younger.Sibling;

import java.util.HashSet;
import java.util.Set;

public class Family {

    private Set<Parent> parents;
    private Set<Sibling> siblings;

    public Family() {
        this.parents = new HashSet<>();
        this.siblings = new HashSet<>();

    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addSibling(Sibling sibling) {
        this.siblings.add(sibling);
    }

    public Set<Parent> getParents() {
        return parents;
    }

    public Set<Sibling> getSiblings() {
        return siblings;
    }

}
