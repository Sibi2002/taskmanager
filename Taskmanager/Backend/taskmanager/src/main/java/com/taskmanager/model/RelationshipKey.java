package com.taskmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RelationshipKey implements Serializable {
    int user_id;
    int task_id;
    int assigned_by;
    int status_id;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelationshipKey that = (RelationshipKey) o;
        return user_id == that.user_id && task_id == that.task_id && assigned_by == that.assigned_by && status_id == that.status_id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(user_id, task_id, assigned_by, status_id);
    }
}
