package com.kimyena.basicnoticeboard.crud;

import com.kimyena.basicnoticeboard.common.Api;
import com.kimyena.basicnoticeboard.common.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * dto를 받아서 entity로 바꾼 다음에, 특정한 작업을 한 후 다시 dto로 반환시킬거다(dto -> entity -> dto)
 */
public abstract class CRUDAbstractService<DTO, ENTITY> implements CRUDInterface<DTO>{

    //dto를 entity로 바꿔주고 repository에다가 save를 해주기 위해서 "Converter"가 필요하다
    //Converter를 가져다 써야 하는데, 인터페이스이기 때문에 "Bean"으로 등록되지 않는다. 근데 Bean을 가져다가 사용할 수 있는 방법이 있다.
    @Autowired(required = false)
    private Converter<DTO, ENTITY> converter; //해당 converter를 상속받은 Bean이 있다면 해당 코드가 채워지고, 없다면 null이 될 거다.

    @Autowired(required = false)
    private JpaRepository<ENTITY, Long> jpaRepository;

    @Override
    public DTO create(DTO dto) {

        //dto -> entity
        var entity = converter.toEntity(dto);

        //entity -> save
        jpaRepository.save(entity);

        //save -> dto
        var returnDto = converter.toDTO(entity);

        return returnDto;
    }

    @Override
    public Optional<DTO> read(Long id) {

        var optionalEntity = jpaRepository.findById(id);

        var dto = optionalEntity.map(
                it ->{
                    return converter.toDTO(it);
                }
        ).orElseGet(() -> null); // 없을 땐 Null 반환

        return Optional.ofNullable(dto);
    }

    @Override
    public DTO update(DTO dto) {

        var entity = converter.toEntity(dto);
        jpaRepository.save(entity);
        var returnDto = converter.toDTO(entity);

        return returnDto;
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);

    }

    @Override
    public Api<List<DTO>> list(Pageable pageable) {

        var list = jpaRepository.findAll(pageable);
        var pagination = Pagination.builder()
                .page(list.getNumber())
                .size(list.getSize())
                .currentElements(list.getNumberOfElements())
                .totalElements(list.getTotalElements())
                .totalPage(list.getTotalPages())
                .build();

        var dtoList = list.stream()
                .map(it -> {
                    return converter.toDTO(it);
                }).toList();

        var response = Api.<List<DTO>>builder()
                .body(dtoList)
                .pagination(pagination)
                .build();

        return response;
    }
}
