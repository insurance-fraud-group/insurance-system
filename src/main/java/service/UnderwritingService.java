package service;

import domain.AcceptancePolicy;
import domain.Contract;
import domain.Insurance;
import domain.InsuranceCompany;
import domain.Transaction;
import domain.Underwriting;
import domain.User;
import java.util.List;

public interface UnderwritingService {

  List<AcceptancePolicy> searchAcceptancePolicy();

  void createAcceptancePolicy(AcceptancePolicy acceptancePolicy);

  User getUserName(User user);

  List<Underwriting> searchUnderwriting();

  List<Underwriting> searchUnsignedUnderwriting();

  boolean underwrite(Underwriting underwriting);

  List<InsuranceCompany> searchInsuranceCompany();

  void makeUnderwritingSigned(Underwriting underwriting);

  List<Insurance> getInsuranceList();

  float calculateLossRate(Contract contract);
}
