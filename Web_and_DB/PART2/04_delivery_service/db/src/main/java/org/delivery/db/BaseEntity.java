package org.delivery.db;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.experimental.SuperBuilder;

// Entity를 만들다 보면 createdAt, createdBy, updatedAt 그리고 updatedBy 등 반복되는 필드가 존재한다. 앞서 나열한 요소뿐만 아니라 서비스에 따라 Entity마다 공통되는 필드가 생기는 경우가 많다
// 반복되는 작성 과정을 줄이기 위해서 JPA가 제공하는 @MappedSuperClass 어노테이션을 이용하면 공통된 필드를 모아 BaseEntity를 만들 수 있다.
// 하지만 실제 데이터베이스 테이블과 매핑되는 것이 아니기 때문에 @Entity 어노테이션과 함께 사용할 수 없다.
@MappedSuperclass
@Data
@SuperBuilder
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
