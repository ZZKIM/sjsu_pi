package pi.demo.domain.analysis.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pi.demo.domain.analysis.dto.request.AnalysisSaveRequest;
import pi.demo.domain.analysis.dto.response.AnalysisAllReadResponse;
import pi.demo.domain.analysis.entity.Analysis;
import pi.demo.domain.analysis.repository.AnalysisRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class AnalysisService {
    private final AnalysisRepository analysisRepository;
    @Transactional
    public Long registerAnalysis(AnalysisSaveRequest analysisSaveRequest)throws IOException {
      Analysis sns = Analysis.builder()
              .content(analysisSaveRequest.content())
              .imageUrl(analysisSaveRequest.imageUrl())
              .build();
        analysisRepository.save(sns);

        return sns.getId();
    }

    public List<AnalysisAllReadResponse> findAllAnalysis(){
        List<Analysis> analysiss= analysisRepository.findAll();

        try{
            List<AnalysisAllReadResponse> responseList =new ArrayList<>();

            for(Analysis analysis : analysiss){
                responseList.add(
                        new AnalysisAllReadResponse(analysis.getContent(), analysis.getImageUrl())
                );
            }
            return responseList;
        }catch (Exception e){
            log.info("불러오기 실패");
        }
        return null;

    }
}
