/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sales.pagamento;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.CreditCard;
import com.paypal.api.payments.FundingInstrument;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import br.com.sales.compra.DAO.EstoqueDAO;
import br.com.sales.compra.model.Carrinho;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.sales.dao.vo.Cliente;
import br.com.sales.dao.vo.EstoqueVO;
import br.com.sales.dao.vo.ItemProduto;

/**
 *
 * @author Frede
 */
@ManagedBean
@SessionScoped
public class PagamentoCartao {

    private String accessToken;
    private List<EstoqueVO> listaEstoque;

    public void pagar(Cliente cliente, Carrinho carrinho) {
        try {
            Map<String, String> sdkConfig = new HashMap<String, String>();
            sdkConfig.put("mode", "sandbox");

            accessToken = new OAuthTokenCredential("AdLLg-1pTKFjOl-PZoUUoFSyhyVyX9l2y4fM55-9k9lvwH3tFv2usUzm5YyWavGXDL5iYE11M4_Mhbku", "ECCy1PqFARiICFlmxqsMjyyENJKYijXMtQ7gxIsI5OqOV_MmifFYI27DU_JUFqm9uNqfCQBaNmh_ZVWs", sdkConfig).getAccessToken();

            APIContext apiContext = new APIContext(accessToken);
            apiContext.setConfigurationMap(sdkConfig);

            CreditCard creditCard = new CreditCard();
            creditCard.setType("visa");
            creditCard.setNumber("4446283280247004");
            creditCard.setExpireMonth(11);
            creditCard.setExpireYear(2018);
            creditCard.setFirstName("Joe");
            creditCard.setLastName("Shopper");

            FundingInstrument fundingInstrument = new FundingInstrument();
            fundingInstrument.setCreditCard(creditCard);

            List<FundingInstrument> fundingInstrumentList = new ArrayList<FundingInstrument>();
            fundingInstrumentList.add(fundingInstrument);
            List<Item> items = new ArrayList<Item>();

            listaEstoque = new ArrayList<>();
            Date data = new Date();
            for (ItemProduto produto : carrinho.getListaDeProdutos()) {
                items.add(new Item(produto.getProduto().getNome(), String.valueOf(produto.getQuantidade()), String.valueOf(produto.getProduto().getPreco()), "BRL"));
                EstoqueVO estoque = new EstoqueVO();
                estoque.setProduto(produto.getProduto());
                estoque.setVenda(produto.getQuantidade());
                estoque.setData(data);
                listaEstoque.add(estoque);
            }

            ItemList list = new ItemList();
            list.setItems(items);

            Payer payer = new Payer();
            payer.setFundingInstruments(fundingInstrumentList);
            payer.setPaymentMethod("credit_card");

            Amount amount = new Amount();
            amount.setCurrency("BRL");
            amount.setTotal(String.valueOf(carrinho.getPrecoTotal()));

            Transaction transaction = new Transaction();
            transaction.setDescription("creating a direct payment with credit card");
            transaction.setAmount(amount);
            transaction.setItemList(list);

            List<Transaction> transactions = new ArrayList<Transaction>();
            transactions.add(transaction);

            Payment payment = new Payment();
            payment.setIntent("sale");
            payment.setPayer(payer);
            payment.setTransactions(transactions);

            Payment createdPayment = payment.create(apiContext);
            if (createdPayment.getState().toLowerCase().equals("approved")) {
                 EstoqueDAO.getInstance().saveAll(listaEstoque);
            }
            System.out.println(createdPayment.getState());
        } catch (PayPalRESTException ex) {
            Logger.getLogger(PagamentoCartao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
