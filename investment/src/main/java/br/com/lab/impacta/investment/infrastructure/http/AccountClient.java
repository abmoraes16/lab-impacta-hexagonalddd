package br.com.lab.impacta.investment.infrastructure.http;

import br.com.lab.impacta.investment.application.dto.request.DebitAccountRequest;
import br.com.lab.impacta.investment.service.facade.valueObject.AccountBalanceVO;
import br.com.lab.impacta.investment.service.facade.valueObject.DebitAccountVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${lab.investment.paths.client-account-name}",
            url = "${lab.investment.paths.client-account-base-url}")
public interface AccountClient {

    @GetMapping("${lab.investment.paths.client-account-balance-path-url}")
    AccountBalanceVO getAccountBalance(@PathVariable("accountId") Long accountId);
    @PostMapping("${lab.investment.paths.client-account-debit-path-url}")
    DebitAccountVO debit(@PathVariable("accountId") Long accountId,
                         DebitAccountRequest debitAccountRequest);
}