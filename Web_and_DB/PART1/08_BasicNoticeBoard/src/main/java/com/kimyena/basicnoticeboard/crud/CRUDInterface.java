package com.kimyena.basicnoticeboard.crud;

import com.kimyena.basicnoticeboard.common.Api;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

//CRUD를 인터페이스화 시킬 거다
public interface CRUDInterface<DTO> {

    DTO create(DTO dto);

    Optional<DTO> read(Long id);

    DTO update(DTO dto);

    void delete(Long id);

    Api<List<DTO>> list(Pageable pageable);
}
