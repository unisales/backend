package github.duanyuepeng.unisales.sales.utils;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class UniEntity extends PanacheEntityBase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "<" + id + ">";
  }
}
