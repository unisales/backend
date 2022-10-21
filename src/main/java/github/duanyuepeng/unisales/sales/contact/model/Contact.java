package github.duanyuepeng.unisales.sales.contact.model;

import github.duanyuepeng.unisales.sales.utils.UniEntity;

import javax.persistence.*;

@Entity
public class Contact extends UniEntity {

  @Column(nullable = false, length = 254)
  public String email;

  @Column(nullable = false, length = 40)
  public String firstName;

  @Column(nullable = false, length = 40)
  public String lastName;

  @OneToOne
  @JoinColumn(name = "owner_id")
  public Contact owner;

  @Column(nullable = false, length = 63)
  public String jobTitle = "";

  @Column(nullable = false, length = 20)
  public String phoneNumber = "";

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum('SUBSCRIBER','LEAD','MARKETING_QUALIFIED_LEAD','SALES_QUALIFIED_LEAD','OPPORTUNITY','CUSTOMER','EVANGELIST','OTHER')")
  public ContactLifeCycleStage lifeCycleStage;
}
