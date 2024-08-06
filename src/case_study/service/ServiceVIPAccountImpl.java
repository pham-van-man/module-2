package case_study.service;

import case_study.repository.RepositoryVIPAccountImpl;

public class ServiceVIPAccountImpl extends ServiceAccountImpl {
    public ServiceVIPAccountImpl() {
        super.repositoryAccount = new RepositoryVIPAccountImpl();
    }
}
