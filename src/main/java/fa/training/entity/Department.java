package fa.training.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Cacheable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "departments")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Department {

  @Id
  @GeneratedValue
  @Column(name = "dept_id")
  private Integer id;

  @Column(name = "dept_name")
  private String deptName;

  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
  @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
  private List<Employee> employeeList = new ArrayList<>();

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public List<Employee> getEmployeeList() {
    return employeeList;
  }

  public void setEmployeeList(List<Employee> employeeList) {
    this.employeeList = employeeList;
  }

  @Override
  public String toString() {
    if (employeeList.isEmpty()) {
      return "Department{" +
              "id=" + id +
              ", deptName='" + deptName + '\'' +
              '}';
    }

    return "Department{" +
            "id=" + id +
            ", deptName='" + deptName + '\'' +
            ", employees='" + Arrays.toString(employeeList.toArray()) + "'" +
            '}';
  }
}
