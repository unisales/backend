package github.duanyuepeng.unisales.sales.lead.model;

import github.duanyuepeng.unisales.sales.contact.model.Contact;
import github.duanyuepeng.unisales.sales.utils.UniEntity;

import javax.persistence.*;

@Entity
public class Lead extends UniEntity {

  @OneToOne
  @JoinColumn(name = "contact_id")
  public Contact contact;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = "enum('NEW','OPEN','IN_PROGRESS','OPEN_DEAL','UNQUALIFIED','ATTEMPTED_TO_CONTACT','CONNECTED','BAD_TIMING')")
  public LeadStatus status = LeadStatus.NEW;
}
