package mw.gov.health.lmis.reports.service.referencedata;

import mw.gov.health.lmis.reports.dto.external.StockAdjustmentReasonDto;
import mw.gov.health.lmis.utils.RequestParameters;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
public class StockAdjustmentReasonReferenceDataService
    extends BaseReferenceDataService<StockAdjustmentReasonDto> {

  @Override
  protected String getUrl() {
    return "/api/stockAdjustmentReasons/";
  }

  @Override
  protected Class<StockAdjustmentReasonDto> getResultClass() {
    return StockAdjustmentReasonDto.class;
  }

  @Override
  protected Class<StockAdjustmentReasonDto[]> getArrayResultClass() {
    return StockAdjustmentReasonDto[].class;
  }

  /**
   * Retrieves StockAdjustmentReasons for a specified program
   *
   * @param programId the program id.
   * @return a list of StockAdjustmentReasons.
   */
  public Collection<StockAdjustmentReasonDto> search(UUID programId) {
    RequestParameters parameters = RequestParameters
        .init()
        .set("program", programId);

    return findAll("search", parameters);
  }
}
