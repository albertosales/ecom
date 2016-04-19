/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.pagamento;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import br.com.sales.compra.DAO.EstoqueDAO;
import br.com.sales.compra.model.Carrinho;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import br.com.sales.dao.vo.Cliente;
import br.com.sales.dao.vo.ItemProduto;
import br.com.sales.dao.vo.EstoqueVO;

/**
 *
 * @author Frede
 */
@ManagedBean
@SessionScoped
public class PagamentoPaypal {

    private String paymentId = "";
    private String payerId = "";
    private String token = "";
    private String resultado = "";
    private List<EstoqueVO> listaEstoque;

    public void pagar(Cliente cliente, Carrinho carrinho) {
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
            List<Item> items = new ArrayList<Item>();
            listaEstoque = new ArrayList<>();

            Date data = new Date();
            for (ItemProduto produto : carrinho.getListaDeProdutos()) {
                items.add(new Item(produto.getProduto().getNome(), String.valueOf(produto.getQuantidade()), String.valueOf(produto.getProduto().getPreco()).concat("0"), "BRL"));
                EstoqueVO estoque = new EstoqueVO();
                estoque.setProduto(produto.getProduto());
                estoque.setVenda(produto.getQuantidade());
                estoque.setData(data);
                listaEstoque.add(estoque);
            }

            ItemList list = new ItemList();
            list.setItems(items);

            Amount amount = new Amount();
            amount.setCurrency("BRL");
            amount.setTotal(String.valueOf(carrinho.getPrecoTotal()).concat("0"));

            Transaction transaction = new Transaction();
            transaction.setItemList(list);
            transaction.setAmount(amount);

            List<Transaction> transactions = new ArrayList<Transaction>();
            transactions.add(transaction);

            Payment payment = new Payment();
            payment.setIntent("sale");
            payment.setPayer(payer);
            payment.setTransactions(transactions);

            RedirectUrls redirectUrls = new RedirectUrls();
            redirectUrls.setReturnUrl("http://localhost:8084/Ecommerce/HTML/checkout-4.xhtml");
            redirectUrls.setCancelUrl("http://localhost:8084/Ecommerce/HTML/checkout-4.xhtml");
            payment.setRedirectUrls(redirectUrls);

            Payment createdPayment = payment.create(apiContext);
            Links links = (Links) createdPayment.getLinks().toArray()[1];

            ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
            externalContext.redirect(links.getHref());

        } catch (PayPalRESTException | IOException ex) {
            Logger.getLogger(EstoqueVO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void confirmarPagamento() {
        try {
            Map<String, String> sdkConfig = new HashMap<String, String>();
            sdkConfig.put("mode", "sandbox");
            HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            String accessToken = new OAuthTokenCredential("AdLLg-1pTKFjOl-PZoUUoFSyhyVyX9l2y4fM55-9k9lvwH3tFv2usUzm5YyWavGXDL5iYE11M4_Mhbku", "ECCy1PqFARiICFlmxqsMjyyENJKYijXMtQ7gxIsI5OqOV_MmifFYI27DU_JUFqm9uNqfCQBaNmh_ZVWs", sdkConfig).getAccessToken();
            APIContext apiContext = new APIContext(accessToken);
            apiContext.setConfigurationMap(sdkConfig);

            Payment payment = new Payment();
            payment.setId(getPaymentId());
            PaymentExecution paymentExecute = new PaymentExecution();
            paymentExecute.setPayerId(getPayerId());
            Payment result = payment.execute(apiContext, paymentExecute);
            if (result.getState().toLowerCase().equals("approved")) {
                resultado = "Aprovado";
                EstoqueDAO.getInstance().saveAll(listaEstoque);
            }
        } catch (PayPalRESTException ex) {
            resultado = "Não aprovado";
            Logger.getLogger(PagamentoPaypal.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getPayerId() {
        return payerId;
    }

    public void setPayerId(String payerId) {
        this.payerId = payerId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

}
