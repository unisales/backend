package github.duanyuepeng.unisales.sales.utils;

import github.duanyuepeng.unisales.sales.contact.model.ContactLifeCycleStage;
import org.junit.jupiter.api.Test;

class UniEnumTest {

  @Test
  void getEnumColumnDefinition() {
    System.out.println(UniEnum.getEnumDefinition(ContactLifeCycleStage.class));
  }
}
