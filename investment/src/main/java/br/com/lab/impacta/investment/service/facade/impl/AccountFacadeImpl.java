package br.com.lab.impacta.investment.service.facade.impl;

import br.com.lab.impacta.investment.application.dto.request.DebitAccountRequest;
import br.com.lab.impacta.investment.infrastructure.http.AccountClient;
import br.com.lab.impacta.investment.service.facade.AccountFacade;
import br.com.lab.impacta.investment.service.facade.valueObject.AccountBalanceVO;
import br.com.lab.impacta.investment.service.facade.valueObject.DebitAccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountFacadeImpl implements AccountFacade {

    @Autowired
    private AccountClient accountClient;

    @Override
    public AccountBalanceVO getAccountBalanceById(Long accountId) {
        AccountBalanceVO accountBalanceVO = accountClient.getAccountBalance(accountId);

        return accountBalanceVO;
    }

    @Override
    public boolean debitAccount(Long accountId, Double valueOfInvestiment) {
        DebitAccountVO debitAccountVO = accountClient.debit(accountId, new DebitAccountRequest(valueOfInvestiment));

        return debitAccountVO.isDebited();
    }
}
