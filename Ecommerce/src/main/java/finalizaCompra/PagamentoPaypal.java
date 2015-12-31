/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalizaCompra;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Frede
 */
@ManagedBean
@SessionScoped
public class PagamentoPaypal {
     public void pagar() {
        Map<String, String> sdkConfig = new HashMap<String, String>();
        sdkConfig.put("mode", "sandbox");
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        String accessToken = "";
        try {
            accessToken = new OAuthTokenCredential("AdLLg-1pTKFjOl-PZoUUoFSyhyVyX9l2y4fM55-9k9lvwH3tFv2usUzm5YyWavGXDL5iYE11M4_Mhbku", "ECCy1PqFARiICFlmxqsMjyyENJKYijXMtQ7gxIsI5OqOV_MmifFYI27DU_JUFqm9uNqfCQBaNmh_ZVWs", sdkConfig).getAccessToken();

            APIContext apiContext = new APIContext(accessToken);
            apiContext.setConfigurationMap(sdkConfig);

            Payer payer = new Payer();
            payer.setPaymentMethod("paypal");

            Amount amount = new Amount();
            amount.setCurrency("USD");
            amount.setTotal("12");

            Transaction transaction = new Transaction();
            transaction.setDescription("creating a payment with saved credit card");
            transaction.setAmount(amount);

            List<Transaction> transactions = new ArrayList<Transaction>();
            transactions.add(transaction);
            
            Payment payment = new Payment();
            payment.setIntent("sale");
            payment.setPayer(payer);
            payment.setTransactions(transactions);
            
            RedirectUrls redirectUrls = new RedirectUrls();
            redirectUrls.setReturnUrl("http://localhost:8084/Ecommerce/HTML/index.html");
            redirectUrls.setCancelUrl("http://localhost:8084/Ecommerce/HTML/checkout-0.xhtml");
            payment.setRedirectUrls(redirectUrls);

            Payment createdPayment = payment.create(apiContext);
            Links links = (Links) createdPayment.getLinks().toArray()[1];
           
            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(links.getHref());
            System.out.println(externalContext.getRequestParameterNames().toString());
        } catch (PayPalRESTException | IOException ex) {
            Logger.getLogger(Estoque.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
