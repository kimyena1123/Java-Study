package org.delivery.db.account;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
import org.delivery.db.BaseEntity;

@SuperBuilder //부모로부터 상속받은 변수도 포함시키겠다
@Data
@EqualsAndHashCode(callSuper = true) //객체비교할 때 사용함. callSuper = true란 부모에 있는 것까지 포함해서 비교함. false를 하면 현재 entity안에 있는 값만 비교
@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {
}
