package twophasecommit;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 如果存在事务ID，则将事务ID传播到请求中去
 */
@Component
public class FeignInterceptor implements RequestInterceptor {

	@Autowired
	private TransactionContext transactionContext;

	@Override
	public void apply(feign.RequestTemplate requestTemplate) {
		Long tid = transactionContext.getTransactionId();
		if (tid != null) {
			//int timeout = (int) ((transactionContext.getExpired() - System.currentTimeMillis()) / 1000) + 1;
			requestTemplate.header("TransactionId", tid + "");
		}
	}
}