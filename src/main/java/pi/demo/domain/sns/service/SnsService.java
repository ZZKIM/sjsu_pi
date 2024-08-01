package pi.demo.domain.sns.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.demo.domain.pet.dto.response.PetGetResponse;
import pi.demo.domain.pet.entity.Pet;
import pi.demo.domain.sns.dto.request.SnsSaveRequest;
import pi.demo.domain.sns.dto.response.SnsAllReadResponse;
import pi.demo.domain.sns.entity.Sns;
import pi.demo.domain.sns.repository.SnsRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
@Slf4j
@RequiredArgsConstructor
public class SnsService {
    private final SnsRepository snsRepository;
    @Transactional
    public Long registerSns(SnsSaveRequest snsSaveRequest)throws IOException {
      Sns sns = Sns.builder()
              .content(snsSaveRequest.content())
              .imageUrl(snsSaveRequest.imageUrl())
              .build();
        snsRepository.save(sns);

        return sns.getId();
    }

    public List<SnsAllReadResponse> findAllSns(){
        List<Sns> snss= snsRepository.findAll();

        try{
            List<SnsAllReadResponse> responseList =new ArrayList<>();

            for(Sns sns : snss){
                responseList.add(
                        new SnsAllReadResponse(sns.getContent(), sns.getImageUrl())
                );
            }
            return responseList;
        }catch (Exception e){
            log.info("불러오기 실패");
        }
        return null;

    }
}
